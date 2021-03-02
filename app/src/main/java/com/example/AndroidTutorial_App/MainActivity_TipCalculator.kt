package com.example.AndroidTutorial_App

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity_TipCalculator : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main__tip_calculator)


        val back: Button = findViewById(R.id.btn_back)
        back.setOnClickListener {
            finish()
    }
}