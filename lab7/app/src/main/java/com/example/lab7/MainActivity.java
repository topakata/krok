package com.example.lab7;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.lab7.adapter.RecycleAdapter;
import com.example.lab7.data_generator.Generator;
import com.example.lab7.models.Fruit;
import com.example.lab7.models.Vegetable;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private RecycleAdapter adapter;
    private List<Vegetable>shop_data;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        shop_data= Generator.generateList(10);

        RecyclerView recyclerView=(RecyclerView) findViewById(R.id.recycle);
        adapter=new RecycleAdapter(shop_data);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FloatingActionButton fab=findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(Vegetable v:shop_data)
                {
                    v.setQty(new Random().nextInt());
                    adapter.notifyDataSetChanged();
                }
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Fruit fruit=data.getParcelableExtra("fruit");
        Vegetable vege=data.getParcelableExtra("vegetable");
        for(Vegetable v:shop_data)
        {
            if(fruit!=null)
            {
                if(v.getName().equals(fruit.getName()))
                {
                    v.setQty(fruit.getQty());
                }
                else
                {
                    if(v.getName().equals(vege.getName()))
                    {
                        v.setQty(vege.getQty());
                    }
                }
            }
            adapter.notifyDataSetChanged(); //za da se refresh-ne RecyclerView-to
        }
    }
}