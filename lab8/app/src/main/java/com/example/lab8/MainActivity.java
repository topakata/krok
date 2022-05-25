package com.example.lab8;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.service.autofill.FieldClassification;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private Handler handler;
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX=Pattern.compile("[a-zA-Z0-9._-]+@[a-z]+\\\\.+[a-z]+",Pattern.CASE_INSENSITIVE);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText email=findViewById(R.id.etEmail);
        Button validate=findViewById(R.id.btnValidate);
        validate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProgressBar progressBar=findViewById(R.id.progressBar);

                HandlerThread handlerThread=new HandlerThread("HandledName");
                handlerThread.start();
                handler=new Handler(handlerThread.getLooper())
                {
                    @Override
                    public void handleMessage(@NonNull Message msg) {
                        //super.handleMessage(msg);
                        if(progressBar.getProgress()!=100)
                        {
                            progressBar.incrementProgressBy(50);
                        }
                        else
                        {
                            if(validate_email(email.getText().toString()))
                            {
                                email.setError("error");
                            }
                            else
                            {
                                Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                                startActivity(intent);
                            }
                        }
                    }
                };
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        handler.sendEmptyMessage(0);
                    }
                });
            }
        });

    }

    boolean validate_email (String email)
    {
        Matcher matcher=VALID_EMAIL_ADDRESS_REGEX.matcher(email);
        return matcher.find();
    }
}