package com.example.adhimarino.myapplication;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class shelter extends AppCompatActivity {
    Button mtigaa, mtigab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shelter);
        mtigaa = (Button) findViewById(R.id.tigaaa);
        mtigab = (Button) findViewById(R.id.tigabb);

        mtigaa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MapsActivity3.class);
                startActivity(intent);
                Log.d("btn", "error");

            }
        });

        mtigab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MapsActivity4.class);
                startActivity(intent);
                Log.d("btn", "error");

            }
        });
    }
}
