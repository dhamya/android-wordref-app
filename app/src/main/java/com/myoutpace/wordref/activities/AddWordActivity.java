package com.myoutpace.wordref.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.myoutpace.wordref.R;
import com.myoutpace.wordref.data.Word;
import com.myoutpace.wordref.data.WordListOperator;

/**
 * Created by Shilpa Dhamdhere on 9/10/17.
 */

public class AddWordActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_add);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    startActivity(new Intent(getBaseContext(), MainActivity.class));
                    return true;
                case R.id.navigation_addword:
                    startActivity(new Intent("com.myoutpace.wordref.activities.AddWordActivity"));
                    return true;
            }
            return false;
        }

    };

    public void addWord(View view){
        Log.d("Action:", "add word button clicked");
        EditText wrd = (EditText) findViewById(R.id.word);
        EditText mng = (EditText) findViewById(R.id.meaning);
        EditText exmpl = (EditText) findViewById(R.id.example);


        Word w = new Word(wrd.getText().toString(),mng.getText().toString(),exmpl.getText().toString());
        WordListOperator.getInstance().addWord(w);
        Toast.makeText(getApplicationContext(),"Word '" + wrd.getText().toString() + "' was added, use back button for search", Toast.LENGTH_LONG);
        startActivity(new Intent(this, MainActivity.class));
    }
}
