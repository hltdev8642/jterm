/* Copyright 2016 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.engedu.ghost;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.io.IOException;
import java.util.Random;


public class GhostActivity extends AppCompatActivity {
    private static final String COMPUTER_TURN = "Computer's turn";
    private static final String USER_TURN = "Your turn";
    private static final String COMPUTER_WINS = "Computer Wins";
    private static final String USER_WINS = "User Wins";
    private GhostDictionary dictionary;
    private boolean userTurn = false;
    private Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ghost);
        AssetManager assetManager = getAssets();
        try {
            dictionary = new SimpleDictionary(assetManager.open("words.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Button buttonReset = (Button) findViewById(R.id.buttonReset);
        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Log.d("Reset","- - -");
            resetGame();
            }
            });



        Button buttonChallenge = (Button) findViewById(R.id.buttonChallenge);
        buttonChallenge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        /*
        //test for isAlpha() method
        Log.d("[d]",String.valueOf(isAlpha('d')));
        Log.d("[1]",String.valueOf(isAlpha('1')));
        Log.d("[!]",String.valueOf(isAlpha('!')));
        */

        onStart(null);
    }

    public void resetGame ()
    {
        onStart(null);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ghost, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Handler for the "Reset" button.
     * Randomly determines whether the game starts with a user turn or a computer turn.
     * @param view
     * @return true
     */
    public boolean onStart(View view) {
        userTurn = random.nextBoolean();
        TextView ghostText = (TextView) findViewById(R.id.ghostText);
        ghostText.setText("");
        TextView textIsWordDebug = (TextView) findViewById(R.id.textIsWordDebug);
        textIsWordDebug.setText("");

        if (userTurn) {
            textIsWordDebug.setText(USER_TURN);
        } else {
            textIsWordDebug.setText(COMPUTER_TURN);
            computerTurn();
        }
        return true;
    }

    private void computerTurn() {
        TextView textGameStatus = (TextView) findViewById(R.id.textGameStatus);
        TextView ghostText = (TextView) findViewById(R.id.ghostText);

        // Do computer turn stuff then make it the user's turn again
        userTurn = true;
        textGameStatus.setText(USER_TURN);
    }

    /*
     * Handler for user key presses.
     * @param keyCode
     * @param event
     * @return whether the key stroke was handled.
     */

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event)
    {
        TextView ghostText = findViewById(R.id.ghostText);
        TextView textIsWordDebug = findViewById(R.id.textIsWordDebug);
        TextView textGameStatus = (TextView) findViewById(R.id.textGameStatus);

        if (isAlpha((char) event.getUnicodeChar())) {
            Log.d("Is Alphanumeric", String.valueOf((char) event.getUnicodeChar()));
            ghostText.append(String.valueOf((char) event.getUnicodeChar()));
            if (dictionary.isWord(ghostText.getText().toString()))
            {
                Log.d("Is a Word", ghostText.getText().toString());
                textIsWordDebug.setText(ghostText.getText().toString());
                textGameStatus.setText(getWinner(ghostText.getText().toString()));
                String result = dictionary.getAnyWordStartingWith(ghostText.getText().toString());
                Log.d("result",result);
            }
            else
            {
                Log.d("Not a word","");
            }
            return true;
        }
        return super.onKeyUp(keyCode, event);
    }

    public String getWinner(String textWord)
    {

        return userTurn && textWord.length() >= 4 ? COMPUTER_WINS : USER_WINS;
    }

   /* public boolean largerWordExists (String textWord)
    {
        if (dictionary.getAnyWordStartingWith())
        {

        }

        else
        {

        }
    }*/

    public boolean isAlpha(char name)
    {
        return Character.isLetter(name);
    }

}
