package com.example.stensakz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Rules extends AppCompatActivity {

        ImageButton startGame;


        @Override
        protected void onCreate(Bundle SavedInstance){
            super.onCreate(SavedInstance);
            setContentView(R.layout.rules);


            startGame = (ImageButton) findViewById(R.id.startGameBtnRules);



            startGame.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    startActivity(new Intent(Rules.this, StartGame.class));

                }
            });




        }

}
