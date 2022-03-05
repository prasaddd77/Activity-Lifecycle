package com.prasad.activitylifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MessageActivity : AppCompatActivity() {
    lateinit var txtMessageSent: TextView

    var sendMessage = "Message"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message)
        txtMessageSent = findViewById(R.id.txtMessageSent)
        if(intent != null){
           sendMessage  = intent.getStringExtra("Message").toString()
            txtMessageSent.text = sendMessage
        }
    }

}