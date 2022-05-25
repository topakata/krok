package com.example.lab7.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab7.MainActivity;
import com.example.lab7.MainActivity2;
import com.example.lab7.R;
import com.example.lab7.holder.Holder;
import com.example.lab7.models.Fruit;
import com.example.lab7.models.Vegetable;
import com.google.android.material.transition.Hold;

import java.util.List;

public class RecycleAdapter extends RecyclerView.Adapter<Holder> {

    private List<Vegetable> shop;
    private Context context;


    public RecycleAdapter(List<Vegetable> shop) {
        this.shop = shop;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {

        //izvlicha konteksta kydeto se namira RecyclerView
        context=parent.getContext();
        LayoutInflater inflater=LayoutInflater.from(context); //RecyclerView e v MainAvtivity -> rabotim v konteksta na MainActivity

        //izvlicha personaliziran izgled
        View shopView=inflater.inflate(R.layout.recyle_item_layout,parent,false);

        //syzdava ViewHolder obekt i go vryshta
        Holder viewHolder=new Holder(shopView);
        return viewHolder;


    }

    //syzdava dannite s izgleda
    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position)
    {
        //vzima tekushtiq element ot kolekciqta
        Vegetable item=shop.get(position);

        //postavq stoinost na TextView za ime
        holder.setName(item.getName());

        //postavq stoinost na TextView za kolichestvo
        holder.setQty(item.getQty());

        //postavq slushatel za natiskane na element ot spisyka
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(item instanceof Fruit) //dali e fruit ili vegetable
                {
                    Fruit fruit=(Fruit) item;
                    Intent intent=new Intent(context, MainActivity2.class);
                    intent.putExtra("fruit",fruit);
                    ((Activity)context).startActivityForResult(intent,1002);

                }
                else
                {
                    Intent intent=new Intent(context,MainActivity2.class);
                    intent.putExtra("vegetable",item);
                    ((Activity)context).startActivityForResult(intent,1002);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return shop.size(); //promenqme!!!
    }
}
