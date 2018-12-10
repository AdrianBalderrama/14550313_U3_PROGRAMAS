package com.example.practica.eva3_3_handlers;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main extends AppCompatActivity {

    Handler hManejador = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            //AQUI SE PUEDE INTERACTUAL CON LA INTERFAZ
            //GRAFICA
            if(msg.what==10){
                int i = (int)msg.obj;
                txtVwDatos.append(i+"-");

            }

        }
    };




    Thread tHilo;
    TextView txtVwDatos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtVwDatos = findViewById(R.id.txtVwDatos);
        MiHilo mhHilo= new MiHilo();
        Thread tHilo = new Thread(mhHilo);
        tHilo.start();
    }






    @Override
    protected void onDestroy() {
        super.onDestroy();
        tHilo.interrupt();
    }



    class MiHilo implements Runnable{

        @Override
        public void run() {
            int i = 0;
            while(true){
                i++;
                try {
                    Message msg = hManejador.obtainMessage(10,i);
                    hManejador.sendMessage(msg);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return;
                }

            }
        }
    }
}
