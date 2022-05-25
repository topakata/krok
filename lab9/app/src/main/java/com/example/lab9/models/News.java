package com.example.lab9.models;

import android.os.Parcel;
import android.os.Parcelable;

public class News implements Parcelable {

    private String title;
    private String author;
    private String reference;
    private String text;

    public News(String title, String author, String reference, String text) {
        this.title = title;
        this.author = author;
        this.reference = reference;
        this.text = text;
    }


    protected News(Parcel in) {
        title = in.readString();
        author = in.readString();
        reference = in.readString();
        text = in.readString();
    }

    public static final Creator<News> CREATOR = new Creator<News>() {
        @Override
        public News createFromParcel(Parcel in) {
            return new News(in);
        }

        @Override
        public News[] newArray(int size) {
            return new News[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(author);
        parcel.writeString(reference);
        parcel.writeString(text);
    }
}

