package com.example.carpool_harsha

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class Feedback : AppCompatActivity() {
    private lateinit var etServiceTitle : EditText
    private lateinit var etProviderName : EditText
    private lateinit var etFeedback : EditText
    private lateinit var etAbout : EditText
    private lateinit var btSubbmit : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
     //   setContentView(R.layout.activity_feedback)

        //initialization
     //   etServiceTitle = findViewById(R.id.addsertitle)
      // etProviderName = findViewById(R.id.addprname)
        //etFeedback = findViewById(R.id.addfee)
       // etAbout = findViewById(R.id.addidea)
      //  btSubbmit = findViewById(R.id.button6)
       // dbRef = FirebaseDatabase.getInstance().getReference("Feedback")
        btSubbmit.setOnClickListener {
            saveFeedbackData()
        }

//        var feedbackSubmitButton = findViewById<Button>(R.id.button6)
//        feedbackSubmitButton.setOnClickListener {
//        val submit= Intent (this, feedbackDetailedActivity::class.java)
//        startActivity(submit)
//        }
    }

    private fun saveFeedbackData(){

        //getting values
        val serviceTitle = etServiceTitle.text.toString()
        val providerName= etProviderName.text.toString()
        val feedback = etFeedback.text.toString()
        val about = etAbout.text.toString()

        if(serviceTitle.isEmpty()){
            etServiceTitle.error="Please enter valid Service Title"
        }
        if(providerName.isEmpty()){
            etProviderName.error="Please enter valid Provider Name"
        }
        if(feedback.isEmpty()){
            etFeedback.error="Please enter Feedback"
        }
        if(about.isEmpty()){
            etAbout.error="Please enter About"
        }

   //     val feedId = dbRef.push().key!!
     //   val feedbackModel = FeedbackModel(feedId,serviceTitle,providerName,feedback,about)

      //  dbRef.child(feedId).setValue(feedbackModel)
       //     .addOnCompleteListener {
                Toast.makeText(this,"Data inserted successfully", Toast.LENGTH_LONG).show()
                etServiceTitle.text.clear()
                etProviderName.text.clear()
                etFeedback.text.clear()
                etAbout.text.clear()
      //      }.addOnFailureListener{ err->
              //  Toast.makeText(this," Error ${err.message}", Toast.LENGTH_LONG).show()

            }
    //}
}