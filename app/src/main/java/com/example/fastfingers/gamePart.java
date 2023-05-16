package com.example.fastfingers;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class gamePart extends AppCompatActivity {

    TextView tv_text,tv_result;
    EditText et_text;
    Button b_new;
    String fullStory;

    long startTime,endTime;
    boolean gameStarted = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_part);

        tv_text=(TextView) findViewById(R.id.tv_text);
        tv_result=(TextView) findViewById(R.id.tv_result);
        et_text=(EditText) findViewById(R.id.et_text);
        b_new=(Button) findViewById(R.id.b_new);

        fullStory=tv_text.getText().toString();

        //tv_result.setText(fullStory);

        et_text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String currentStory=et_text.getText().toString();

                if (currentStory.length() == 1 && !gameStarted){
                    tv_result.setText("Typing has begun");
                    startTime = System.currentTimeMillis();
                    gameStarted = true;
                }
                if(currentStory.equals(fullStory)){
                    endTime = System.currentTimeMillis();

                    long resultedTime = (endTime - startTime)/1000;
                    tv_result.setText("finished the text in "+resultedTime+" seconds.");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        b_new.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_text.setEnabled(true);
                et_text.setText("");
                tv_result.setText("");
                gameStarted = false;
            }
        });

    }
}