package com.example.kontr2_25052022.fragment;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kontr2_25052022.R;
import com.example.kontr2_25052022.model.Parking;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ParkingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class ParkingFragment extends Fragment {

    TextView regNumberView;
    TextView ownerView;
    TextView conditionView;
    TextView descView;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";

    // TODO: Rename and change types of parameters
   // private String mParam1;

    public ParkingFragment() {
        // Required empty public constructor
    }


    public static ParkingFragment newInstance(Parking parking) {
        ParkingFragment fragment = new ParkingFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_PARAM1, parking);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
           //mParam1 = getArguments().getParcelable(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_parking, container, false);
        regNumberView = view.findViewById(R.id.regNumberView1);
        ownerView = view.findViewById(R.id.ownerView1);
        conditionView = view.findViewById(R.id.conditionView1);
        descView = view.findViewById(R.id.descView1);

        Parking parking = getArguments().getParcelable(ARG_PARAM1);
        regNumberView.setText(parking.getRegNumber());
        ownerView.setText(parking.getOwner());
        conditionView.setText(String.valueOf(parking.isCondition()));
        descView.setText(descView.getText().toString());
        return view;
    }
}