package com.example.stensakz;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


import java.util.Random;

public class StartGame extends AppCompatActivity {



    private final int rock = 1;
    private final int paper = 2;
    private final int scissor = 3;
    Random generator = new Random();
    Button rockBtn, paperBtn, scissorBtn;
    RPS computerPlay, playerPlay;




    @Override
    public void onCreate(Bundle SavedInstance){
        super.onCreate(SavedInstance);
        setContentView(R.layout.startgame);

        /* TODO
            1. RPS COMPUTER RANDOM
            2. BEATS
            3. GUI
         */

        rockBtn = (Button) findViewById(R.id.Rock);
        paperBtn = (Button) findViewById(R.id.Paper);
        scissorBtn = (Button) findViewById(R.id.Scissor);


        rockBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                playerPlay = RPS.ROCK;




            }
        });

        paperBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                playerPlay = RPS.PAPER;



            }
        });

        scissorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                playerPlay = RPS.SCISSORS;



            }
        });






    }




    public enum RPS{

       ROCK, PAPER, SCISSORS;

       private static boolean beats(RPS other) {
           return true;
       }

       static {

           ROCK.beats(SCISSORS);
           PAPER.beats(ROCK);
           SCISSORS.beats(PAPER);

       }



    }







    }



