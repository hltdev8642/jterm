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

package com.google.engedu.wordstack;

import android.content.res.AssetManager;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity
{

   private static final int WORD_LENGTH = 5;
   public static final int LIGHT_BLUE = Color.rgb(176, 200, 255);
   public static final int LIGHT_GREEN = Color.rgb(200, 255, 200);
   private ArrayList<String> words = new ArrayList<>();
   private Random random = new Random();
   private StackedLayout stackedLayout;
   private String word1, word2;

   @Override
   protected void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);
      AssetManager assetManager = getAssets();

      try
      {
         InputStream inputStream = assetManager.open("words.txt");
         BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
         String line = null;

         while((line = in.readLine()) != null)
         {
            String word = line.trim();

            if (isGoodWord(word))
            {
               //System.out.println(word);
               words.add(word);
            }

                  /*
                  else
                  {
                  Log.d("Rejected: ", word);
                  }
                  Log.d("Added: ",words.toString());
                  */
         }
      }

      catch (IOException e)
      {
         Toast toast = Toast.makeText(this, "Could not load dictionary", Toast.LENGTH_LONG);
         toast.show();
      }

      LinearLayout verticalLayout = (LinearLayout) findViewById(R.id.vertical_layout);
      stackedLayout = new StackedLayout(this);
      verticalLayout.addView(stackedLayout, 3);
      View word1LinearLayout = findViewById(R.id.word1);
      word1LinearLayout.setOnTouchListener(new TouchListener());
      //word1LinearLayout.setOnDragListener(new DragListener());
      View word2LinearLayout = findViewById(R.id.word2);
      word2LinearLayout.setOnTouchListener(new TouchListener());
      //word2LinearLayout.setOnDragListener(new DragListener());
   }

   private class TouchListener implements View.OnTouchListener
   {

      @Override
      public boolean onTouch(View v, MotionEvent event)
      {
         if (event.getAction() == MotionEvent.ACTION_DOWN && !stackedLayout.empty())
         {
            LetterTile tile = (LetterTile) stackedLayout.peek();
            tile.moveToViewGroup((ViewGroup) v);

            if (stackedLayout.empty())
            {
               TextView messageBox = (TextView) findViewById(R.id.message_box);
               messageBox.setText(word1 + " " + word2);
            }

            stackedLayout.push(tile);
            return true;
         }

         return false;
      }
   }

   private class DragListener implements View.OnDragListener
   {

      public boolean onDrag(View v, DragEvent event)
      {
         int action = event.getAction();

         switch (event.getAction())
         {
            case DragEvent.ACTION_DRAG_STARTED:
               v.setBackgroundColor(LIGHT_BLUE);
               v.invalidate();
               return true;

            case DragEvent.ACTION_DRAG_ENTERED:
               v.setBackgroundColor(LIGHT_GREEN);
               v.invalidate();
               return true;

            case DragEvent.ACTION_DRAG_EXITED:
               v.setBackgroundColor(LIGHT_BLUE);
               v.invalidate();
               return true;

            case DragEvent.ACTION_DRAG_ENDED:
               v.setBackgroundColor(Color.WHITE);
               v.invalidate();
               return true;

            case DragEvent.ACTION_DROP:
               // Dropped, reassign Tile to the target Layout
               LetterTile tile = (LetterTile) event.getLocalState();
               tile.moveToViewGroup((ViewGroup) v);


               TextView messageBox = (TextView) findViewById(R.id.message_box);
               if (stackedLayout.empty())
               {
                  messageBox.setText(word1 + " " + word2);
               }

              // tile.moveToViewGroup((ViewGroup) messageBox.getParent());
               stackedLayout.push(tile);

               return true;
         }

         return false;
      }
   }

   public boolean onStartGame(View view)
   {
      TextView messageBox = (TextView) findViewById(R.id.message_box);
      messageBox.setText("Game started");
      /**
       **
       **  YOUR CODE GOES HERE
       **
       * onStartGame
       * Next, start implementing onStartGame.
       * You will need to randomly pick two words from words
       * (be sure to store them in the fields named word1
       * and word2 so that the answer is given when the game is over).
       * Find a way to shuffle the letters of the words while preserving word order.
       * The simplest way to do that is probably to create a counter for each word
       * and randomly pick which word to grab a letter from and increment that counter
       * until either word runs out and then pick all the letters in the word that
       * was not exhausted. Write your scrambled string to the messageBox.
       *
       * Instead of just printing the scrambled string to messageBox,
       * create new LetterTile objects representing each letter of the
       * string and push them (in reverse order!) onto stackedLayout.
       **/
      word1 =  words.get((int) (Math.random() * words.size()));
      word2 = words.get((int) (Math.random() * words.size()));
      Log.d("word 1", word1);
      Log.d("word 2", word2);
      //Log.d(null," ");
      /*
      int counterWord1 = word1.length();
      int counterWord2 = word2.length();
      char[] w1charArr = word1.toCharArray();
      char[] w2charArr = word2.toCharArray();
      char[] wordsarr = new char[counterWord1+counterWord2];
      //char comboCharArr;
      while( ((counterWord1 != 0) && (counterWord2 != 0)))
      {
                  int idx1 = (int) (Math.random()*w1charArr.length);
          int idx2 = (int) (Math.random()*w2charArr.length);

          String tmp = word1.toString().charAt(idx1).concat(word2.toString().charAt(idx2));
          wordsarr[Math.abs(idx1%idx2)] = tmp;

      }
      Log.d("wordsarr output", wordsarr);
      */
      /*

      int counter = 0;
      int shorter = 0;
      String longerWordTemp = new String();
      int result = longerWord(word1,word2);
      Log.d("res", String.valueOf(result));

      if (result==2)
      {
       counter = word2.length();
       shorter = word1.length();
       longerWordTemp = word2;
      }
      else
      {
       counter = word1.length();
       shorter = word2.length();
       longerWordTemp = word1;
      }
      int idxw1 = 0;
      int idxw2 = 0;
      StringBuilder scrambledArray = new StringBuilder();
      for( int i=0; i < ;i++)
      {
       if (i < shorter) {
          if (random.nextBoolean()) {
             scrambledArray.append(word1.charAt(i));
          } else {
             scrambledArray.append(word2.charAt(i));
          }
       }

       else{
          scrambledArray.append(longerWordTemp.charAt(i));
       }

      //          if (i>shorter)
      //         {
      //
      //            scrambledArray.append(longerWordTemp.split("")[i]);
      //         }

      }


      Log.d("SCR",String.valueOf(scrambledArray));
      Log.d("counter value", String.valueOf(counter));

      return true;
      */
      String stringMerged = "";
      int longerWord = 0;
      int shorterWord = 0;
      int i;
      stackedLayout.clear();
      int counterWord1 = random.nextInt(words.size());
      int counterWord2 = random.nextInt(words.size());

      if (counterWord2 == counterWord1)
      {
         counterWord2 = random.nextInt(words.size());
         while (counterWord2 == counterWord1) {
            counterWord2 = random.nextInt(words.size());
         }
      }

      word1 = words.get(counterWord1);
      word2 = words.get(counterWord2);
      Boolean whichChar = random.nextBoolean();

      if (longerWord < word1.length() && shorterWord < word2.length())
      {
         stringMerged += whichChar ? word1.charAt(longerWord++) : word2.charAt(shorterWord++);
         whichChar = random.nextBoolean();

         while (longerWord < word1.length() && shorterWord < word2.length())
         {
            stringMerged += whichChar ? word1.charAt(longerWord++) : word2.charAt(shorterWord++);
            whichChar = random.nextBoolean();
         }
      }

      if(longerWord >= word1.length() && shorterWord < word2.length())
      {
         stringMerged += word2.charAt(shorterWord++);

         while (shorterWord < word2.length())
         {
            stringMerged += word2.charAt(shorterWord++);
         }
      }

      else
      {
         if (longerWord < word1.length())
         {
            stringMerged += word1.charAt(longerWord++);

            while (longerWord < word1.length())
            {
               stringMerged += word1.charAt(longerWord++);
            }
         }
      }

      messageBox.setText(stringMerged);
      Log.d("message", stringMerged);
         stackedLayout.clear();

      char[] stringChars = stringMerged.toCharArray();

      for(char c : stringChars)
      {
         stackedLayout.push(new LetterTile(this,c));
      }

      return true;
   }

   public int longerWord (String a, String b)
   {
      if (a.length() > b.length())
      {
         return 1;
      }

      return 2;
   }
   public boolean onUndo(View view)
   {
      /**
       **
       **  YOUR CODE GOES HERE
       **
       **/
      return true;
   }

   public boolean isGoodWord (String word)
   {
      return word.length() <= WORD_LENGTH;
   }
}

