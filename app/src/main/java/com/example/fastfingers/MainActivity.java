package com.example.fastfingers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static String name;
    EditText nameO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button mButton = (Button) findViewById(R.id.button);
        mButton.setOnClickListener(this::onClick);

        nameO=(EditText) findViewById(R.id.name);

        name=nameO.getText().toString();
    }
    private void onClick(View view) {
        startActivity(new Intent(MainActivity.this, gamePart.class));
    }
}