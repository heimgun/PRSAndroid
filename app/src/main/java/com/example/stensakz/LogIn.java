package com.example.stensakz;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;


import androidx.appcompat.app.AppCompatActivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;


public class LogIn extends AppCompatActivity {

    //TODO:
    // 1. Get Connection to DB
    // 2. onClickListener


    @Override
    public void onCreate(Bundle SavedInstanceState) {
        super.onCreate(SavedInstanceState);
        setContentView(R.layout.login);

        //XML-objects
        EditText UsernameEdit = (EditText) findViewById(R.id.UsernameEdit);
        EditText PasswordEdit = (EditText) findViewById(R.id.PasswordEdit);
        Button LoginBtn = (Button) findViewById(R.id.LogIn4Real);

        Scanner sc = new Scanner(System.in);




    }


    //Methods



}