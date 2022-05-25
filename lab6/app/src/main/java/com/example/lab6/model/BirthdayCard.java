package com.example.lab6.model;

import android.os.Parcel;
import android.os.Parcelable;

public class BirthdayCard implements Parcelable {

    private String name;
    private int age;
    private int background_color;

    public BirthdayCard(String name, int age, int background_color) {
        this.name = name;
        this.age = age;
        this.background_color = background_color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getBackground_color() {
        return background_color;
    }

    public void setBackground_color(int background_color) {
        this.background_color = background_color;
    }

    public static Creator<BirthdayCard> getCREATOR() {
        return CREATOR;
    }

    protected BirthdayCard(Parcel in) {
        name=in.readString();
        age=in.readInt();
        background_color=in.readInt();
    }

    public static final Creator<BirthdayCard> CREATOR = new Creator<BirthdayCard>() {
        @Override
        public BirthdayCard createFromParcel(Parcel in) {
            return new BirthdayCard(in);
        }

        @Override
        public BirthdayCard[] newArray(int size) {
            return new BirthdayCard[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeInt(age);
        parcel.writeInt(background_color);
    }

}
