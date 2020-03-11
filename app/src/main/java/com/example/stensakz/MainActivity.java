package com.example.stensakz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //TODO:
    // 1. Add Classes + XML-files
    // 2.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Buttons
        Button CreateUserBtn = (Button) findViewById(R.id.CreateUserBtn);
        Button LogInBtn = (Button) findViewById(R.id.LogInBtn);


        //OnClickListeners
        CreateUserBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CreateUser.class));
            }
        });

        LogInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LogIn.class));
            }
        });


    }
}
