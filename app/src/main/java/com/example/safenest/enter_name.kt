package com.example.safenest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class enter_name : AppCompatActivity() {
    private lateinit var btnNext : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enter_name)

        // Find the button with the ID MoveToHome
        btnNext = findViewById(R.id.MoveToHome)

        btnNext.setOnClickListener{
            val intent = Intent(this, period::class.java)
            startActivity(intent)
        }
    }
}
