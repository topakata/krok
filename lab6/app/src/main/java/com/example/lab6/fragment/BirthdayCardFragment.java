package com.example.lab6.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lab6.R;
import com.example.lab6.model.BirthdayCard;

import org.w3c.dom.Text;


public class BirthdayCardFragment extends Fragment {

    // iztrivame vtorata final

    private static final String ARG_PARAM1 = "param1";

    private BirthdayCard birthdayCard;



    public BirthdayCardFragment() {
        // Required empty public constructor
    }


    public static BirthdayCardFragment newInstance(BirthdayCard card) {
        BirthdayCardFragment fragment = new BirthdayCardFragment();
        Bundle args = new Bundle(); //syhranqva danni kluch-stoinost
        args.putParcelable(ARG_PARAM1, card);
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
        //iztrivame return i pishem View view=
        View view = inflater.inflate(R.layout.fragment_birthday_card, container, false);

        TextView tvName=view.findViewById(R.id.cardName);
        TextView tvAge=view.findViewById(R.id.cardAge);

        BirthdayCard card=getArguments().getParcelable(ARG_PARAM1);

        if(card!=null) {

            tvName.setText(card.getName());
            tvAge.setText(String.valueOf(card.getAge()));
        }
        return view;
    }
}