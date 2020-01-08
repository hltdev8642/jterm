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

package com.google.engedu.anagrams;
import android.util.Log;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class AnagramDictionary
{

    private static final int MIN_NUM_ANAGRAMS = 5;
    private static final int DEFAULT_WORD_LENGTH = 3;
    private static final int MAX_WORD_LENGTH = 7;
    private ArrayList<String> wordList = new ArrayList<>();
    private HashSet<String> wordSet = new HashSet<>();
    private HashMap<Integer, ArrayList<String>> sizeToWords = new HashMap<Integer, ArrayList<String>>();


    public AnagramDictionary(Reader reader) throws IOException
    {
        BufferedReader in = new BufferedReader(reader);
        String line;

        while((line = in.readLine()) != null)
        {
            String word = line.trim();
            wordList.add(word);
            wordSet.add(word);
        }

        for(String word : wordList)
        {
            sizeToWords.put(word.length(),new ArrayList<String>());

            if (sizeToWords.containsKey(word.length()))
            {
                sizeToWords.put(word.length(),new ArrayList<String>());
            }

        }



    }

    public boolean isGoodWord(String word, String base)
    {
        // Log.d("sortedWord", sortLetters(word));

        if (wordSet.contains(word))
        {
            return sortLetters(word).equals(sortLetters(base));
        }

        return sortLetters(word).equals(sortLetters(base));

    }

    public String sortLetters (String s)
    {
        char[] strInput = s.toCharArray();
        Arrays.sort(strInput);
        return new String(strInput);

    }

    public List<String> getAnagrams(String targetWord)
    {
        //Log.d("j-term", targetWord);
        ArrayList<String> result = new ArrayList<String>();

        for(String i : wordList)
        {
            if (sortLetters(i).equals(sortLetters(targetWord)))
            {
                result.add(i);
            }

        }
        return result;
    }

    public List<String> getAnagramsWithOneMoreLetter(String word)
    {
        ArrayList<String> result = new ArrayList<String>();
        String charTmp = "abcdefghijklmnopqrstuvwxyz";
        String[] charArr = charTmp.split("");


        for(int i = 0; i < charArr.length;i++)
        {
            String newWord = sortLetters(charArr[i] + "" + word);
//            if(newWord.equals(sortLetters()))
            if(newWord.equals(sortLetters(charArr[i]))){
                result.add(newWord);
            }


        }

        for(String i : wordList)
        {
            if (sortLetters(i).equals(sortLetters(word)))
            {
                result.add(i);
            }

        }

        return result;
    }

    public String pickGoodStarterWord()
    {
        Boolean loop = true;
        String word = "Stop";
        while(loop)
        {
            double randomIndex = (Math.random() * wordList.size());
            word = wordList.get((int) randomIndex);
            if((word.length() <= MAX_WORD_LENGTH) && (getAnagrams(word).toArray().length >= MIN_NUM_ANAGRAMS))
            {
                loop = false;
            }
        }
        return word;
    }
}
