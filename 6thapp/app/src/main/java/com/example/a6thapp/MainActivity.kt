package com.example.a6thapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var selectedCheckbox = mutableListOf<CharSequence>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun buttonClicked(view: View){
        var displayText = ""
        selectedCheckbox.forEach {
            print(it)
            val index = selectedCheckbox.indexOf(it)
            if (index == selectedCheckbox.count() - 1 && selectedCheckbox.count() > 1){
                displayText = displayText + "and " + it + " "
            } else if (index == selectedCheckbox.count() - 2 || selectedCheckbox.count() == 1){
                displayText = displayText  + it + " "
            } else {
                displayText = displayText  + it + ", "
            }
        }
        if (displayText == ""){
            displayText = "No checkbox"
        }
        bottomTextView.text = displayText + " selected"
    }
    fun onCheckboxClicked(view: View) {
        if (view is CheckBox) {
            val checked: Boolean = view.isChecked

            when (view.id) {
                R.id.checkBox -> {
                    var checkboxText = findViewById<TextView>(R.id.CTextView1)
                    if (checked) {
                        selectedCheckbox.add(checkboxText.text)
                    } else {
                        selectedCheckbox.remove(checkboxText.text)
                    }
                }
                R.id.checkBox2 -> {
                    var checkboxText = findViewById<TextView>(R.id.CTextView2)

                    if (checked) {
                        selectedCheckbox.add(checkboxText.text)
                    } else {
                        selectedCheckbox.remove(checkboxText.text)
                    }
                }
                R.id.checkBox3 -> {
                    var checkboxText = findViewById<TextView>(R.id.CTextView3)
                    if (checked) {
                        selectedCheckbox.add(checkboxText.text)
                    } else {
                        selectedCheckbox.remove(checkboxText.text)
                    }
                }
                R.id.checkBox4 -> {
                    var checkboxText = findViewById<TextView>(R.id.CTextView4)
                    if (checked) {
                        selectedCheckbox.add(checkboxText.text)
                    } else {
                        selectedCheckbox.remove(checkboxText.text)
                    }
                }
            }
            println(selectedCheckbox)
        }
    }
}
