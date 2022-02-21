package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button btn_move;
    private EditText Text_id;
    private String str;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Text_id = findViewById(R.id.Text_id);

        btn_move = findViewById(R.id.btn_move);
        btn_move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str = Text_id.getText().toString();
                Intent intent = new Intent(MainActivity.this, SubActivity.class); //화면전환
                intent.putExtra("str",str); //str
                startActivity(intent); //intent라는 객체 생성자에는 메인액티비티에서 서브로 이동가능 Intent사용

            }
        });
    }
}