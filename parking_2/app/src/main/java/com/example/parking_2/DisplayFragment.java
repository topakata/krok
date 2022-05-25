package com.example.parking_2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.parking_2.model.Parking;


public class DisplayFragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";


    private Parking parking;

    public DisplayFragment() {
    }


    public static DisplayFragment newInstance(Parking parking) {
        DisplayFragment fragment = new DisplayFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_PARAM1, parking);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_display, container, false);

        TextView tvRegNum=view.findViewById(R.id.regNumView);
        TextView tvOwner=view.findViewById(R.id.ownerView);
        TextView tvState=view.findViewById(R.id.stateView);
        TextView tvMark=view.findViewById(R.id.markView);
        TextView tvModel=view.findViewById(R.id.modelView);
        TextView tvFuel=view.findViewById(R.id.fuelView);

        Parking p=getArguments().getParcelable(ARG_PARAM1);

        if(p!=null)
        {
            tvRegNum.setText(p.getRegNumber());
            tvOwner.setText(p.getOwner());
            //tvState.setText(p.isState());
            //tvMark.setText(p.getMark);

        }
        return view;
    }
}