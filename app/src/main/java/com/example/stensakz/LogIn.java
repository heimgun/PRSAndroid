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

    EditText usernameEdit, passwordEdit;
    Button loginBtn, createUserBtn;


    @Override
    public void onCreate(Bundle SavedInstanceState) {
        super.onCreate(SavedInstanceState);
        setContentView(R.layout.login);

        //XML-objects
        usernameEdit = (EditText) findViewById(R.id.UsernameEdit);
        passwordEdit = (EditText) findViewById(R.id.PasswordEdit);
        loginBtn = (Button) findViewById(R.id.LogIn4Real);




    }


    //Methods



}