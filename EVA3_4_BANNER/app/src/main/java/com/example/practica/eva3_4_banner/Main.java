package com.example.practica.eva3_4_banner;

import android.media.Image;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.ImageViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class Main extends AppCompatActivity {

    private SeekBar seekBar;
    ImageView imgVwBanner;
    int iCont= 1;
    TextView textView;

    Handler hManejador = new Handler(){

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            //RECIBIR IAGEN
            //CAMBIAR IMAGEN
            switch(iCont){
                case 1:
                    imgVwBanner.setImageResource(R.drawable.cloudy);
                    iCont++;
                    break;
                case 2:
                    imgVwBanner.setImageResource(R.drawable.light_rain);
                    iCont++;
                    break;
                case 3:
                    imgVwBanner.setImageResource(R.drawable.rainy);
                    iCont++;
                    break;
                case 4:
                    imgVwBanner.setImageResource(R.drawable.sunny);
                    iCont++;
                    break;
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgVwBanner= findViewById(R.id.imgVwBanner);
        Banner bMiBanner = new Banner ();
        bMiBanner.start();
        seekBar = findViewById(R.id.seekBar);
        textView= findViewById(R.id.textView);



        // Initialize the textview with '0'.
        textView.setText("Covered: " + seekBar.getProgress() + "/" + seekBar.getMax());

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progress = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) {
                progress = progresValue;
                Toast.makeText(getApplicationContext(), "Changing seekbar's progress", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(getApplicationContext(), "Started tracking seekbar", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                textView.setText("Covered: " + progress + "/" + seekBar.getMax());
                Toast.makeText(getApplicationContext(), "Stopped tracking seekbar", Toast.LENGTH_SHORT).show();
            }
        });




    }

    class Banner extends Thread{
        @Override
        public void run() {
            super.run();
            while(true){
                try{
                    Thread.sleep(seekBar.getProgress());
                    Message msg = hManejador.obtainMessage();
                    hManejador.sendMessage(msg);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
