package com.example.lab7.models;

import android.os.Parcel;

public class Fruit extends Vegetable{

    private int index;


    public Fruit(String name, double price, double qty,int index) {
        super(name, price, qty);
        this.index=index;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    protected Fruit(Parcel in) {
        super(in);
        this.index=in.readInt();
    }
    public static final Creator<Fruit> CREATOR = new Creator<Fruit>() {
        @Override
        public Fruit createFromParcel(Parcel in) {
            return new Fruit(in);
        }

        @Override
        public Fruit[] newArray(int size) {
            return new Fruit[size];
        }
    };

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(index);
    }

    @Override
    public int describeContents() {
        return super.describeContents();
    }
}
