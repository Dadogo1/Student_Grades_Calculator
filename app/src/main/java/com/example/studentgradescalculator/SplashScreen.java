package com.example.studentgradescalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        //To start the splash screen
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent to_student_grade_data_input = new Intent(SplashScreen.this, InputData.class);
                startActivity(to_student_grade_data_input);
                finish();
            }
        }, 3000);

    }
}