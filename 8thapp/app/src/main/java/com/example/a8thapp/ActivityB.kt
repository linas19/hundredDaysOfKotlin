package com.example.a8thapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_b.*

class ActivityB : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)
        val sharedPref = getSharedPreferences(LOGIN_PREF, Context.MODE_PRIVATE)
        usernameTextView.text = sharedPref.getString(USERNAME_PREF_KEY, "")
    }

    fun logOut(view: View){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}
