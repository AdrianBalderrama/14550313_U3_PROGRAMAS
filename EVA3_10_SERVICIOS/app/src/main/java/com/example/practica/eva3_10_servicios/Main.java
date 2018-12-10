package com.example.practica.eva3_10_servicios;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main extends AppCompatActivity {

    Intent inServicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inServicio = new Intent(this, MiServicio.class);
    }

    public void onClickIniciar(View view){
        startService(inServicio);
    }

    public void onClickDetener(View view){
        stopService(inServicio);
    }
}
