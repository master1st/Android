package com.example.loginlecture

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_register.*

class Register : AppCompatActivity() {
    val TAG:String = "Register"
    var existBlank = false
    var ispwSame = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        register_button.setOnClickListener{
            val id = register_id.text.toString()
            val pw = register_pw.text.toString()
            val repw = register_repw.text.toString()

            if(id.isEmpty() || pw.isEmpty() || repw.isEmpty()){
                existBlank = true
            }
            else{
                    if(pw == repw){
                    ispwSame = true
                }
            }

            if(!existBlank && ispwSame){
                //회원가입 성공 토스트 메시지 띄우기
                Toast.makeText(this,"회원가입 성공",Toast.LENGTH_SHORT).show()

                //유저가 입력한 id, pw 를 쉐어드 파일에 저장하기 위해, 쉐어드 파일 이름 설정 및 공개범위 설정을 한다.
                val sharedPreference = getSharedPreferences("yaver_user", Context.MODE_PRIVATE)

                //에디터를 이용해 쉐어드 파일을 만든다.
                val editor = sharedPreference.edit()

                //사용자의 아이디와 패스워드를 에디터에 저장한다.
                editor.putString("id", id)
                editor.putString("pw", pw)
                editor.apply()

                //로그인 화면으로 이동
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
            else{
                if(existBlank){
                    dialog("blank")
                }
                else if(!ispwSame){
                        dialog("not same")
                    }
                }
            }
o
        }

        fun dialog(textmsg : String) {
            val dialog = AlertDialog.Builder(this)
            if (textmsg.equals("blank")) {
                dialog.setTitle("회원가입 에러")
                dialog.setMessage("입력칸이 비어있습니다")

            } else if (textmsg.equals("not same")) {

                dialog.setTitle("회원가입 에러")
                dialog.setMessage("비밀번호가 일치하지 않습니다.")
            }

            var dialog_listener = object : DialogInterface.OnClickListener {
                override fun onClick(p0: DialogInterface?, p1: Int) {

                    when (p1) {
                        DialogInterface.BUTTON_POSITIVE ->
                            Log.d(TAG, "")
                    }
                }
            }
        }



    }
}