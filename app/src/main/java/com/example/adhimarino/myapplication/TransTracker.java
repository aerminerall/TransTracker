package com.example.adhimarino.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TransTracker extends AppCompatActivity {

    Button btn_posisi, btn_tnt, btn_ext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_posisi = (Button) findViewById(R.id.btn_posisi);
        btn_tnt = (Button) findViewById(R.id.btn_tnt);
        btn_ext = (Button) findViewById(R.id.btn_ext);

        btn_posisi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), PosisiActivity.class);
                startActivity(i);
            }
        });

        btn_tnt.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           Intent i = new Intent(getApplicationContext(), shelter.class);
                                           startActivity(i);
                                       }

                                   }
        );

        btn_ext.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           Intent i = new Intent(getApplicationContext(), about.class);
                                           startActivity(i);
                                       }

                                   }
        );

            }
}

    /*
    btn_posisi.setOnClickListener (new View.OnClickListener);
    @Override
    public void onClick (View v );
    Intent i = new Intent(getApplicationContext(),TransTracker.class);
    startaAtivity(i);
*/

