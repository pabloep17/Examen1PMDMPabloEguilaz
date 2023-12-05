package com.example.examen1pmdm;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class CronoActivity extends AppCompatActivity {

    // Variable para almaenar los segundos del recicle
    ArrayList<Integer> segundosList = new ArrayList<>();

    // Mi clase para dar formato al los segundo
    TimeFormater tm = new TimeFormater();

    // La view donde se muestre el crono
    TextView cronoValueView;

    // Si el crono esta en play o pause
    boolean cronoOn = false;

    // El valor de crono
    int cronoValue = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crono);
        // Obtener el crono
        cronoValueView = findViewById(R.id.cronoValue);
        // Comenzar el hilo q aumenta el crono
        autoCrono();
    }

    void autoCrono() {
        new Thread(() -> {
            // Ejercutarlo siempre
            while (true) {
                // Ejecutar si el modo de juego esta en plau
                if(cronoOn) {
                    try {
                        // Sumar un sundo al crono
                        sumar();
                        // Update la UI
                        runOnUiThread(() -> updateUi());
                        // Dormir 1 segundo
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        // Tratar la exception
                        e.printStackTrace();
                    }
                }
            }// Comenzar el hilo
        }).start();
    }

    public void updateUi() {
        // Dar el valor a textView despues de darle formato a los segundos
        cronoValueView.setText(tm.secondsToTime(cronoValue));
    }

    public void sumar() {
        // Sumar 1 al valor de crono
        cronoValue++;
    }

    public void play(View v) {
        // Hacer q crono empieze a sumar
        cronoOn = true;
    }

    public void pausa(View v) {
        // Hacer q el crono pare de sumar
        cronoOn = false;
    }

    public void record(View v) {

        // Añadir el valor del crono a la ArraList de segunos
        segundosList.add(cronoValue);

        //Obtner el RecyclerView donde se va a mostrar
        RecyclerView reyclerViewUser = (RecyclerView) findViewById(R.id.recyclerView);

        // Cambiar los ajustes del recicle
        reyclerViewUser.setHasFixedSize(true);

        reyclerViewUser.setLayoutManager(new LinearLayoutManager(this));

        // Llamar a mi adaptador
        SegundosAdapter mAdapter = new SegundosAdapter(segundosList);

        //Pasar al RecyclerView mi adaptador
        reyclerViewUser.setAdapter(mAdapter);
    }

}