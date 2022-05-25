package com.example.parking_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;

import com.example.parking_2.adapter.RecycleAdapter;
import com.example.parking_2.data_generator.Generator;
import com.example.parking_2.listener.parkingListener;
import com.example.parking_2.model.Parking;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements parkingListener {
    private RecycleAdapter adapter;
    RecyclerView recyclerView;
    private List<Parking> parking_data;
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        parking_data= Generator.generateList(9);

        RecyclerView recyclerView=findViewById(R.id.recyclerView);
        adapter=new RecycleAdapter(parking_data);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


    @Override
    public void addParking(Parking parking) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.recyclerView, DisplayFragment.newInstance(parking), "displayFragment")
                .commit();
    }

    @Override
    public void addOneParkingList(List<Parking> parkingList) {
        adapter = (RecycleAdapter) recyclerView.getAdapter();
        if(adapter != null)
        {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    adapter.addParkingRoom(parkingList);
                }
            });
        }

        //handler.postDelayed(new Task(this, parkingList), 3000);
    }
}