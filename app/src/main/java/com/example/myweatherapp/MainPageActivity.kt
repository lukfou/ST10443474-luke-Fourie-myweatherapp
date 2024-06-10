package com.example.myweatherapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.page_main)

        findViewById<EditText>(R.id.editText)
        findViewById<Button>(R.id.Clearbtn)
        findViewById<Button>(R.id.Enterbtn)

        Clearbtn.setOnClickListener {
            editText.text.clear()
        }

        Enterbtn.setOnClickListener {
            val intent = Intent(this, MainDisplayActivity::class.java)
            intent.putExtra("selectedDay", editText.text.toString())
            startActivity(intent)
        }
    }


    }






