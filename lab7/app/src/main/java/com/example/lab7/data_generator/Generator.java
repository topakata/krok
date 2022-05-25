package com.example.lab7.data_generator;

import com.example.lab7.models.Fruit;
import com.example.lab7.models.Vegetable;

import java.util.ArrayList;
import java.util.Random;

public class Generator {
    public static ArrayList<Vegetable> generateList(int count)
    {

        ArrayList<Vegetable> items=new ArrayList<Vegetable>();
        Random random=new Random();

        for(int i=0; i<=count; i++)
        {
            items.add(new Vegetable("Vegetable " + i,10L+random.nextDouble()%99L,(10L+random.nextDouble()%99L)));
            items.add(new Fruit("Fruit " +i,22,33, 4));
        }
        return items;
    }
}
