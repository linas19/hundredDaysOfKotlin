package com.example.a1stapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text
import kotlin.random.Random

const val EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val messageFromB = intent.getStringExtra(EXTRA_MESSAGE_TO_MAIN)
        if (null != messageFromB){
            val textView = findViewById<TextView>(R.id.pageAText).apply {
                text = messageFromB
            }
        } else {
            val textView = findViewById<TextView>(R.id.pageAText).apply {
                text = Random.nextInt(0, 100).toString()
            }
        }
    }

    fun sendMessage(view: View) {
        val editText = findViewById(R.id.pageAText) as TextView
        val message = editText.text.toString()
        val intent = Intent(this, ActivityB::class.java).apply {
            putExtra(EXTRA_MESSAGE, message)
        }
        startActivity(intent)
    }
}
