package com.example.carpool.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.carpool_harsha.FeedbackDisplay
import com.example.carpool_harsha.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var button4 = findViewById<Button>(R.id.button4)
        button4.setOnClickListener {
            val intent1= Intent (this, FeedbackDisplay::class.java)
            startActivity(intent1)
        }
    }
}