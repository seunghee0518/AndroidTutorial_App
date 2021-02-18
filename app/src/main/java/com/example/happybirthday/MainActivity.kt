package com.example.happybirthday

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val secondIntent = Intent(this, MainActivity_Dice::class.java)

        val move: Button = findViewById(R.id.btnMove)
        move.setOnClickListener{
            startActivity(secondIntent)
        }
    }
}