package com.prasad.activitylifecycle

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LoginActivity : AppCompatActivity(){

    lateinit var etNumber: EditText
    lateinit var etNewPassword: EditText
    lateinit var btnSignIn: Button
    lateinit var txtForgotPassword: TextView
    lateinit var txtRegisterYourself: TextView
    val validNumber = "9920336524"

    val validNewPassword = arrayOf("tony", "steve", "thor", "hulk", "wakandaforever", "blackwidow")

    lateinit var sharedPreferences: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        sharedPreferences = getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE)

        val isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false)

        setContentView(R.layout.activity_login)

        if(isLoggedIn) {
            val intent = Intent(this@LoginActivity, AvengersActivity::class.java)
            startActivity(intent)
            finish()
        }

        title = "Log In"
        etNumber = findViewById(R.id.etNumber)
        etNewPassword = findViewById(R.id.etNewPassword)
        btnSignIn = findViewById(R.id.btnSignIn)
        txtForgotPassword = findViewById(R.id.txtForgotPassword)
        txtRegisterYourself = findViewById(R.id.txtRegisterYourself)
        txtForgotPassword.setOnClickListener{
            val intent = Intent(this@LoginActivity, ForgotPasswordActivity::class.java)
            startActivity(intent)
            finish()
        }
        txtRegisterYourself.setOnClickListener {
            val intent = Intent(this@LoginActivity, RegisterActivity::class.java)
            startActivity(intent)
            finish()
        }

        btnSignIn.setOnClickListener{

            val number = etNumber.text.toString()
            val newpassword = etNewPassword.text.toString()
            var nameOfAvenger = "Avenger"
            val intent = Intent(this@LoginActivity, AvengersActivity::class.java)

            if((number == validNumber))  {

                when(newpassword){
                    validNewPassword[0] ->  {

                        nameOfAvenger = "Iron Man"

                        savePreferences(nameOfAvenger)


                        startActivity(intent)
                    }
                    validNewPassword[1] -> {

                        nameOfAvenger = "Captain America"

                        savePreferences(nameOfAvenger)

                        startActivity(intent)
                    }

                    validNewPassword[2] -> {

                        nameOfAvenger = "Thor"

                        savePreferences(nameOfAvenger)

                        startActivity(intent)
                    }
                    validNewPassword[3] -> {

                        nameOfAvenger = "The Hulk"

                        savePreferences(nameOfAvenger)

                        startActivity(intent)
                    }
                    validNewPassword[4] -> {

                        nameOfAvenger = "Black Panther"

                        savePreferences(nameOfAvenger)

                        startActivity(intent)
                    }
                    validNewPassword[5] -> {

                        nameOfAvenger = "Black Widow"

                        savePreferences(nameOfAvenger)

                        startActivity(intent)
                    }
                    else -> Toast.makeText(
                            this@LoginActivity,
                            "Invalid Username or Password.",
                            Toast.LENGTH_LONG
                        ).show()
                }
            }
        }
    }
    override fun onPause() {
        super.onPause()
        finish()
    }
    fun savePreferences(title: String){
        sharedPreferences.edit().putBoolean("isLoggedIn", true).apply()
        sharedPreferences.edit().putString("Title", title).apply()
    }



}