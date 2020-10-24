package com.juannarvaez.controlesdeseleccion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button botonSpinner;
    private Button botonListView;
    private Button botonGridView;

    public void eventoClicBotones(Button nombreBoton, final Class nombreClase) {
        nombreBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vista) {
                Intent intent = new Intent(MainActivity.this, nombreClase);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botonSpinner = (Button) findViewById(R.id.botonSpinner);
        botonListView = (Button) findViewById(R.id.botonListView);
        botonGridView = (Button) findViewById(R.id.botonGridView);
        eventoClicBotones(botonSpinner, SpinnerActivity.class);
        eventoClicBotones(botonListView, ListViewActivity.class);
        eventoClicBotones(botonGridView, GridViewActivity.class);

    }
}