package com.example.a9thapp

import android.provider.BaseColumns

object FoodContract {
    // Table contents are grouped together in an anonymous object.
    object FoodEntry : BaseColumns {
        const val TABLE_NAME = "food"
        const val COLUMN_NAME_NAME = "name"
    }
}

