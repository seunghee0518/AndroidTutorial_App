package com.example.AndroidTutorial_App

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.AndroidTutorial_App.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //주사위앱으로 가는 버튼
        val moveToDice: Button = findViewById(R.id.btnMoveToDice)
            moveToDice.setOnClickListener{
            startActivity(Intent(this, MainActivity_Dice::class.java))
            finish()
        }

        //팁계산기앱으로 가는 버튼
        val moveToCalculate: Button = findViewById(R.id.btnMoveToTips)
            moveToCalculate.setOnClickListener{
            startActivity(Intent(this, MainActivity_TipCalculator::class.java))
            finish()
        }

        //팁타임앱으로 가는 버튼
        val moveToTime: Button = findViewById(R.id.btnMoveToTime)
        moveToTime.setOnClickListener{
            startActivity(Intent(this, MainActivity_TipTime::class.java))
            finish()
        }
    }
}