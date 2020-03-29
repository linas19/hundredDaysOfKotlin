package com.example.a8thapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

const val PASSWORD_PREF_KEY = "com.jonika.8thapp.PASSWORD_PREF_KEY"
const val USERNAME_PREF_KEY = "com.jonika.8thapp.USERNAME_PREF_KEY"
const val LOGIN_PREF = "com.jonika.8thapp.LOGIN_PREF"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sharedPref = this.getSharedPreferences(LOGIN_PREF, Context.MODE_PRIVATE) ?: return

        with (sharedPref.edit()) {
            putString(PASSWORD_PREF_KEY, "hello")
            putString(USERNAME_PREF_KEY, "hello2")
            commit()
        }
    }

    fun isFormValid(username: String, password: String) : Boolean {
        if(username.isEmpty()) {
            Toast.makeText(this, "Username required", Toast.LENGTH_SHORT).show()
            return false
        }
        if (password.isEmpty()) {
            Toast.makeText(this, "Password required", Toast.LENGTH_SHORT).show()
            return false
        }

        val sharedPref = getSharedPreferences(LOGIN_PREF, Context.MODE_PRIVATE)
        if (sharedPref.getString(PASSWORD_PREF_KEY, "") != password) {
            Toast.makeText(this, "Password incorrect", Toast.LENGTH_SHORT).show()
            return false
        }
        if (sharedPref.getString(USERNAME_PREF_KEY, "") != username){
            Toast.makeText(this, "Username incorrect", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }

    fun buttonClicked(view: View){
        val password = password.text.toString()
        val username = username.text.toString()
        if(isFormValid(username, password) == true) {
            val intent = Intent(this, ActivityB::class.java)
            startActivity(intent)
        }

    }
}
