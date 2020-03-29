package com.example.stensakz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.sql.Connection;
import java.sql.DriverManager;

public class MainActivity extends AppCompatActivity {


    ImageButton startGameBtn, rulesBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //Buttons
        startGameBtn = (ImageButton) findViewById(R.id.startGameBtn);
        rulesBtn = (ImageButton) findViewById(R.id.Rules);



        //OnClickListeners
        startGameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, StartGame.class));
            }
        });

        rulesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Rules.class));
            }
        });


    }
}
