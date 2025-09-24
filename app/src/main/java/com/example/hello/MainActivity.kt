package com.example.hello


import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 위젯 참조
        val switchStart = findViewById<Switch>(R.id.switchStart)
        val rGroup = findViewById<RadioGroup>(R.id.rGroup)
        val rdoOreo = findViewById<RadioButton>(R.id.rdoOreo)
        val rdoPie = findViewById<RadioButton>(R.id.rdoPie)
        val rdoQ = findViewById<RadioButton>(R.id.rdoQ)
        val imgAndroid = findViewById<ImageView>(R.id.imgAndroid)

        val btnExit = findViewById<Button>(R.id.btnExit)
        val btnInit = findViewById<Button>(R.id.btnInit)

        // 스위치 ON/OFF 시 라디오 그룹 보이기/숨기기
        switchStart.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                rGroup.visibility = RadioGroup.VISIBLE
                imgAndroid.visibility = ImageView.VISIBLE
            } else {
                rGroup.clearCheck()
                imgAndroid.setImageResource(0) // 이미지 초기화
                rGroup.visibility = RadioGroup.INVISIBLE
                imgAndroid.visibility = ImageView.INVISIBLE
            }
        }

        // 라디오 버튼 선택 시 이미지 즉시 변경
        rGroup.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.rdoOreo -> imgAndroid.setImageResource(R.drawable.oreo)
                R.id.rdoPie -> imgAndroid.setImageResource(R.drawable.pie)
                R.id.rdoQ -> imgAndroid.setImageResource(R.drawable.q10)
            }
        }

        // 종료 버튼
        btnExit.setOnClickListener {
            finish() // 앱 종료
        }

        // 처음으로 버튼
        btnInit.setOnClickListener {
            switchStart.isChecked = false
            rGroup.clearCheck()
            imgAndroid.setImageResource(0)
            rGroup.visibility = RadioGroup.INVISIBLE
            imgAndroid.visibility = ImageView.INVISIBLE
        }
    }
}

