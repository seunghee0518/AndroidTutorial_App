package com.example.happybirthday

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity_Dice : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main__dice)

        //굴리기 버튼
        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }

        //되돌아가기 버튼
        val back: Button = findViewById(R.id.btnBack)
        back.setOnClickListener {
            finish()
        }
    }
    //주사위 굴리고, 그 결과를 스크린에 업데이터함
    private fun rollDice() {
        //새로운 6면 주사위를 만들고 굴리기
        val dice = Dice(6)
        val diceRoll = dice.roll()

        //주사위굴린 화면을 업데이트함함
       val resultTextView: TextView = findViewById(R.id.textView)
        resultTextView.text = diceRoll.toString()
    }
}

//클래스 Dice 입력
class Dice(val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}