package com.example.safenest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class period : AppCompatActivity() {
    private lateinit var periodNext: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_period)
        periodNext =findViewById(R.id.btnNext)
        periodNext.setOnClickListener(){
            val intent = Intent(this, home::class.java)
            startActivity(intent)
            finish();
        }

    }
}