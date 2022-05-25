package com.example.parking_2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.parking_2.DisplayFragment;
import com.example.parking_2.R;
import com.example.parking_2.holder.Holder;
import com.example.parking_2.model.Parking;

import java.util.ArrayList;
import java.util.List;

public class RecycleAdapter extends RecyclerView.Adapter<Holder> {
    private static final String FRAGMENT="fragment";
    private List<Parking> parkingList;
    private Context context;

    public RecycleAdapter(List<Parking> parkingList) {
        this.parkingList = parkingList;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        context=parent.getContext();
        LayoutInflater inflater=LayoutInflater.from(context); //RecyclerView e v MainAvtivity -> rabotim v konteksta na MainActivity
        View parkingListView=inflater.inflate(R.layout.item_layout,parent,false);
        Holder viewHolder=new Holder(parkingListView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {

        Parking p=parkingList.get(position);
        holder.setRegNum(p.getRegNumber());
        holder.setOwner(p.getOwner());
        //holder.setState(valueof(p));
        //holder.setState().setText(String.valueOf(parkings.get(position).isCondition()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AppCompatActivity activity=(AppCompatActivity)view.getContext();
                DisplayFragment displayFragment=new DisplayFragment();
                activity.getSupportFragmentManager().beginTransaction().commit();



/*
                FragmentTransaction fragmentTransaction=((AppCompatActivity)context).getSupportFragmentManager().beginTransaction();
                DisplayFragment displayFragment=DisplayFragment.getSupportFragmentManager().findFragmentByTag(FRAGMENT);

                if(displayFragment!=null)
                {
                    fragmentTransaction.remove(displayFragment);
                    fragmentTransaction.commit();
                }
           */ }
        });
    }

    @Override
    public int getItemCount() {
        return parkingList.size();
    }
    public void addParkingRoom(List<Parking> parkingList)
    {
        this.parkingList = parkingList;
        notifyDataSetChanged();
    }
}
