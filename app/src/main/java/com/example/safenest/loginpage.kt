package com.example.safenest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LoginPage : AppCompatActivity() {
    private lateinit var btnLogin: Button
    private lateinit var homeNameTextView: TextView
    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var dbHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loginpage)
        btnLogin = findViewById(R.id.buttonLogin)
        usernameEditText = findViewById(R.id.login_username)
        passwordEditText = findViewById(R.id.login_password)

        dbHelper = DatabaseHelper(this)

        btnLogin.setOnClickListener {
            val username = usernameEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()
            val isValidUser = dbHelper.checkUser(username, password)

            if (isValidUser) {
                val loginCounter = dbHelper.getLoginCounterByUsername(username)
                if (loginCounter == 0) {
                    navigateToFirstLoginLayouts(username, password)
                    dbHelper.incrementLoginCounter(username)
                } else {
                    navigateToHome(username, password)
                }
            } else {
                Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun navigateToHome(username: String, password: String) {
        val intent = Intent(this, home::class.java)
        intent.putExtra("username", username)
        intent.putExtra("password", password)
        startActivity(intent)
        finish()
    }

    private fun navigateToFirstLoginLayouts(username: String, password: String) {
        val intent = Intent(this, SelectLanguage::class.java)
        intent.putExtra("username", username)
        intent.putExtra("password", password)
        startActivity(intent)
        finish()
    }
}

