package com.myoutpace.wordref.data;

import java.util.ArrayList;

/**
 * Created by Shilpa Dhamdhere on 9/10/17.
 */

public class WordListOperator {

    private static WordListOperator instance=null;
    private static ArrayList<Word> words = new ArrayList<Word>();

    public static WordListOperator getInstance() {
        if(instance == null) {
            instance = new WordListOperator();
            instance.loadData();
        }

        return instance;
    }

    protected WordListOperator() {
        //nothing here
    }

    private void loadData(){
        //Fake for now
        String[] arrWord = new String[] { "advert","snow","link","trick","ring"};

        String[] arrMeaning = new String[] { "an advertisement",
                "atmospheric water vapor frozen into ice crystals and falling in light white flakes or lying on the ground as a white layer",
                "a relationship between two things or situations",
                "an act of deceiving",
                "circular object"};

        String[] arrExample = new String[] { "he had failed to advert to the consequences that his conduct was having",
                "The snow was light and fluffy",
                "The link between weather and pollution is obvious",
                "I understaood your trick very well",
                "The wedding ring was pretty"};

        for (int i = 0; i < arrWord.length; i++)
        {
            Word wp = new Word(arrWord[i], arrMeaning[i], arrExample[i]);
            words.add(wp);
        }
    }

    public ArrayList<Word> getWords() {
        return words;
    }

    public synchronized void addWord(Word w){
        words.add(w);
    }

    public synchronized  void deleteWord(Word w){
        words.remove(w);
    }

}
