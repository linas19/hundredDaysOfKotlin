package com.example.a5thapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        radioGroup.clearCheck()
        radioGroup.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { radioGroup, checkedID ->
            var radioButtonPosition = ""
            when(checkedID){
                R.id.radioButton -> radioButtonPosition = "fourth"
                R.id.radioButton2 -> radioButtonPosition = "third"
                R.id.radioButton3 -> radioButtonPosition = "second"
                R.id.radioButton4 -> radioButtonPosition = "first"
            }
            textView.text = "You have selected the "+ radioButtonPosition +" RadioButton"
        })
    }
}
