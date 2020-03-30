package com.example.a9thapp

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.BaseColumns
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Spinner

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        seedData()
        readData()
        val items = readData()
        println(items)
        val spinner: Spinner = findViewById(R.id.spinner3)
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            items
        )
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
        spinner.adapter = adapter;
    }

    fun seedData() {
        val dbHelper = FoodDbHelper(this)
//         Gets the data repository in write mode
        val db = dbHelper.writableDatabase

// Create a new map of values, where column names are the keys
        val values = ContentValues().apply {
            put(FoodContract.FoodEntry.COLUMN_NAME_NAME, "oranges")
        }

// Insert the new row, returning the primary key value of the new row
        val newRowId = db?.insert(FoodContract.FoodEntry.TABLE_NAME, null, values)
        println(newRowId)
    }

    fun readData():MutableList<String>{
        val dbHelper = FoodDbHelper(this)
        val db = dbHelper.readableDatabase
        println("hello")
// Define a projection that specifies which columns from the database
// you will actually use after this query.
        val projection = arrayOf(BaseColumns._ID, FoodContract.FoodEntry.COLUMN_NAME_NAME)

        val cursor = db.query(
            FoodContract.FoodEntry.TABLE_NAME,   // The table to query
            projection,             // The array of columns to return (pass null to get all)
            null,              // The columns for the WHERE clause
            null,          // The values for the WHERE clause
            null,                   // don't group the rows
            null,                   // don't filter by row groups
            null               // The sort order
        )
        println(cursor)
        val items = mutableListOf<String>()
        with(cursor) {
            while (moveToNext()) {
                val name = getString(getColumnIndexOrThrow(FoodContract.FoodEntry.COLUMN_NAME_NAME))
                items.add(name)
            }
        }
        return items
    }
}

