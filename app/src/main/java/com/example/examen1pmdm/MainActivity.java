package com.example.examen1pmdm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void crono(View v) {

        Intent i = new Intent(this, CronoActivity.class);
        startActivity(i);

    }

    public void salir(View v) {

    }
    
}