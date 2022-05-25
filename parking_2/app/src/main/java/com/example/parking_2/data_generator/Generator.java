package com.example.parking_2.data_generator;

import com.example.parking_2.model.Parking;

import java.util.ArrayList;
import java.util.Random;

public class Generator {
    public static ArrayList<Parking> generateList(int count)
    {

        ArrayList<Parking> items=new ArrayList<Parking>();
        Random random=new Random();

        for(int i=0; i<=count; i++)
        {
            items.add(new Parking("B123" + i + "CA","Name Family" + i,random.nextBoolean()));

        }
        return items;
    }
}
