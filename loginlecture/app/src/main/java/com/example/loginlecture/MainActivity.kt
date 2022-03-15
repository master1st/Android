package com.example.loginlecture

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_register.*

class MainActivity : AppCompatActivity() {
    val TAG: String = "MainActivity"
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
            val sharedPreference = getSharedPreferences("yaver_user", Context.MODE_PRIVATE)
            val savedId = sharedPreference.getString("id","")
            val savedPw = sharedPreference.getString("pw","")

            //유저가 입력한 id, pw값과 쉐어드로 불러온 id, pw값(회원가입 데이터베이스) 비교
                if(id == savedId && pw == savedPw){
                    dialog("success")
                }
                else{
                    dialog("fail")
                }
            }
            //회원가입 버튼을 누르면 다시 회원가입화면으로 돌아가도록 하게 만든것같다.
            register_button.setOnClickListener{
                val intent =  Intent(this,Register::class.java)
                startActivity(intent)
            }
    }
            fun dialog(text : String){
                var dialog = AlertDialog.Builder(this)
                if(text.equals("success")){
                    dialog.setTitle("로그인 성공")
                    dialog.setMessage("로그인에 성공하였습니다.")

                }
                else if(text.equals("fail")){
                    dialog.setTitle("로그인 에러")
                    dialog.setMessage("아이디 또는 비밀번호가 일치하지 않습니다.")

                }

                var dialog_listener = object : DialogInterface.OnClickListener
                {
                    override fun onClick(p0: DialogInterface?, p1: Int) {

                        when(p1){
                            DialogInterface.BUTTON_POSITIVE ->
                                Log.d(TAG, "")
                        }
                    }
                }

            dialog.show()
            }

}