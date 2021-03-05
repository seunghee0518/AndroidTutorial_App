package com.example.AndroidTutorial_App

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.AndroidTutorial_App.databinding.ActivityMainTipCalculatorBinding
import java.text.NumberFormat
import kotlin.math.ceil

class MainActivity_TipCalculator : AppCompatActivity() {
    /*
    뷰바인딩을 사용하는 코드
    뷰바인딩 사용시 변화(참조시 밑줄 제거되고, 뷰 이름을 카멜케이스(단어간의 띄어쓰기대신 대문자로 됨)로 변환함
    activity_main.xml -> ActivityMainBindind
    @id/text_view -> binding.textView

    바인딩개체에 대한 클래스의 최상위 변수를 선언함
    lateinit: 코드가 변수를 사용하기전 초기화함, 그렇지 않으면 앱이 충돌함
    사용할 xml파일명 확인하기(activity_main_tip_calculator.xml->ActivityMainTipCalculatorBinding)
    */
    private lateinit var binding: ActivityMainTipCalculatorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //binding을 액세스하는데 사용할 개체를 초기화함
        binding = ActivityMainTipCalculatorBinding.inflate(layoutInflater)
        //활동의 콘텐츠보기를 설정함, 레이아웃의 리소스 id를 전달하는대신 뷰계층구조의 루트를 지정함
        setContentView(binding.root)

        //UI를 확인하고 팁을 계산하는 코드(id:btn_calculateButton)
        /*
        //오래된 방법
        val calculateButton: Button = findViewById(R.id.btn_calculateButton)
        calculateButton.setOnClickListener { calculateTip() }
        //나은 방법
        val calculateButton : Button = binding.btnCalculateButton
        calculateButton.setOnClickListener{ calculateTip()}
        */
        //좋은 방법
        binding.btnCalculateButton.setOnClickListener { calculateTip() }

        //되돌아가기 버튼
        val BackToBirthday: Button = findViewById(R.id.btnBack)
            BackToBirthday.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

    private fun calculateTip() {
        //서비스 비용 받기&10진수로 바꾸기
        /*
        edittext값을 가져옴(id:pt_costOfService, hint:cost_of_service)
        //오래된 버전
        val stringInTextField: EditText = findViewById(R.id.pt_costOfService)
        stringInTextField.text.toString()
        val cost = stringInTextField.toDoubleOrNull()
        //나은 버전
        val ptCostService: EditText = binding.ptCostService
        ptCostService.text.toString()
        val cost = stringInTextField.toDoubleOrNull()
        */
        //좋은 방법
        val stringInTextField = binding.ptCostOfService.text.toString()
        val cost = stringInTextField.toDoubleOrNull()

        //id=tv_TipResult
        /*
        //오래된 버전
        if (cost == null) {
            val tvTipResult: TextView = findViewById(R.id.tv_tipResult)
            tvTipResult.text = ""
            return
        }
        //나은버전
        if  (cost == null) {
            val tvTipResult: TextView = binding.tvTipResult
            tvTipResult.text = ""
            return
        }
        */
        //좋은 버전
        if (cost == null ) {
            binding.tvTipResult.text =""
            return
        }

        /*
        팁비율얻기
        rg_tipOptions의 checkedRadioButtonId 속성을 가져와 selectedId에 할당
        //오래된 버전
        val selectedId: RadioGroup = findViewById(R.id.rg_tipOptions)
        selectedId.checkedRadioButtonId

        val tipPercentage = when (selectedId) {
            R.id.rb_optionTwentyPercent -> 0.20
            R.id.rb_optionEighteenPercent -> 0.18
            else -> 0.15

        //나은 버전
        val selectedId : RadioGroup = binding.rgTipOptions
        selectedId.checkedRadioButtonId
        val tipPercentage = when (selectedId) {
            R.id.rb_optionTwentyPercent -> 0.20
            R.id.rb_optionEighteenPercent -> 0.18
            else -> 0.15
        */
        //좋은 버전
        val tipPercentage = when (binding.rgTipOptions.checkedRadioButtonId){
            R.id.rb_optionTwentyPercent -> 0.20
            R.id.rb_optionEighteenPercent -> 0.18
            else -> 0.15
        }

        /*
        팁을 계산하고 반올림하기
        var인 이유:사용자가 반올림 옵션을 선택하는 경우 값이 변경되기 때문에
        반올림스위치(id:sw_roundUp)에 변수 할당
        //오래된 버전
        var Tip = tipPercentage * cost
        val roundUp: Switch = findViewById(R.id.sw_roundUp)
        roundUp.isChecked
        if (roundUp) {
            Tip = ceil(Tip)
        }

        //나은버전
        var tip = tipPercentage * cost
        val roundUp: Switch = binding.swRoundUp
        roundUp.isChecked
        if (roundUp) {
            tip = kotlin.math.ceil(tip)
        }
        */
        //좋은버전
        var tip = tipPercentage * cost
        if (binding.swRoundUp.isChecked) {
            tip = ceil(tip)
        }

        /*
        팁서식 지정
        숫자를 통화형식으로 변환
        포맷된 통화가 삽입될 것(id :tv_tipResult)
        //오래된 방법
        val formattedTip = NumberFormat.getCurrencyInstance().format(Tip)
        val tvTipResult: TextView = findViewById(R.id.tv_tipResult)
        tvTipResult.text = "Tip Amount : {formattedTip}"

        //나은 방법
        val tvTipResult: TextView = binding.tvtipResult
        tvTipResult.text = "Tip Amount : {formattedTip}"

         */
        //좋은 방법
        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
        binding.tvTipResult.text = getString(R.string.tip_amount, formattedTip)
    }
}