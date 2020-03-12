package com.example.stensakz;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

public class CreateUser extends AppCompatActivity {

    //TODO:
    // 1. Add Edittexts
    // 2. Get Connection to DB
    // 2. Create safe password-storage with hash and salt



    @Override
    public void onCreate(Bundle SavedInstanceState){
        super.onCreate(SavedInstanceState);
        setContentView(R.layout.createuser);


        //XML-objects
        Button CUBtn = (Button) findViewById(R.id.CUBtn);
        final EditText CUusername = (EditText) findViewById(R.id.CUEditUsername);
        final EditText CUpassword = (EditText) findViewById(R.id.CUEditpassword);
        final EditText CUemail = (EditText) findViewById(R.id.CUEditEmail);
        final TextView usernameEmpty = (TextView) findViewById(R.id.UsernameEmpty);
        usernameEmpty.setVisibility(View.INVISIBLE);


        //Methods
        CUBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (CUusername.getText().toString() != null && CUpassword.getText().toString() != null && CUemail.getText().toString() != null){

                }

                else if (CUusername.getText().toString() == null){

                    usernameEmpty.setVisibility(View.VISIBLE);

                }
            }
        });

    }
}