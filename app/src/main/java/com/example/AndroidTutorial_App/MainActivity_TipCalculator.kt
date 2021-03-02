package com.example.AndroidTutorial_App

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.AndroidTutorial_App.databinding.ActivityMainBinding

class MainActivity_TipCalculator : AppCompatActivity() {
    //뷰바인딩을 사용하는 코드
    //바인딩개체에 대한 클래스의 최상위 변수를 선언함
    //lateinit: 코드가 변수를 사용하기전 초기화함, 그렇지 않으면 앱이 충돌함
    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //binding을 액세스하는데 사용할 개체를 초기화함
        binding = ActivityMainBinding.inflate(layoutInflater)
        //활동의 콘텐츠보기를 설정함, 레이아웃의 리소스 id를 전달하는대신 뷰계층구조의 루트를 지정함
        setContentView(binding.root)

        //되돌아가기 버튼
        val BackToBirthday = Intent(this, MainActivity::class.java)

        val Back: Button = findViewById(R.id.btn_back)
        Back.setOnClickListener {
            startActivity(BackToBirthday)

        }
    }
}