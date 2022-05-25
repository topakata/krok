package com.example.lab7.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Vegetable implements Parcelable {
    private String name;
    private double price;
    private double qty;

    public Vegetable(String name, double price, double qty) {
        this.name = name;
        this.price = price;
        this.qty = qty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getQty() {
        return qty;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }

    protected Vegetable(Parcel in) {
        name = in.readString();
        price = in.readDouble();
        qty = in.readDouble();
    }

    public static final Creator<Vegetable> CREATOR = new Creator<Vegetable>() {
        @Override
        public Vegetable createFromParcel(Parcel in) {
            return new Vegetable(in);
        }

        @Override
        public Vegetable[] newArray(int size) {
            return new Vegetable[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeDouble(price);
        parcel.writeDouble(qty);
    }
}
