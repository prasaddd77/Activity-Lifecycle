package com.prasad.activitylifecycle

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class AvengersActivity : AppCompatActivity(){
    lateinit var etMessage: EditText

    lateinit var btnSend: Button

    lateinit var sharedPreferences: SharedPreferences

    var titleName : String? = "Avengers"
    lateinit var btnlogout: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedPreferences = getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE)

        setContentView(R.layout.activity_avengers)
        titleName = sharedPreferences.getString("Title", "The Avengers")
    title = titleName
        etMessage = findViewById(R.id.etMessage)
        btnSend = findViewById(R.id.btnSend)

        btnlogout = findViewById(R.id.btnLogOut)

        btnSend.setOnClickListener{
            val intent = Intent(this@AvengersActivity, MessageActivity::class.java)
            val message = etMessage.text.toString()
            intent.putExtra("Message", message)
            startActivity(intent)
        }
        btnlogout.setOnClickListener{
            startActivity(Intent(this@AvengersActivity, LoginActivity::class.java))
            sharedPreferences.edit().clear().apply()
            finish()
        }
    }

}