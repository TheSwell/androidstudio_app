package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class SpeedTestActivity extends AppCompatActivity {

    TextView clicks;
    TextView timer;
    Button button;
    TextView score;
    Button again;
    ImageButton back;
    boolean isStarted = false;

    double count = 0;
    int time = 10;
    Handler handler = new Handler();

    @SuppressLint({"SetTextI18n", "MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speed_test);

        clicks = findViewById(R.id.clicks);
        timer = findViewById(R.id.timer);
        button = findViewById(R.id.button);
        score = findViewById(R.id.score);
        again = findViewById(R.id.again);
        back = findViewById(R.id.back);

        Timer t = new Timer();
        t.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                handler.post(() -> {
                    Toast.makeText(SpeedTestActivity.this, "", Toast.LENGTH_LONG).show();
                    if (isStarted) {
                        if (time > 0)
                            time--;
                        else {
                            score.setText("You clicks in 1 second = " + (count / 10.00));
                            button.setVisibility(View.INVISIBLE);
                            again.setVisibility(View.VISIBLE);
                            time = 10;
                            isStarted = false;
                            count = 0;
                        }
                        timer.setText("Time: " + time);
                    }

                });
            }
        }, 20 * 60, 20 * 60);

        back.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });

        button.setOnClickListener(v -> {
            if (!isStarted) isStarted = true;
            if (isStarted) {
                if (time != 0) {
                    count++;
                }
                clicks.setText("Clicks: " + ((int) count));
            }
        });

        again.setOnClickListener(v -> {
            button.setVisibility(View.VISIBLE);
            again.setVisibility(View.INVISIBLE);
        });
    }
}