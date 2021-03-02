package com.example.AndroidTutorial_App

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity_TipCalculator : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main__tip_calculator)

        //되돌아가기 버튼
        val BackToBirthday = Intent(this, MainActivity::class.java)

        val Back: Button = findViewById(R.id.btn_back)
        Back.setOnClickListener {
            startActivity(BackToBirthday)

        }
    }
}