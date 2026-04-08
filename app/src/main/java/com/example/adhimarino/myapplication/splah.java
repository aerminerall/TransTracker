package com.example.adhimarino.myapplication;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

public class splah extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splah);


        Thread waktu = new Thread(){
            public void run(){
                try {
                    sleep(800);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    Intent i = new Intent(splah.this, TransTracker.class);
                    startActivity(i);
                }
            }
        };
        waktu.start();
    }
    @Override
    protected void onPause(){
        super.onPause();
        finish();
    }

}
