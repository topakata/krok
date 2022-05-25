package com.example.parking_2.holder;

import android.view.View;
import android.widget.TextView;
import com.example.parking_2.R;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Holder extends RecyclerView.ViewHolder {
    private TextView regNum,owner,state;


    public Holder(@NonNull View itemView) {
        super(itemView);

        regNum = itemView.findViewById(R.id.regNomer);
        owner=itemView.findViewById(R.id.sobstvenik);
        state=itemView.findViewById(R.id.systoqnie);

    }
    public TextView getRegNum() {
        return regNum;
    }

    public void setRegNum(String regNum) {

        this.regNum.setText(regNum);
    }

    public TextView getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner.setText(owner);

    }

    public TextView getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state.setText(Boolean.toString(state));

    }


}
