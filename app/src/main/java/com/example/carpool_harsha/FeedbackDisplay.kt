package com.example.carpool_harsha

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.carpool_harsha.adapters.feedback_adapter
import com.example.carpool_harsha.models.FeedbackModel
import com.google.firebase.database.*

class FeedbackDisplay : AppCompatActivity() {
    private lateinit var adRecyclerView: RecyclerView
    private lateinit var tvLoadingData: TextView
    private lateinit var adList: ArrayList<FeedbackModel>
    private lateinit var dbRef : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_feedback)


        adRecyclerView.layoutManager = LinearLayoutManager(this)
        adRecyclerView.setHasFixedSize(true)


        adList = arrayListOf<FeedbackModel>()

        getAd_data()
    }

    private fun getAd_data() {
        adRecyclerView.visibility = View.GONE
        tvLoadingData.visibility = View.VISIBLE

        dbRef = FirebaseDatabase.getInstance().getReference("Feedback")
        dbRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                adList.clear()
                if(snapshot.exists()){
                    for (adSnap in snapshot.children){
                        val adData = adSnap.getValue(FeedbackModel ::class.java)
                        adList.add(adData!!) // !! avoid null data
                    }
                    val mAdapter = feedback_adapter(adList)
                    adRecyclerView.adapter = mAdapter

                    mAdapter.setOnItemClickListener(object : feedback_adapter.onItemClickListener{
                        override fun onItemClick(position: Int) {
                            val intent = Intent(this@FeedbackDisplay, FeedbackDetail::class.java)

                            //put extras
                            intent.putExtra("feedId",adList[position].feedId)
                            intent.putExtra("serviceTitle",adList[position].serviceTitle)
                            intent.putExtra("dreqiver",adList[position].driver)
                            intent.putExtra("feedback",adList[position].feedback)
                            intent.putExtra("about",adList[position].about)
                            startActivity(intent)
                        }

                    })

                    adRecyclerView.visibility = View.VISIBLE
                    tvLoadingData.visibility = View.GONE
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })

    }
}