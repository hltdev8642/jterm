package com.hltdev.scarnesdice;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
//import java.*;
import android.util.Log;
//import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{


    private int userOverallScoreState = 0;
    private int userTurnScore = 0;
    private int computerOverallScore = 0;
    private int computerTurnScore = 0;
    private boolean computerHold = false;
    private boolean userHold = false;
    private Button btnRoll, btnReset, btnHold;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {




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
            Button scoreTurnNum = (Button)findViewById(R.id.btnScoreTurnNum);
            Button btnFinalScoreText = (Button) findViewById(R.id.btnFinalScore);



            @Override
            public void onClick(View v)
            {
                resetAllScores();
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
                userHold = true;
                userOverallScoreState += userTurnScore;
                userScore.setText(String.format("%s", userOverallScoreState));
                userTurnScore = 0;
                turnScore.setText(String.format("%s", userTurnScore));

                computerScore.setText(String.format("%s", computerOverallScore));
            }
        });
        // resetAllScores();
    }
    public void resetAllScores ()
    {
        Button userScore = (Button)findViewById(R.id.btnScoreNum);
        Button computerScore = (Button)findViewById(R.id.btnScoreCompNum);
        Button scoreTurnNum = (Button)findViewById(R.id.btnScoreTurnNum);
        Button btnFinalScoreText = (Button) findViewById(R.id.btnFinalScore);

        userOverallScoreState = 0;
        computerOverallScore = 0;
        userTurnScore = 0;
        computerTurnScore = 0;
        userScore.setText(String.format("%s", userOverallScoreState));
        computerScore.setText(String.format("%s", computerOverallScore));
        scoreTurnNum.setText(String.format("%s", userTurnScore));
        btnFinalScoreText.setText(String.format("%s", ""));
    }
    public boolean compWins (int youscore, int compscore)
    {
        return (compscore > youscore);
    }

    public void computerTurn ()
    {
        rollDice(1);
    }

    public void rollDice(int type)
    {
        Button btnTurnScore = (Button) findViewById(R.id.btnScoreTurnNum);
        Button btnComputerTurnScore = (Button) findViewById(R.id.btnScoreCompNum);
        Button btnFinalScoreText = (Button) findViewById(R.id.btnFinalScore);
        int status = checkWinner(userOverallScoreState, computerOverallScore);
        if (status == 0)
        {
            Log.d("Winner is: ", "user" );
            btnFinalScoreText.setText(String.format("%s", "User Wins!"));
            return;
        }

        else if (status == 1)
        {
            Log.d("Winner is: ", "computer" );
            btnFinalScoreText.setText(String.format("%s", "Computer Wins!"));

            return;

        }

        ImageView dice = (ImageView) findViewById(R.id.imageView);

        if (type == 0)
        {


            int randomIndex = ((int) (Math.random() * 6 + 1));
            if (randomIndex == 1)
            {
                dice.setImageResource(R.drawable.dice1);
                if(!userHold)
                {
                    userTurnScore = 0;
                }
                btnTurnScore.setText(String.format("%s", userTurnScore));
            }
            else
            {
                switch (randomIndex)
                {
                    case 2:
                        dice.setImageResource(R.drawable.dice2);
                        userTurnScore += randomIndex;
                        btnTurnScore.setText(String.format("%s", userTurnScore));
                        userHold = false;
                        break;
                    case 3:
                        dice.setImageResource(R.drawable.dice3);
                        userTurnScore += randomIndex;
                        btnTurnScore.setText(String.format("%s", userTurnScore));
                        userHold = false;
                        break;
                    case 4:
                        dice.setImageResource(R.drawable.dice4);
                        userTurnScore += randomIndex;
                        btnTurnScore.setText(String.format("%s", userTurnScore));
                        userHold = false;
                        break;
                    case 5:
                        dice.setImageResource(R.drawable.dice5);
                        userTurnScore += randomIndex;
                        btnTurnScore.setText(String.format("%s", userTurnScore));
                        userHold = false;
                        break;
                    case 6:
                        dice.setImageResource(R.drawable.dice6);
                        userTurnScore += randomIndex;
                        btnTurnScore.setText(String.format("%s", userTurnScore));
                        userHold = false;
                        break;

                }

            }
        }

        if (type == 1)
        {
            if (computerTurnScore < 20)
            {
                computerOverallScore += computerTurnScore;
                computerTurnScore = 0;
                computerHold = false;
            }
            else
            {
                computerHold = true;
            }


            int randomIndex = ((int) (Math.random() * 6 + 1));
            if (randomIndex == 1)
            {
                dice.setImageResource(R.drawable.dice1);
                if(!computerHold)
                {
                    computerTurnScore = 0;
                }

                btnComputerTurnScore.setText(String.format("%s", computerOverallScore));
            }
            else
            {
                switch (randomIndex)
                {
                    case 2:
                        dice.setImageResource(R.drawable.dice2);
                        computerTurnScore += randomIndex;
                        btnComputerTurnScore.setText(String.format("%s", computerOverallScore));
                        computerHold = false;
                        break;
                    case 3:
                        dice.setImageResource(R.drawable.dice3);
                        computerTurnScore += randomIndex;
                        btnComputerTurnScore.setText(String.format("%s", computerOverallScore));
                        computerHold = false;
                        break;
                    case 4:
                        dice.setImageResource(R.drawable.dice4);
                        computerTurnScore += randomIndex;
                        btnComputerTurnScore.setText(String.format("%s", computerOverallScore));
                        computerHold = false;
                        break;
                    case 5:
                        dice.setImageResource(R.drawable.dice5);
                        computerTurnScore += randomIndex;
                        btnComputerTurnScore.setText(String.format("%s", computerOverallScore));
                        computerHold = false;
                        break;
                    case 6:
                        dice.setImageResource(R.drawable.dice6);
                        computerTurnScore += randomIndex;
                        btnComputerTurnScore.setText(String.format("%s", computerOverallScore));
                        computerHold = false;
                        break;

                }

            }
        }


    }
    public int checkWinner (int scoreA, int scoreB)
    {
        if ((scoreA >= 100) & (scoreA > 0) & (scoreA > scoreB))
        {
            return 0;
        }

        if ((scoreB >= 100) & (scoreB > 0) & (scoreB > scoreA))

        {
            return 1;
        }

        else
        {
            return 2;
        }


    }

}
