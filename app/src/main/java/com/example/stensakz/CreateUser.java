package com.example.stensakz;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class CreateUser extends AppCompatActivity {

    //TODO:
    // 1. Create TOKENZ
    // 2. Get Connection to DB
    // 2. Create safe password-storage with hash and salt


    Button CUBtn;
    EditText CUusername, CUpassword, CUemail;
    TextView emptyTV;
    Connection connectionCU;
    PreparedStatement psCU;




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


        //Driver





        //Button-action
        CUBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v){

                String username = CUusername.getText().toString();
                String password = CUpassword.getText().toString();
                String email = CUemail.getText().toString();
                emptyTV.getText().toString();

                if (username.equals("") || password.equals("") || email.equals("")){
                    emptyTV.setText("Fill out blankz");
                }

                else {

                    InsertIntoDB(username, password, email);
                    startActivity(new Intent(CreateUser.this, StartGame.class));

                }


            }
        });




    }

    public void InsertIntoDB(String username, String password, String email){


        connectionCU = null;
        psCU = null;


        try{

            connectionCU = DriverManager.getConnection("jdbc:postgresql://ec2-176-34-97-213.eu-west-1.compute.amazonaws.com:5432/d2621gbprb812i", "igblmsacvvtqrc", "8aa6d775c64cc09d4e2aee35743c2ed90290530663b15d687f0e4bfff5542a68");

            psCU = connectionCU.prepareStatement("insert into \"gamedb.users\" (\"username\", \"password\", \"email\") values ('?', '?', '?')");
            psCU.setString(1, username);
            psCU.setString(2, password);
            psCU.setString(3, email);
            psCU.executeUpdate();
            connectionCU.commit();
            psCU.close();



        } catch (SQLException e) {
            e.printStackTrace();
        }



    }




}