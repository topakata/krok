package com.example.lab7.holder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab7.R;
import com.example.lab7.adapter.RecycleAdapter;

public class Holder extends RecyclerView.ViewHolder {
    //za recycle_item_layout
    private TextView name;
    private TextView qty;


    public Holder(@NonNull View itemView) {
        super(itemView);

        //izvlicha dannite ot izgleda
        name=itemView.findViewById(R.id.txtName);
        qty=itemView.findViewById(R.id.txtQty);
    }

    public TextView getName() {
        return name;
    }

    public void setName(String name) {
        this.name.setText(name);
    }

    public TextView getQty() {
        return qty;
    }

    public void setQty(double qty) {
        this.qty.setText(Double.toString(qty));
    }
}

