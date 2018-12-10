package com.example.practica.eva3_13;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main extends AppCompatActivity {

    Intent inServ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inServ = new Intent(this, ServicePlayer.class);

    }

    public void clickIni(View v){
        startService(inServ);

    }

    public void clickFin(View v){
        stopService(inServ);

    }
}