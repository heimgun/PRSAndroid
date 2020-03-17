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


    Button CUBtn;
    EditText CUusername, CUpassword, CUemail;
    TextView emptyTV;


    @Override
    public void onCreate(Bundle SavedInstanceState){
        super.onCreate(SavedInstanceState);
        setContentView(R.layout.createuser);


        //XML-objects
        CUBtn = (Button) findViewById(R.id.CUBtn);
        CUusername = (EditText) findViewById(R.id.CUEditUsername);
        CUpassword = (EditText) findViewById(R.id.CUEditpassword);
        CUemail = (EditText) findViewById(R.id.CUEditEmail);
        emptyTV = (TextView) findViewById(R.id.UsernameEmpty);





        //Methods
        CUBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String username = CUusername.getText().toString();
                final String password = CUpassword.getText().toString();
                final String email = CUemail.getText().toString();
                emptyTV.getText().toString();



                 if (username.equals("") || password.equals("") || email.equals("")){

                    emptyTV.setText("Please fill all spaces");

                }

                else {

                    emptyTV.setText("Create User");
                }

            }
        });

    }
}