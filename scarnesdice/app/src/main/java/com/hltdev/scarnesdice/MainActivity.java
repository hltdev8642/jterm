package com.hltdev.scarnesdice;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
//import java.*;
import android.util.Log;
//import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private int userOverallScoreState = 0;
    private int userTurnScore = 0;
    private int computerOverallScore = 0;
    private int computerTurnScore = 0;
    private boolean isHold = false;
    private Button btnRoll,btnReset,btnHold;

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

            }
        });

        btnReset = (Button)findViewById(R.id.btnReset);
        btnReset.setOnClickListener(new View.OnClickListener()
        {
            Button userScore = (Button)findViewById(R.id.btnScoreNum);
            Button computerScore = (Button)findViewById(R.id.btnScoreCompNum);
            Button btnFinalScoreText = (Button) findViewById(R.id.btnFinalScore);



            @Override
            public void onClick(View v)
            {
                userOverallScoreState = 0;
                computerOverallScore = 0;
                userTurnScore = 0;
                computerTurnScore = 0;
                userScore.setText(String.format("%s",userOverallScoreState));
                computerScore.setText(String.format("%s",computerOverallScore));
                btnFinalScoreText.setText(String.format("%s", " "));
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

    public void rollDice(int type) {
         Button btnTurnScore = (Button) findViewById(R.id.btnScoreTurnNum);
         Button btnComputerTurnScore = (Button) findViewById(R.id.btnScoreCompNum);
         Button btnFinalScoreText = (Button) findViewById(R.id.btnFinalScore);
        int status = checkWinner(userOverallScoreState,computerOverallScore);
        if (status == 0)
        {
            Log.d("Winner is: ", "user" );
            /*btnTurnScore.setText(String.format("%s","Winner"));
            btnComputerTurnScore.setText(String.format("%s","Loser"));*/
            btnFinalScoreText.setText(String.format("%s","User Wins!"));
            return;
        }

       else if (status == 1)
        {
            Log.d("Winner is: ", "computer" );
          /*  btnTurnScore.setText(String.format("%s","Loser"));
            btnComputerTurnScore.setText(String.format("%s","Winner"));*/
            btnFinalScoreText.setText(String.format("%s","Computer Wins!"));

            return;

        }
/*

        // Button userScore = (Button)findViewById(R.id.btnScoreNum);
        Button btnTurnScore = (Button) findViewById(R.id.btnScoreTurnNum);
        Button btnComputerTurnScore = (Button) findViewById(R.id.btnScoreCompNum);
*/

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
            if (computerTurnScore > 20) {
                isHold = true;
            }


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
    public int checkWinner (int scoreA, int scoreB)
    {
        if ((scoreA > 100 && scoreA > scoreB))
        {
            return 0;
        }

        else if ((scoreB > 100 && scoreB > scoreA))

        {
            return 1;
        }

        else {
            return 2;
        }


    }

}
