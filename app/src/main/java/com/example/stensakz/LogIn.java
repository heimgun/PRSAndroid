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
import java.sql.ResultSet;
import java.sql.SQLException;


public class LogIn extends AppCompatActivity {

    //TODO:
    // 1. Get Connection to DB
    // 2. TOKENZ

    EditText usernameEdit, passwordEdit;
    TextView emptyTV;
    Button loginBtn, createUserBtn;
    Connection connection;
    PreparedStatement ps;


    @Override
    public void onCreate(Bundle SavedInstanceState) {
        super.onCreate(SavedInstanceState);
        setContentView(R.layout.login);

        //XML-objects
        usernameEdit = (EditText) findViewById(R.id.UsernameEdit);
        passwordEdit = (EditText) findViewById(R.id.PasswordEdit);
        loginBtn = (Button) findViewById(R.id.LogIn4Real);
        emptyTV = (TextView) findViewById(R.id.UsernameEmpty);


        //Connection
        try{
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://ec2-176-34-97-213.eu-west-1.compute.amazonaws.com:5432/d2621gbprb812i", "igblmsacvvtqrc", "8aa6d775c64cc09d4e2aee35743c2ed90290530663b15d687f0e4bfff5542a68");
            connection.setAutoCommit(false);

        } catch (Exception e){e.printStackTrace();}



        //Buttonclickz
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = usernameEdit.getText().toString();
                String password = passwordEdit.getText().toString();

                try{
                    ps = connection.prepareStatement("SELECT * FROM \"gamedb.users\" WHERE \"username\" = \"?\" AND \"password\" = \"?\"");
                    ps.setString(1, username);
                    ps.setString(2, password);
                    ResultSet validUser = ps.executeQuery();
                    ps.close();

                    if(validUser == null){
                        emptyTV.setText("Empty Fields Bro");
                    }

                    else if (!validUser.next()){
                        emptyTV.setText("No match Bro");
                    }

                    else {
                        emptyTV.setText("You in Bro");

                    }

                } catch (SQLException e){}







            }
        });

    }


    //Methods



}