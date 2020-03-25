package com.example.a3rdapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun selectTheme(view: View){
        var themeName = spinner.getSelectedItem().toString();
        if (themeName == "Select an option"){
            Toast.makeText(this, themeName, LENGTH_LONG).show()
        } else {
            selectedValue.text = themeName
        }
    }
}
