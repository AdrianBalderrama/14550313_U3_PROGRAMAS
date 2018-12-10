package com.example.practica.eva3_2_hilos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main extends AppCompatActivity {

    TextView txtVwDatos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtVwDatos=findViewById(R.id.txtVwDatos);

        Runnable rHilo = new Runnable() {
            @Override
            public void run() {
                while (true){
                    try{
                        txtVwDatos.setText("Hola");
                        Thread.sleep(500);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        };

        MiHilo mhPerpetuo = new MiHilo();
        //mhPerpetuo.run(); //trabar app
        mhPerpetuo.start();  //segundo plano

    }
}
