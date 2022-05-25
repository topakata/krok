package com.example.kontr2_25052022;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;

import com.example.kontr2_25052022.adapter.ParkingAdapter;
import com.example.kontr2_25052022.fragment.ParkingFragment;
import com.example.kontr2_25052022.listener.parkingListener;
import com.example.kontr2_25052022.model.Generator;
import com.example.kontr2_25052022.model.Parking;
import com.example.kontr2_25052022.threads.Task;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements parkingListener {
    RecyclerView recyclerView;
    ArrayList<Parking> parkings;
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);

        parkings = Generator.generateParking(10);
        recyclerView.setAdapter(new ParkingAdapter(parkings, this, this));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        HandlerThread handlerThread = new HandlerThread("ime");
        handlerThread.start();
        handler = new Handler(handlerThread.getLooper());
        handler.postDelayed(new Task(this, parkings), 3000);
    }


    @Override
    public void addParking(Parking parking)
    {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.recyclerView, ParkingFragment.newInstance(parking), "parkingFragment")
                .commit();
    }

    @Override
    public void addOneParkingList(ArrayList<Parking> parkingArrayList) {
        ParkingAdapter parkingAdapter = (ParkingAdapter) recyclerView.getAdapter();
        if(parkingAdapter != null)
        {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    parkingAdapter.addParkingRoom(parkingArrayList);
                }
            });
        }
        handler.postDelayed(new Task(this, parkings), 3000);
    }
}