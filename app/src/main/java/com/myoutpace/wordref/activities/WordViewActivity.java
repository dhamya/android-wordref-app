package com.myoutpace.wordref.activities;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.myoutpace.wordref.R;
import com.myoutpace.wordref.data.Word;
import com.myoutpace.wordref.utils.Constants;

public class WordViewActivity extends Activity {
    // Declare Variables
    TextView txtrank;
    TextView txtcountry;
    TextView txtpopulation;
    String word;
    String meaning;
    String example;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_details);
        // Retrieve data from MainActivity on item click event
        Intent i = getIntent();
        Word w = null;
        Bundle b = i.getExtras();
        if(b != null)
            w = b.getParcelable(Constants.PARCEL_KEY_WORD);

        // Locate the TextViews in word_detailsml
        txtrank = (TextView) findViewById(R.id.word);
        txtcountry = (TextView) findViewById(R.id.meaning);
        txtpopulation = (TextView) findViewById(R.id.example);

        // Load the results into the TextViews
        txtrank.setText(w == null ? "ERROR!" : w.getWord());
        txtcountry.setText(meaning = w == null ? "ERROR!" : w.getMeaning());
        txtpopulation.setText(example = w == null ? "ERROR!" : w.getExample());
    }
}