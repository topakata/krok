package com.example.lab8;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    Handler handler;
    int sec,min,hour;
    boolean keepWorking;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView txtTimer=findViewById(R.id.textViewTimer);
        Button start=findViewById(R.id.btnStart);
        Button stop=findViewById(R.id.btnStop);
        Button reset=findViewById(R.id.btnReset);


        HandlerThread handlerThread=new HandlerThread("HandlerThreadName");
        handlerThread.start();
        handler=new Handler(handlerThread.getLooper())
        {
            @Override
            public void handleMessage(@NonNull Message msg) {
                Bundle bundle=msg.getData();

                Object time=bundle.get("time");
                if(time!=null)
                {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                                txtTimer.setText(time.toString());
                        }
                    });

                }

                Object stop=bundle.get("stop");
                if(stop!=null)
                {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            keepWorking=true;
                            txtTimer.setText(stop.toString());
                        }
                    });
                }

                Object reset=bundle.get("reset");
                if(reset!=null)
                {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run()
                        {
                            sec=min=hour=0;
                            txtTimer.setText("00:00:00");
                        }
                    });
                }

            }
        };



        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                keepWorking=false;

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        if(!keepWorking)
                        {
                            if(sec==59)
                            {
                                min++;
                                sec=0;
                                if(min==59)
                                {
                                    hour++;
                                    min=0;
                                }
                            }
                            else sec++;
                            Message message=handler.obtainMessage();
                            Bundle b=new Bundle();
                            b.putString("time", hour + ":" + min + ":" + sec);
                            message.setData(b);
                            handler.sendMessage(message);

                            handler.postDelayed(this,1000); //1000 ms = 1 sec zakysnenie




                        }
                    }
                });

            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handler.post(new Runnable() {
                    @Override
                    public void run()
                    {
                        Message message=handler.obtainMessage();
                        Bundle b=new Bundle();
                        b.putString("stop", hour + ":" + min + ":" + sec);
                        message.setData(b);
                        handler.postDelayed(this,1000);

                    }
                });
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Message message=handler.obtainMessage();
                        Bundle b=new Bundle();
                        b.putString("reset","reset");
                        message.setData(b);
                        handler.postDelayed(this,1000);
                    }
                });

            }
        });
    }
}