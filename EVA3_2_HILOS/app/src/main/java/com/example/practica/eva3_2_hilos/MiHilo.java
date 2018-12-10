package com.example.practica.eva3_2_hilos;

import android.util.Log;


public class MiHilo extends Thread{

    @Override
    public void run() {
        super.run();
        while(true){
            try{
                Log.wtf("Hilo", "hola");
                Thread.sleep(1000);
                
                
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
