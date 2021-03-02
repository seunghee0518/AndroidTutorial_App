package com.example.AndroidTutorial_App

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.AndroidTutorial_App.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity_TipCalculator : AppCompatActivity() {
    //뷰바인딩을 사용하는 코드
    //바인딩개체에 대한 클래스의 최상위 변수를 선언함
    //lateinit: 코드가 변수를 사용하기전 초기화함, 그렇지 않으면 앱이 충돌함
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //binding을 액세스하는데 사용할 개체를 초기화함
        binding = ActivityMainBinding.inflate(layoutInflater)
        //활동의 콘텐츠보기를 설정함, 레이아웃의 리소스 id를 전달하는대신 뷰계층구조의 루트를 지정함
        setContentView(binding.root)
        //UI를 확인하고 팁을 계산하는 코드(id:btnCalculateButton)
        binding.btnCalculateButton.setOnClickListener{ calculateTip() }

        //되돌아가기 버튼
        val BackToBirthday = Intent(this, MainActivity::class.java)

        val Back: Button = findViewById(R.id.btnBack)
        Back.setOnClickListener {
            startActivity(BackToBirthday)

        }

    }

    private fun calculateTip() {
        //edittext값을 가져옴(id:pt_costService, hint:cost_of_service)
        val stringInTextField = binding.ptCostService.text.toString()
        val cost = stringInTextField.toDoubleOrNull()
        //id=tvTipResult
        if (cost == null) {
            binding.tvTipResult.text =""
            return
        }

        //rg_tipOptions의 checkedRadioButtonId 속성을 가져와 selectedId에 할당
        val selectedId = binding.rgTipOptions.checkedRadioButtonId

        //팁 비율 얻기
        val tipPercentage = when (selectedId) {
            R.id.rbOptionTwentyPercent -> 0.20
            R.id.rbOptionEighteenPercent -> 0.18
            else -> 0.15
        }
        //var인 이유:사용자가 반올림 옵션을 선택하는 경우 값이 변경되기 때문에
        var tip = tipPercentage * cost

        //For a 'Switch' element, you can check the 'isChecked' attribute to see if the switch is "on".

        //반올림스위치(id:swRoundUp)에 변수 할당
        if (binding.swRoundUp.isChecked) {
            tip = kotlin.math.ceil(tip)
        }
        //숫자를 통화형식으로 변환
        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
        //포맷된 통화가 삽입될 것(id :tv_tipResult)
        binding.tvTipResult.text = getString(R.string.tip_amount, formattedTip)

}