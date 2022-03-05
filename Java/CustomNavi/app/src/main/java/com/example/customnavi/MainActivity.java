package com.example.customnavi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawerz;
    private View drawerview;
    private Button opendrawer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerz = (DrawerLayout)findViewById(R.id.drawerz);
        drawerview = (View)findViewById(R.id.drawervie);
        opendrawer = (Button) findViewById(R.id.open_drawer);
        opendrawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerz.openDrawer(drawerview);
            }
        });
        opendrawer

        drawerz.setDrawerListener(listener);
        drawerz.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
    }
}