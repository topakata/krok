package com.example.kontr2_25052022.model;

import java.util.ArrayList;
import java.util.Random;

public class Generator
{
    public static ArrayList<Parking> generateParking(int amount)
    {
        ArrayList<Parking> parkings = new ArrayList<>();
        for (int i = 0; i < amount; i++)
        {
            parkings.add(new Parking("BG12313fd"+i, "Ivan Ivanov"+i, new Random().nextBoolean()));
        }
        return parkings;
    }
};
