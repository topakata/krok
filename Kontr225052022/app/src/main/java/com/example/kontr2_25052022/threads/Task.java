package com.example.kontr2_25052022.threads;

import android.util.Log;

import com.example.kontr2_25052022.listener.parkingListener;
import com.example.kontr2_25052022.model.Parking;

import java.util.ArrayList;
import java.util.Random;

public class Task implements Runnable{

    public parkingListener listener;
    public ArrayList<Parking> parkings;

    public Task(parkingListener listener, ArrayList<Parking> parkings) {
        this.listener = listener;
        this.parkings = parkings;
    }

    @Override
    public void run() {
        //parkings.add(new Parking(new Random().nextBoolean()));
        for (int i = 0; i < parkings.size(); i++)
        {
            if(parkings.get(i).isCondition() == false)
            {
                parkings.get(new Random().nextInt(parkings.size())).setCondition(true);
                listener.addOneParkingList(parkings);
                Log.i("out", parkings.get(i).getRegNumber());
            }
            else
            {
                parkings.get(new Random().nextInt(parkings.size())).setCondition(false);
                listener.addOneParkingList(parkings);
                Log.i("insert", parkings.get(i).getRegNumber());
            }
        }

    }
}
