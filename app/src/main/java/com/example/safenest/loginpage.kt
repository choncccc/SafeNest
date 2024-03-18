package com.example.safenest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class LoginPage : AppCompatActivity() {
    private lateinit var btnLogin: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loginpage)
        btnLogin= findViewById(R.id.buttonLogin)

        btnLogin.setOnClickListener{
            val intent = Intent(this, SelectLanguage::class.java)
            startActivity(intent)
        }
    }
}