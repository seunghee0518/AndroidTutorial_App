package com.example.AndroidTutorial_App

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity_TipTime : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main__tip_time)

        //되돌아가기 버튼
        val BackToBirthday: Button = findViewById(R.id.btnToBack)
        BackToBirthday.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }


    }
}