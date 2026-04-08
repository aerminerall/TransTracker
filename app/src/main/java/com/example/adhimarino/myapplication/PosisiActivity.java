package com.example.adhimarino.myapplication;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class PosisiActivity extends AppCompatActivity {
Button mtigaa, mtigab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posisi);
        mtigaa = (Button) findViewById(R.id.tigaa);
        mtigab = (Button) findViewById(R.id.tigab);

        mtigaa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
                startActivity(intent);
                Log.d("btn", "error");

            }
        });

        mtigab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MapsActivity2.class);
                startActivity(intent);
                Log.d("btn", "error");

            }
        });
        }
    }

