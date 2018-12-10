package com.example.practica.eva3_12_media;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Main extends AppCompatActivity {

    MediaPlayer mpReproductor=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mpReproductor = MediaPlayer.create(this,R.raw.mp3);
    }


    @Override
    protected void onPostResume() {
        super.onPostResume();
        if(mpReproductor!=null) {
        mpReproductor.start();;
        }
        }


    @Override
    protected void onStop() {
        super.onStop();
        mpReproductor.stop();
        mpReproductor.release();
    }
}
