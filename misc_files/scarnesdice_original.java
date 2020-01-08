package com.hltdev.scarnesdice;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
//import java.*;
//import android.util.Log;
//import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private int userOverallScoreState = 0;
    private int userTurnScore;
    private int computerOverallScore;
    private int computerTurnScore;
    private boolean isHold = false;
    private Button btnRoll,btnReset,btnHold;

    public MainActivity() {
        userTurnScore = 0;
        computerOverallScore = 0;
        computerTurnScore = 0;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {




        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRoll = (Button)findViewById(R.id.btnRoll);
        btnRoll.setOnClickListener(new View.OnClickListener()
        {
            ImageView dice = (ImageView)findViewById(R.id.imageView);
            Button userScore = (Button)findViewById(R.id.btnScoreNum);
            Button turnScore = (Button)findViewById(R.id.btnScoreTurnNum);

            @Override
            public void onClick(View v)
            {

              rollDice(0);
              rollDice(1);

/*
                int randomIndexA = (int) (Math.random() * 6 + 1);




                switch (randomIndexA)
                {
                    case 1:
                        dice.setImageResource(R.drawable.dice1);
                        userTurnScore = 0;
                        turnScore.setText(String.format("%s",userTurnScore));
                        if(!isHold) {
                            userOverallScoreState=0;
                            userScore.setText(String.format("%s", userOverallScoreState));
                        }

                        break;
                    case 2:
                        dice.setImageResource(R.drawable.dice2);
                        userOverallScoreState+=2;
                        userTurnScore+=2;
                      //  userScore.setText(String.format("%s",userOverallScoreState));
                        turnScore.setText(String.format("%s",userTurnScore));
                        isHold = false;
                        break;
                    case 3:
                        dice.setImageResource(R.drawable.dice3);
                        userOverallScoreState+=3;
                        userTurnScore+=3;
                      //  userScore.setText(String.format("%s",userOverallScoreState));
                        turnScore.setText(String.format("%s",userTurnScore));
                        isHold = false;
                        break;
                    case 4:
                        dice.setImageResource(R.drawable.dice4);
                        userOverallScoreState+=4;
                        userTurnScore+=4;
                       // userScore.setText(String.format("%s",userOverallScoreState));
                        turnScore.setText(String.format("%s",userTurnScore));
                        isHold = false;
                        break;
                    case 5:
                        dice.setImageResource(R.drawable.dice5);
                        userOverallScoreState+=5;
                        userTurnScore+=5;
                      //  userScore.setText(String.format("%s",userOverallScoreState));
                        turnScore.setText(String.format("%s",userTurnScore));
                        isHold = false;
                        break;
                    case 6:
                        dice.setImageResource(R.drawable.dice6);
                        userOverallScoreState+=6;
                        userTurnScore+=6;
                       // userScore.setText(String.format("%s",userOverallScoreState));
                        turnScore.setText(String.format("%s",userTurnScore));
                        isHold = false;
                        break;
                }

if (!compWins(userOverallScoreState,computerOverallScore)) {
    userScore.setText(String.format("%s", "You Won! Score: " + userOverallScoreState + " "));
    computerTurn();
        userOverallScoreState=0;


}
*/

            }
        });

        btnReset = (Button)findViewById(R.id.btnReset);
        btnReset.setOnClickListener(new View.OnClickListener()
        {
            Button userScore = (Button)findViewById(R.id.btnScoreNum);
            Button computerScore = (Button)findViewById(R.id.btnScoreCompNum);


            @Override
            public void onClick(View v)
            {
                userOverallScoreState = 0;
                computerOverallScore = 0;
                userTurnScore = 0;
                computerTurnScore = 0;
                userScore.setText(String.format("%s",userOverallScoreState));
                computerScore.setText(String.format("%s",computerOverallScore));
            }


        });

        btnHold = (Button)findViewById(R.id.btnHold);
        btnHold.setOnClickListener(new View.OnClickListener()
        {
            Button userScore = (Button)findViewById(R.id.btnScoreNum);
            Button turnScore = (Button)findViewById(R.id.btnScoreTurnNum);
            Button computerScore = (Button)findViewById(R.id.btnScoreCompNum);

            @Override
            public void onClick(View v)
            {
                isHold = true;
                userScore.setText(String.format("%s",userOverallScoreState));
                userTurnScore = 0;
                turnScore.setText(String.format("%s",userTurnScore));

                computerScore.setText(String.format("%s",computerOverallScore));
                computerTurnScore = 0;
            }
        });

    }

    public boolean compWins (int youscore, int compscore)
    {
        return (compscore > youscore);
    }

    public void computerTurn ()
    {
        rollDice(1);
    }
        /*Button userScore = (Button)findViewById(R.id.btnScoreNum);

        userScore.setText(String.format("%s", userOverallScoreState ));

        Button computerScore = (Button) findViewById(R.id.btnScoreCompNum);
        Boolean isLoop = true;
       // while (computerTurnScore < 20 ) {
             computerTurnScore += rollDice(computerOverallScore,computerTurnScore);
        //}
        */
           /*
            int randomIndexB = (int) (Math.random() * 6 + 1);

                switch (randomIndexB) {
                    case 1:
                        //dice.setImageResource(R.drawable.dice1);
                        computerTurnScore = 0;
                        computerScore.setText(String.format("%s", computerTurnScore));
                        isLoop = false;
                        break;

                    case 2:
                        //dice.setImageResource(R.drawable.dice2);
                        computerOverallScore += 2;
                        computerTurnScore += 2;
                        computerScore.setText(String.format("%s", computerTurnScore));
                        break;
                    case 3:
                        //dice.setImageResource(R.drawable.dice3);
                        computerOverallScore += 3;
                        computerTurnScore += 3;
                        computerScore.setText(String.format("%s", computerTurnScore));
                        break;
                    case 4:
                        // dice.setImageResource(R.drawable.dice4);
                        computerOverallScore += 4;
                        computerTurnScore += 4;
                        computerScore.setText(String.format("%s", computerTurnScore));
                        break;
                    case 5:
                        //dice.setImageResource(R.drawable.dice5);
                        computerOverallScore += 5;
                        computerTurnScore += 5;
                        computerScore.setText(String.format("%s", computerTurnScore));
                        break;
                    case 6:
                        // dice.setImageResource(R.drawable.dice6);
                        computerOverallScore += 6;
                        computerTurnScore += 6;
                        computerScore.setText(String.format("%s", computerTurnScore));
                        break;
                }
            }
*/
    //}

    // computerTurn();

    public void rollDice(int type) {

        // Button userScore = (Button)findViewById(R.id.btnScoreNum);
        Button btnTurnScore = (Button) findViewById(R.id.btnScoreTurnNum);
        Button btnComputerTurnScore = (Button) findViewById(R.id.btnScoreCompNum);

        ImageView dice = (ImageView) findViewById(R.id.imageView);

        if (type == 0) {


            int randomIndex = ((int) (Math.random() * 6 + 1));
            if (randomIndex == 1) {
                dice.setImageResource(R.drawable.dice1);
                userTurnScore = 0;
                btnTurnScore.setText(String.format("%s", userTurnScore));
            } else {
                switch (randomIndex) {
                    case 2:
                        dice.setImageResource(R.drawable.dice2);
                        userOverallScoreState += randomIndex;
                        userTurnScore += randomIndex;
                        btnTurnScore.setText(String.format("%s", userTurnScore));
                        isHold = false;
                        break;
                    case 3:
                        dice.setImageResource(R.drawable.dice3);
                        userOverallScoreState += randomIndex;
                        userTurnScore += randomIndex;
                        btnTurnScore.setText(String.format("%s", userTurnScore));
                        isHold = false;
                        break;
                    case 4:
                        dice.setImageResource(R.drawable.dice4);
                        userOverallScoreState += randomIndex;
                        userTurnScore += randomIndex;
                        btnTurnScore.setText(String.format("%s", userTurnScore));
                        isHold = false;
                        break;
                    case 5:
                        dice.setImageResource(R.drawable.dice5);
                        userOverallScoreState += randomIndex;
                        userTurnScore += randomIndex;
                        btnTurnScore.setText(String.format("%s", userTurnScore));
                        isHold = false;
                        break;
                    case 6:
                        dice.setImageResource(R.drawable.dice6);
                        userOverallScoreState += randomIndex;
                        userTurnScore += randomIndex;
                        btnTurnScore.setText(String.format("%s", userTurnScore));
                        isHold = false;
                        break;

                }

            }
        }

        if (type == 1) {
            int randomIndex = ((int) (Math.random() * 6 + 1));
            if (randomIndex == 1) {
                dice.setImageResource(R.drawable.dice1);
                computerTurnScore = 0;
                btnComputerTurnScore.setText(String.format("%s", computerTurnScore));
            } else {
                switch (randomIndex) {
                    case 2:
                        dice.setImageResource(R.drawable.dice2);
                        computerOverallScore += randomIndex;
                        computerTurnScore += randomIndex;
                        btnComputerTurnScore.setText(String.format("%s", computerTurnScore));
                        isHold = false;
                        break;
                    case 3:
                        dice.setImageResource(R.drawable.dice3);
                        computerOverallScore += randomIndex;
                        computerTurnScore += randomIndex;
                        btnComputerTurnScore.setText(String.format("%s", computerTurnScore));
                        isHold = false;
                        break;
                    case 4:
                        dice.setImageResource(R.drawable.dice4);
                        computerOverallScore += randomIndex;
                        computerTurnScore += randomIndex;
                        btnComputerTurnScore.setText(String.format("%s", computerTurnScore));
                        isHold = false;
                        break;
                    case 5:
                        dice.setImageResource(R.drawable.dice5);
                        computerOverallScore += randomIndex;
                        computerTurnScore += randomIndex;
                        btnComputerTurnScore.setText(String.format("%s", computerTurnScore));
                        isHold = false;
                        break;
                    case 6:
                        dice.setImageResource(R.drawable.dice6);
                        computerOverallScore += randomIndex;
                        computerTurnScore += randomIndex;
                        btnComputerTurnScore.setText(String.format("%s", computerTurnScore));
                        isHold = false;
                        break;

                }

            }
        }
    }

}
