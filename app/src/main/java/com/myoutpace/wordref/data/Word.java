package com.myoutpace.wordref.data;

import android.os.Parcel;
import android.os.Parcelable;

public class Word implements Parcelable {
    private String word;
    private String meaning;
    private String example;

    public Word(String w, String m, String e) {
        this.word = w;
        this.meaning = m;
        this.example = e;
    }

    protected Word(Parcel in) {
        word = in.readString();
        meaning = in.readString();
        example = in.readString();
    }

    public static final Creator<Word> CREATOR = new Creator<Word>() {
        @Override
        public Word createFromParcel(Parcel in) {
            return new Word(in);
        }

        @Override
        public Word[] newArray(int size) {
            return new Word[size];
        }
    };

    public String getWord() {
        return this.word;
    }

    public String getMeaning() {
        return this.meaning;
    }

    public String getExample() {
        return this.example;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(word);
        parcel.writeString(meaning);
        parcel.writeString(example);
    }
}