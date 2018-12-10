package com.example.practica.eva3_8_asynk_task;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main extends AppCompatActivity {


    TextView txtVwDatos;
    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtVwDatos= findViewById(R.id.txtVwDatos);

        MiClaseAsincrona maTareaAsin = new MiClaseAsincrona();
        maTareaAsin.execute("Hola","Mundo");
    }





    class MiClaseAsincrona extends AsyncTask<String,Integer,Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            txtVwDatos.setText("Iniciando la tarea asincrona");
        }


        @Override
        protected Void doInBackground(String... strings) {

            while(true){
                try{
                    Thread.sleep(1000);
                    publishProgress(i++);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }



        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            txtVwDatos.append(i+"-");
        }



    }
}
