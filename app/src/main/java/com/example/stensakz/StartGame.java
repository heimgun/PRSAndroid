package com.example.stensakz;

import android.os.Bundle;
import android.view.View;

import android.widget.ImageButton;
import android.widget.ImageView;

import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import java.util.Random;

public class StartGame extends AppCompatActivity {



    Random generator = new Random();
    ImageButton rockBtn, paperBtn, scissorBtn;
    ImageView computerMove;
    RPS computerPlay, playerPlay;
    TextView gameTV;
    RelativeLayout cpGame, plGame;



    @Override
    public void onCreate(Bundle SavedInstance) {
        super.onCreate(SavedInstance);
        setContentView(R.layout.startgame);


        rockBtn = (ImageButton) findViewById(R.id.Rock);
        paperBtn = (ImageButton) findViewById(R.id.Paper);
        scissorBtn = (ImageButton) findViewById(R.id.Scissor);
        computerMove = (ImageView) findViewById(R.id.computerChoiceIMG);

        gameTV = (TextView) findViewById(R.id.computerTV);

        cpGame = (RelativeLayout) findViewById(R.id.RLcomputerChoice);
        plGame = (RelativeLayout) findViewById(R.id.PlayerChoice);

        cpGame.setVisibility(View.INVISIBLE);
        plGame.setVisibility(View.VISIBLE);

        cpGenerator();


        rockBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                playerPlay = RPS.ROCK;


                 if (playerPlay.beats(computerPlay)) {

                    plGame.setVisibility(View.INVISIBLE);
                    gameTV.setText("You win");
                    computerMove.setImageResource(R.drawable.covidwon);
                    cpGame.setVisibility(View.VISIBLE);



                 } else if (computerPlay.beats(playerPlay)) {

                    plGame.setVisibility(View.INVISIBLE);
                    gameTV.setText("You loose");
                    computerMove.setImageResource(R.drawable.paperwon);
                    cpGame.setVisibility(View.VISIBLE);



                 } else if (computerPlay.equals(playerPlay)) {

                    plGame.setVisibility(View.INVISIBLE);
                    gameTV.setText("Tie");
                    cpGame.setVisibility(View.VISIBLE);


                 }


            }
        });

        paperBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                playerPlay = RPS.PAPER;



                if (playerPlay.beats(computerPlay)) {

                    plGame.setVisibility(View.INVISIBLE);
                    gameTV.setText("You win");
                    computerMove.setImageResource(R.drawable.paperwon);
                    cpGame.setVisibility(View.VISIBLE);



                } else if (computerPlay.beats(playerPlay)) {

                    plGame.setVisibility(View.INVISIBLE);
                    gameTV.setText("You loose");
                    computerMove.setImageResource(R.drawable.handwon);
                    cpGame.setVisibility(View.VISIBLE);


                } else if (computerPlay.equals(playerPlay)) {

                    plGame.setVisibility(View.INVISIBLE);
                    gameTV.setText("Tie");
                    cpGame.setVisibility(View.VISIBLE);


                }


            }
        });

        scissorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                playerPlay = RPS.SCISSORS;


                if (playerPlay.beats(computerPlay)) {

                    plGame.setVisibility(View.INVISIBLE);
                    gameTV.setText("You Win");
                    computerMove.setImageResource(R.drawable.handwon);
                    cpGame.setVisibility(View.VISIBLE);


                } else if (computerPlay.beats(playerPlay)) {

                    plGame.setVisibility(View.INVISIBLE);
                    gameTV.setText("You loose");
                    computerMove.setImageResource(R.drawable.covidwon);
                    cpGame.setVisibility(View.VISIBLE);


                } else if (computerPlay.equals(playerPlay)) {

                    plGame.setVisibility(View.INVISIBLE);
                    gameTV.setText("Tie");
                    cpGame.setVisibility(View.VISIBLE);

                }

            }
        });



       /* reStartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StartGame.this, StartGame.class));
            }
        }); */


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











