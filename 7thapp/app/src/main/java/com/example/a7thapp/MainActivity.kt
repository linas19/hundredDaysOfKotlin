package com.example.a7thapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.core.graphics.alpha
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun hideImage(view: View){
        println("Hello")
        if (imageView4.visibility == View.INVISIBLE){
            imageView4.visibility = View.VISIBLE
        } else {
            imageView4.visibility = View.INVISIBLE
        }
    }
}
