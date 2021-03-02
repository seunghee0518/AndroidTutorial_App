package com.example.AndroidTutorial_App

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val secondIntent = Intent(this, MainActivity_Dice::class.java)

        val moveToDice: Button = findViewById(R.id.btnMoveToDice)
        moveToDice.setOnClickListener{
            startActivity(secondIntent)
        }

        val moveToCalculate: Button = findViewById(R.id.btnMoveToTips)
        moveToCalculate.setOnClickListener{
            startActivity(MainActivity_TipCalculator)
    }
}