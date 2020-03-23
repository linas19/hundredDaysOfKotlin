package com.example.a1stapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.content.Intent
import android.view.View
import kotlin.random.Random

const val EXTRA_MESSAGE_TO_MAIN = "asasasas"
class ActivityB : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)
        val message = intent.getStringExtra(EXTRA_MESSAGE)
        val textView = findViewById<TextView>(R.id.textView).apply {
            text = message
        }

    }
    fun sendMessageToMain(view: View) {

        val message = Random.nextInt(0, 100).toString()

        val intent = Intent(this, MainActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE_TO_MAIN, message)
        }
        startActivity(intent)
    }
}
