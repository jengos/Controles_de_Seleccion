package com.juannarvaez.controlesdeseleccion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;

public class GridViewActivity extends AppCompatActivity {
    private GridView tablaOpciones;
    private TextView opcionSeleccionada;
    private AdaptadorGridView adaptador;
    private Button botonRegresar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);
        tablaOpciones = (GridView) findViewById(R.id.tablaOpciones);
        opcionSeleccionada = (TextView) findViewById(R.id.opcionSeleccionada);
        botonRegresar = (Button) findViewById(R.id.botonRegresar);
        ArrayList<String> vectorOpciones = new ArrayList<>();
        vectorOpciones.add("¿Qué es Android?");
        vectorOpciones.add("¿Android Studio?");
        vectorOpciones.add("Interfaz Gráfica");
        vectorOpciones.add("LinearLayout");
        vectorOpciones.add("ConstraintLayout");
        vectorOpciones.add("RelativeLayout");
        adaptador = new AdaptadorGridView(this, vectorOpciones);
        tablaOpciones.setAdapter(adaptador);
        tablaOpciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> item, View vista, int i, long id) {
                opcionSeleccionada.setText("La opción seleccionada es: " +
                        item.getItemAtPosition(i));
            }
        });
        botonRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vista) {
                Intent intent = new Intent(GridViewActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}