package com.example.kontr2_25052022.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Parking implements Parcelable
{
    private String regNumber;
    private String owner;
    private boolean condition;

    public Parking()
    {
        this.regNumber = "0";
        this.owner = "Unnamed";
        this.condition = false;
    }

    public Parking(boolean condition) {
        this.condition = condition;
    }

    public Parking(String regNumber, String owner, boolean condition) {
        this.regNumber = regNumber;
        this.owner = owner;
        this.condition = condition;
    }

    protected Parking(Parcel in) {
        regNumber = in.readString();
        owner = in.readString();
        condition = in.readByte() != 0;
    }

    public static final Creator<Parking> CREATOR = new Creator<Parking>() {
        @Override
        public Parking createFromParcel(Parcel in) {
            return new Parking(in);
        }

        @Override
        public Parking[] newArray(int size) {
            return new Parking[size];
        }
    };

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public boolean isCondition() {
        return condition;
    }

    public void setCondition(boolean condition) {
        this.condition = condition;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(regNumber);
        parcel.writeString(owner);
        parcel.writeByte((byte) (condition ? 1 : 0));
    }
}
