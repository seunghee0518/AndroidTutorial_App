package com.example.AndroidTutorial_App

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity_Dice : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main__dice)

        //굴리기 버튼
        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }

        //처음화면에 임의의 주사위 이미지와 기본 텍스트 표시함
        rollDice()
        val defaultPrint : TextView = findViewById(R.id.tv_result)
        defaultPrint.setText("Roll the dice!")

        //되돌아가기 버튼
        val BackToBirthday = Intent(this, MainActivity::class.java)

        val back: Button = findViewById(R.id.btnBack)
        back.setOnClickListener{
            startActivity(BackToBirthday)
        }
    }

    //주사위 굴리고, 그 결과를 스크린에 업데이터함
    private fun rollDice() {
        //새로운 6면 주사위를 만들고 굴리기
        val dice = Dice(6)
        val diceRoll = dice.roll()

        //주사위굴린 화면을 업데이트함함
        val diceImage: ImageView = findViewById(R.id.imageView)

        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        diceImage.setImageResource(drawableResource)

        //스크린리더설명 더하기
        diceImage.contentDescription = diceRoll.toString()

        //tv_result 값 업데이트
        val resultPrint : TextView = findViewById(R.id.tv_result)

        when (diceRoll) {
            1 -> resultPrint.setText("So sorry! you rolled a 1. Try again!")
            2 -> resultPrint.setText("Sadly, you rolled a 2. Try again!")
            3 -> resultPrint.setText("Unfortunately, you rolled a 3.\n Try again!")
            4 -> resultPrint.setText("Don`t cry! you rolled a 4. Try again!")
            5 -> resultPrint.setText("Apologies! you rolled a 5. Try again!")
            6 -> resultPrint.setText("you won! you rolled a 6.")
        }
    }
}

//클래스 Dice 입력
class Dice(val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}