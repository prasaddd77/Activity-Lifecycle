package com.prasad.activitylifecycle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class RegisterActivity : AppCompatActivity() {
    lateinit var etEnterNumber: EditText
    lateinit var etEnterPassword: EditText
    lateinit var btnRegister: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        etEnterNumber = findViewById(R.id.etEnterNumber)
        etEnterPassword = findViewById(R.id.etEnterPassword)
        btnRegister = findViewById(R.id.btnRegister)

        btnRegister.setOnClickListener {
            val enterNumber = etEnterNumber.text.toString()
            val enterPassword = etEnterPassword.text.toString()
            val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

    }

    override fun onPause() {
        super.onPause()
        finish()
    }
}