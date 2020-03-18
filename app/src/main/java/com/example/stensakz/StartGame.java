package com.example.stensakz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import java.util.Random;

public class StartGame extends AppCompatActivity {


    Random generator = new Random();
    Button rockBtn, paperBtn, scissorBtn, reStartBtn;
    RPS computerPlay, playerPlay;
    TextView gameTV;





    @Override
    public void onCreate(Bundle SavedInstance){
        super.onCreate(SavedInstance);
        setContentView(R.layout.startgame);

        /* TODO
            1. BEATS
            2. GUI
         */

        rockBtn = (Button) findViewById(R.id.Rock);
        paperBtn = (Button) findViewById(R.id.Paper);
        scissorBtn = (Button) findViewById(R.id.Scissor);
        reStartBtn = (Button) findViewById(R.id.Restart);
        gameTV = (TextView) findViewById(R.id.GameTV);


        rockBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                playerPlay = RPS.ROCK;
                cpGenerator();
                gameTV.getText().toString();

                if (playerPlay.beats(computerPlay)){

                    gameTV.setText("You win");


                }

                else if (computerPlay.beats(playerPlay)){

                    gameTV.setText("Computer win");
                }

                else if (computerPlay.equals(playerPlay)){

                    gameTV.setText("TIE");

                }

                return;

            }
        });

        paperBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                playerPlay = RPS.PAPER;
                cpGenerator();
                gameTV.getText().toString();

                if (playerPlay.beats(computerPlay)){

                    gameTV.setText("You win");


                }

                else if (computerPlay.beats(playerPlay)){

                    gameTV.setText("Computer win");
                }

                else if (computerPlay.equals(playerPlay)){

                    gameTV.setText("TIE");

                }

                return;

            }
        });

        scissorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                playerPlay = RPS.SCISSORS;
                cpGenerator();

                gameTV.getText().toString();

                if (playerPlay.beats(computerPlay)){

                    gameTV.setText("You win");


                }

                else if (computerPlay.beats(playerPlay)){

                    gameTV.setText("Computer win");
                }

                else if (computerPlay.equals(playerPlay)){

                    gameTV.setText("TIE");

                }

                return;

            }
        });



        reStartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StartGame.this, StartGame.class));
            }
        });


    }


    public void cpGenerator(){

        int cp = generator.nextInt(3)+1;

        if (cp == 1){
            computerPlay = RPS.ROCK;
        }

        else if (cp == 2){
            computerPlay = RPS.PAPER;
        }

        else if (cp == 3){
            computerPlay = RPS.SCISSORS;
        }



    }



    public enum RPS {

        ROCK, PAPER, SCISSORS;

        boolean beats(RPS other){

            switch(this) {
                case ROCK: return other == SCISSORS;
                case PAPER: return other == ROCK;
                case SCISSORS: return other == PAPER;

                default:
                    throw new IllegalStateException();

            }


        }

    }



    }











