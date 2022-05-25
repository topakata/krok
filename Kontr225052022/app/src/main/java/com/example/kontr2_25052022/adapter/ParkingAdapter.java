package com.example.kontr2_25052022.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kontr2_25052022.R;
import com.example.kontr2_25052022.model.Parking;
import com.example.kontr2_25052022.listener.parkingListener;

import java.util.ArrayList;

public class ParkingAdapter extends RecyclerView.Adapter<ParkingAdapter.MyViewHolder>
{
    ArrayList<Parking> parkings;
    Context context;
    parkingListener listener;

    public ParkingAdapter(ArrayList<Parking> parkings, Context context, parkingListener listener)
    {
        this.parkings = parkings;
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override


    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.layout_one_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position)
    {
        holder.regNumberView.setText(parkings.get(position).getRegNumber());
        holder.ownerView.setText(parkings.get(position).getOwner());
        holder.conditionView.setText(String.valueOf(parkings.get(position).isCondition()));
        Parking parking = parkings.get(position);
        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Show something on click", Toast.LENGTH_SHORT).show();
                listener.addParking(parking);
            }
        });
    }

    @Override
    public int getItemCount() {
        return parkings.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView regNumberView;
        TextView ownerView;
        TextView conditionView;
        ConstraintLayout constraintLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            regNumberView = itemView.findViewById(R.id.regNumberView1);
            ownerView = itemView.findViewById(R.id.ownerView1);
            conditionView = itemView.findViewById(R.id.conditionView1);
            constraintLayout = itemView.findViewById(R.id.constrainLayout);
        }
    }
    public void addParkingRoom(ArrayList<Parking> parkings)
    {
        this.parkings = parkings;
        notifyDataSetChanged();
    }
}
