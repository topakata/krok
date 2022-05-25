package com.example.lab6.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.example.lab6.R;
import com.example.lab6.model.BirthdayCard;

public class BirthdayDialogFragment extends DialogFragment implements View.OnClickListener {

    private EditText name,age;
    private Button btnSave, btnCancel;

    private AddCardListener listener;

    public BirthdayDialogFragment() {
        // Required empty public constructor
    }


    public static BirthdayDialogFragment newInstance() {

        return new BirthdayDialogFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_birthday_dialog, container, false);
    }

    @Override
    public void onClick(View view) {
        //butonite ot fragmet_dialog_layout

        switch(view.getId())
        {
            case R.id.buttonSave:
                BirthdayCard card=new BirthdayCard(name.getText().toString(), Integer.parseInt(age.getText().toString()),1);

                listener.onFinishAddCard(card);
                dismiss();
                break;


            default:
                dismiss();
                break;
        }
    }



    //nie override-vame

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listener=(AddCardListener) context;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        name=view.findViewById(R.id.editName);
        age=view.findViewById(R.id.editAge);
        btnSave=view.findViewById(R.id.buttonSave);
        btnCancel=view.findViewById(R.id.buttonCancel);

        btnSave.setOnClickListener(this);
        btnCancel.setOnClickListener(this);

        //nezadyljitelni:
        name.requestFocus();
        getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE); //ZA IZVEJDANE NA KLAVIATURA ZA VYVEJDANE
    }
}