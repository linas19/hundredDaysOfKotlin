package com.example.a2ndapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class activityB : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)
        // Get the Intent that started this activity and extract the string
        val email = intent.getStringExtra(FORM_EMAIL_VALUE)
        val password = intent.getStringExtra(FORM_PASSWORD_VALUE)

        // Capture the layout's TextView and set the string as its text
        val emailView = findViewById<TextView>(R.id.emailTextView).apply {
            text = email
        }
        val passwordView = findViewById<TextView>(R.id.passwordTextView).apply {
            text = password
        }
    }
}
