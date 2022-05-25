package com.example.parking_2.model;

import android.os.Parcel;
import android.os.Parcelable;

public class
Parking implements Parcelable {

    private String regNumber;
    private String owner;
    private boolean state;

    public Parking() {
        this.regNumber = "0";
        this.owner = "No Name";
        this.state = false;
    }

    public Parking(String regNumber, String owner, boolean state) {
        this.regNumber = regNumber;
        this.owner = owner;
        this.state = state;
    }

    protected Parking(Parcel in) {
        regNumber = in.readString();
        owner = in.readString();
        state = in.readByte() != 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(regNumber);
        dest.writeString(owner);
        dest.writeByte((byte) (state ? 1 : 0));
    }

    @Override
    public int describeContents() {
        return 0;
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

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}
