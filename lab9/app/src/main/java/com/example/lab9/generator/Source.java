package com.example.lab9.generator;

import com.example.lab9.models.News;

import java.util.ArrayList;
import java.util.Random;

public class Source {
    public static ArrayList<News> generateList(int count)
    {

        ArrayList<News> items=new ArrayList<News>();
        Random random=new Random();

        for(int i=0; i<=count; i++)
        {
            items.add(new News("News " + i,"Author " + i,"Reference " + i, "Text " + i));
        }
        return items;
    }
}
