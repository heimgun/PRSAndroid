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
    Connection connection;
    PreparedStatement ps;


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


        //Connection
        try{
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://ec2-176-34-97-213.eu-west-1.compute.amazonaws.com:5432/d2621gbprb812i", "igblmsacvvtqrc", "8aa6d775c64cc09d4e2aee35743c2ed90290530663b15d687f0e4bfff5542a68");
            connection.setAutoCommit(false);

        } catch (Exception e){e.printStackTrace();}



        //Button-action
        CUBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v){

                final String username = CUusername.getText().toString();
                final String password = CUpassword.getText().toString();
                final String email = CUemail.getText().toString();
                emptyTV.getText().toString();



                 if (username.equals("") || password.equals("") || email.equals("")){

                    emptyTV.setText("Please fill all spaces");

                }

                else {
                    emptyTV.setText("Create User");


                    try {
                        ps = connection.prepareStatement("INSERT INTO \"gamedb.users\" (\"username\", \"password\", \"email\") VALUES (\"?\", \"?\", \"?\")");
                        ps.setString(1, username);
                        ps.setString(2, password);
                        ps.setString(3, email);
                        ps.executeQuery();
                        ps.close();

                        startActivity(new Intent(CreateUser.this, StartGame.class));


                    } catch (SQLException e){}




                }

            }
        });


    }




}