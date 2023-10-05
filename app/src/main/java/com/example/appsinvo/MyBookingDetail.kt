package com.example.appsinvo

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MyBookingDetail : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_booking_detail)

        val id: TextView = findViewById(R.id.txtIdNo)
        val title: TextView = findViewById(R.id.txtTitleWrite)
        val body: TextView = findViewById(R.id.txtBodyWrite)

        val selectedItemId = intent.getStringExtra("Id")
        val selectedItemTitle = intent.getStringExtra("Title")
        val selectedItemBody = intent.getStringExtra("body")

        id.text = "Id: $selectedItemId"
        title.text = "Title: $selectedItemTitle"
        body.text = "Body: $selectedItemBody"


    }
}