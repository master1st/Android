package com.example.loginlecture

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var existBlank = false
    var ispwSame = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        login_button.setOnClickListener{

            //EditText로부터 입력된 값을 받아온다.
            var id = login_id.text.toString()
            var pw = login_pw.text.toString()

            //쉐어드로부터 저장된 id,pw 값을 가져오기
            val sharedPreference = getSharedPreferences("")
        }


    }
}