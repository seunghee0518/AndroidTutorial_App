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
        //binding을 액세스하는데 사용할 개체를 초기화함
        binding = ActivityMainBinding.inflate(layoutInflater)
        //활동의 콘텐츠보기를 설정함, 레이아웃의 리소스 id를 전달하는대신 뷰계층구조의 루트를 지정함
        setContentView(binding.root)

    /*
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

     */
        //주사위앱으로 가는 버튼
        val IntentToDice = Intent(this, MainActivity_Dice::class.java)

        val moveToDice: Button = findViewById(R.id.btnMoveToDice)
        moveToDice.setOnClickListener{
            startActivity(IntentToDice)
            finish()
        }


        //팁계산기앱으로 가는 버튼
        val IntentToCalculate = Intent(this, MainActivity_TipCalculator::class.java)

        val moveToCalculate: Button = findViewById(R.id.btnMoveToTips)
        moveToCalculate.setOnClickListener{
            startActivity(IntentToCalculate)
            finish()
        }
    }
}