package com.example.stensakz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import java.util.Random;

public class StartGame extends AppCompatActivity {



    Random generator = new Random();
    Button restartBtn;
    ImageButton rockBtn, paperBtn, scissorBtn;
    ImageView computerMove;
    RPS computerPlay, playerPlay;
    TextView gameTV, resultTV;
    RelativeLayout cpGame, plGame, restart;



    @Override
    public void onCreate(Bundle SavedInstance) {
        super.onCreate(SavedInstance);
        setContentView(R.layout.startgame);


        restartBtn = (Button) findViewById(R.id.restartBtn);

        rockBtn = (ImageButton) findViewById(R.id.Rock);
        paperBtn = (ImageButton) findViewById(R.id.Paper);
        scissorBtn = (ImageButton) findViewById(R.id.Scissor);
        computerMove = (ImageView) findViewById(R.id.computerChoiceIMG);

        resultTV = (TextView) findViewById(R.id.whatBWhat);
        gameTV = (TextView) findViewById(R.id.computerTV);

        cpGame = (RelativeLayout) findViewById(R.id.RLcomputerChoice);
        plGame = (RelativeLayout) findViewById(R.id.PlayerChoice);
        restart = (RelativeLayout) findViewById(R.id.restart);


        cpGame.setVisibility(View.VISIBLE);
        plGame.setVisibility(View.VISIBLE);
        restart.setVisibility(View.INVISIBLE);

        cpGenerator();

        /**
         * Player chooses Rock (Covid)
         */
        rockBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                playerPlay = RPS.ROCK;


                 if (playerPlay.beats(computerPlay)) {

                    plGame.setVisibility(View.INVISIBLE);
                    gameTV.setText(R.string.Win);
                    resultTV.setText(R.string.cBh);
                    computerMove.setImageResource(R.drawable.covidwon);
                    restart.setVisibility(View.VISIBLE);



                 } else if (computerPlay.beats(playerPlay)) {

                    plGame.setVisibility(View.INVISIBLE);
                    gameTV.setText(R.string.Loose);
                    resultTV.setText(R.string.pBc);
                    computerMove.setImageResource(R.drawable.paperwon);
                    restart.setVisibility(View.VISIBLE);



                 } else if (computerPlay.equals(playerPlay)) {

                    plGame.setVisibility(View.INVISIBLE);
                    gameTV.setText(R.string.Tie);
                    restart.setVisibility(View.VISIBLE);


                 }


            }
        });

        /**
         * Player Chooses Paper (Paper)
         */
        paperBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                playerPlay = RPS.PAPER;



                if (playerPlay.beats(computerPlay)) {

                    plGame.setVisibility(View.INVISIBLE);
                    gameTV.setText(R.string.Win);
                    resultTV.setText(R.string.pBc);
                    computerMove.setImageResource(R.drawable.paperwon);
                    restart.setVisibility(View.VISIBLE);



                } else if (computerPlay.beats(playerPlay)) {

                    plGame.setVisibility(View.INVISIBLE);
                    gameTV.setText(R.string.Loose);
                    resultTV.setText(R.string.hBp);
                    computerMove.setImageResource(R.drawable.handwon);
                    restart.setVisibility(View.VISIBLE);


                } else if (computerPlay.equals(playerPlay)) {

                    plGame.setVisibility(View.INVISIBLE);
                    gameTV.setText(R.string.Tie);
                    restart.setVisibility(View.VISIBLE);


                }


            }
        });

        /**
         * Player Chooses Scissors (Hand)
         */
        scissorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                playerPlay = RPS.SCISSORS;


                if (playerPlay.beats(computerPlay)) {

                    plGame.setVisibility(View.INVISIBLE);
                    gameTV.setText(R.string.Win);
                    resultTV.setText(R.string.hBp);
                    computerMove.setImageResource(R.drawable.handwon);
                    restart.setVisibility(View.VISIBLE);


                } else if (computerPlay.beats(playerPlay)) {

                    plGame.setVisibility(View.INVISIBLE);
                    gameTV.setText(R.string.Loose);
                    resultTV.setText(R.string.cBh);
                    computerMove.setImageResource(R.drawable.covidwon);
                    restart.setVisibility(View.VISIBLE);


                } else if (computerPlay.equals(playerPlay)) {

                    plGame.setVisibility(View.INVISIBLE);
                    gameTV.setText(R.string.Tie);
                    restart.setVisibility(View.VISIBLE);

                }

            }
        });



       restartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StartGame.this, StartGame.class));
            }
        });


    }

    /**
     * Generates random number between 1 and 3 and makes it computers RPS
     */
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


    /**
     * Enum RPS which creates objects ROCK (Covid), PAPER (Paper) and SCISSORS (Hand)
     * and decides what beats what w/Boolean.
     */
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











