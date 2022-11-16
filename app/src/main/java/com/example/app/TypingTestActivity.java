package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TypingTestActivity extends AppCompatActivity {
    List<String> words;
    TextView texts;
    TextView textbox;
    Button commit;
    int i = 0;
    String newText;
    String s;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_typing_test);
        texts = findViewById(R.id.texts);
        textbox = findViewById(R.id.textbox);
        commit = findViewById(R.id.commit);
        String word = (String) texts.getText();
        words = Arrays.asList(word.split("\\s+"));
        System.out.println(words.get(0));

        commit.setOnClickListener(v -> {
            System.out.println(textbox.getText().toString().equals(words.get(i)) + "");
            System.out.println(textbox.getText() + " " + words.get(i));
            for (int j = i; j < words.size(); j++) {
                if (!words.get(i).equals(words.get(j)))
                    if (s != null)
                        s = s + " " + words.get(j);
                    else s = words.get(j);
            }
            if (textbox.getText().toString().equals(words.get(i))) {
                if (newText == null)
                    newText = "<font color='green'>" + words.get(i) + "</font>" + " ";
                else
                    newText = newText + "<font color='green'>" + words.get(i) + "</font>" + " ";
            }else {
                if (newText == null)
                    newText = "<font color='red'>" + words.get(i) + "</font>" + " ";
                else
                    newText = newText + "<font color='red'>" + words.get(i) + "</font>" + " ";
            }
            textbox.setText("");
            texts.setText(Html.fromHtml(newText + s));
            s = "";
            i++;

        });

    }
}