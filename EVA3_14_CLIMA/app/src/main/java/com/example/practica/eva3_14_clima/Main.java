package com.example.practica.eva3_14_clima;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main extends AppCompatActivity {

    TextView txtVwDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtVwDatos = findViewById(R.id.txtVwDatos);
    }

    public void onClick(View v){
        //iniciar la clase asincrona
        new Conexion().execute();
    }

    class Conexion extends AsyncTask<Void, Void, String>{
        final String sLink = "https://samples.openweathermap.org/data/2.5/group?id=524901,703448,2643743&units=metric&appid=b6907d289e10d714a6e88b30761fae22";
        @Override
        protected String doInBackground(Void... voids) {
            //AQUI VAMOS A HACER LA CONEXION
            String sResu = ""; //JSON ENVIADO A LA PAGINA
            try {
                URL url = new URL(sLink);
                HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
                if (httpCon.getResponseCode() == HttpURLConnection.HTTP_OK){
                    //ES COMO LEER UN ARCHIVO DE TEXTO
                    BufferedReader brDatos = new BufferedReader(new InputStreamReader(
                            httpCon.getInputStream()
                    ));

                    sResu = brDatos.readLine();
                }
            }catch (Exception e){
                e.printStackTrace();
            }

            return sResu;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            //LECTURA DE LOS DATOS
            JSONArray jCiudades = null;
            if (!s.equals("")){
                try {
                    //CREAMOS EL OBJETO DEL TEXTO RECIBIDO
                    JSONObject jsDatos= new JSONObject(s);
                    jCiudades = jsDatos.getJSONArray("list");
                    for (int i = 0; i < jCiudades.length(); i++){
                        JSONObject jCiudad = jCiudades.getJSONObject(i);
                        txtVwDatos.append("Ciudad: "+ jCiudad.getString("name"));
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}