package com.myoutpace.wordref.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.myoutpace.wordref.R;
import com.myoutpace.wordref.activities.WordViewActivity;
import com.myoutpace.wordref.data.Word;
import com.myoutpace.wordref.utils.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ListViewAdapter extends BaseAdapter {

    // Declare Variables
    Context mContext;
    LayoutInflater inflater;
    private List<Word> wordList = null;
    private ArrayList<Word> arraylist;

    public ListViewAdapter(Context context, List<Word> worldpopulationlist) {
        mContext = context;
        this.wordList = worldpopulationlist;
        inflater = LayoutInflater.from(mContext);
        this.arraylist = new ArrayList<Word>();
        this.arraylist.addAll(worldpopulationlist);
    }

    public class ViewHolder {
        TextView word;
        TextView meaning;
        TextView example;
    }

    @Override
    public int getCount() {
        return wordList.size();
    }

    @Override
    public Word getItem(int position) {
        return wordList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View view, ViewGroup parent) {
        ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.word_single, null);
            // Locate the TextViews in word_single.xml
            holder.word = (TextView) view.findViewById(R.id.word);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        // Set the results into TextViews
        holder.word.setText(wordList.get(position).getWord());

        // Listen for ListView Item Click
        view.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // Send single item click data to WordViewActivity Class
                Intent intent = new Intent(mContext, WordViewActivity.class);
                Bundle b = new Bundle();
                b.putParcelable(Constants.PARCEL_KEY_WORD, wordList.get(position));
                intent.putExtras(b);
                mContext.startActivity(intent);
            }
        });

        return view;
    }

    // Filter Class
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        wordList.clear();
        if (charText.length() == 0) {
            wordList.addAll(arraylist);
        }
        else
        {
            for (Word wp : arraylist)
            {
                if (wp.getWord().toLowerCase(Locale.getDefault()).contains(charText))
                    wordList.add(wp);
            }
        }
        notifyDataSetChanged();
    }

}
