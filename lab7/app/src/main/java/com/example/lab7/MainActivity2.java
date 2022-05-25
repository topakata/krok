package com.example.lab7;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.lab7.models.Fruit;
import com.example.lab7.models.Vegetable;

public class MainActivity2 extends AppCompatActivity {

    private Fruit fruit;
    private Vegetable vegetable;
    private double available_qty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView tvName = findViewById(R.id.dispName);
        //TextView tvQty = findViewById(R.id.txtQty);
        TextView tvIndex = findViewById(R.id.dispIndex);
        TextView tvPrice = findViewById(R.id.dispPrice);
        TextView tvBuyPrice = findViewById(R.id.dispBuyPrice);
        EditText enterQty = findViewById(R.id.buyQty);
        Button buttonBuy = findViewById(R.id.btnBuy);

        Intent intent = getIntent();
        vegetable = intent.getParcelableExtra("vegetable");

        if (vegetable == null) {
            fruit = intent.getParcelableExtra("fruit");
            tvName.setText(fruit.getName());
            tvPrice.setText(String.valueOf(fruit.getPrice()));
            tvIndex.setText(String.valueOf(fruit.getIndex()));
            available_qty = fruit.getQty();

        } else {
            tvName.setText(vegetable.getName());
            tvPrice.setText(String.valueOf(vegetable.getPrice()));
            available_qty = vegetable.getQty();
        }

        enterQty.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                double qty = Double.parseDouble(charSequence.toString());
                double calcPrice = qty * Double.parseDouble(tvPrice.getText().toString());
                tvBuyPrice.setText(String.valueOf(calcPrice));
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        buttonBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (Double.parseDouble(enterQty.getText().toString()) > available_qty) {
                    //set error
                } else {
                    if (fruit != null) {
                        fruit.setQty(available_qty - Double.parseDouble(enterQty.getText().toString()));
                    } else {
                        vegetable.setQty(available_qty - Double.parseDouble(enterQty.getText().toString()));
                    }

                }
                onBackPressed();
            }
        });
    }
                //onbackpressend - override
        @Override
        public void onBackPressed() {
            Intent intent=new Intent();
            if(vegetable==null)
            {
                intent.putExtra("fruit",fruit);
            }
            else
            {
                intent.putExtra("vegetable", vegetable);

            }
            setResult(Activity.RESULT_OK, intent);
            //finish();
            super.onBackPressed();
        }
    }
