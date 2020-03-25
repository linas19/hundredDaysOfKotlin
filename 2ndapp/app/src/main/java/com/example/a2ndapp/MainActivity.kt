package com.example.a2ndapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

const val FORM_EMAIL_VALUE = "com.example.myfirstapp.FORM_EMAIL_VALUE"
const val FORM_PASSWORD_VALUE = "com.example.myfirstapp.FORM_PASSWORD_VALUE"


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun sendFormData(view: View){
        val emailInput = findViewById<EditText>(R.id.emailText)
        val passwordInput = findViewById<EditText>(R.id.passwordText)
        val email = emailInput.text.toString()
        val password = passwordInput.text.toString()

        if (isFormValid(email, password) == true) {
            val intent = Intent(this, activityB::class.java).apply {
                putExtra(FORM_EMAIL_VALUE, email)
                putExtra(FORM_PASSWORD_VALUE, password)
            }

            startActivity(intent)
        }
    }
    fun isEmailValid(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
    fun isFormValid(email: String, password: String) : Boolean {
        if (email.isEmpty()) {
            Toast.makeText(this, "Email required", Toast.LENGTH_SHORT).show()
            return false
        }
        if (isEmailValid(email) == false){
            Toast.makeText(this, "Enter valid email", Toast.LENGTH_SHORT).show()
            return false
        }
        if (password.isEmpty()) {
            Toast.makeText(this, "Password required", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }
}
