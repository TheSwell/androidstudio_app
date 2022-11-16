package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    Button speedtest;
    Button typingtest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        speedtest = findViewById(R.id.speedtest);
        typingtest = findViewById(R.id.typingtest);

        speedtest.setOnClickListener(v -> {
            Intent intent = new Intent(this, SpeedTestActivity.class);
            startActivity(intent);
        });
        typingtest.setOnClickListener(v -> {
            Intent intent = new Intent(this, TypingTestActivity.class);
            startActivity(intent);
        });


    }


}