package com.juannarvaez.controlesdeseleccion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class SpinnerActivity extends AppCompatActivity {
    private Spinner opciones;
    private TextView opcionSeleccionada;
    private TextView mostrarInformacion;
    private Button botonRegresar;
    String vectorOpciones[] = new String[]{"¿Qué es Android?", "¿Qué es Android Studio?", "Interfaz de Usuario Android"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        opciones = (Spinner) findViewById(R.id.listaOpciones);
        opcionSeleccionada = (TextView) findViewById(R.id.opcionSeleccionada);
        mostrarInformacion = (TextView) findViewById(R.id.mostrarInformacion);
        botonRegresar = (Button) findViewById(R.id.botonRegresar);

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item, vectorOpciones);
        opciones.setAdapter(adaptador);
        opciones.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            public void onItemSelected(AdapterView<?> item, android.view.View vista, int i,
                                       long id) {
                opcionSeleccionada.setText("" + item.getItemAtPosition(i));
                if(item.getItemAtPosition(i).equals("¿Qué es Android?")){
                    mostrarInformacion.setText("Es un sistema operativo basado en Linux, el cual puede ser instalado en Smartphones, " +
                            "tabletas, televisores, electrodomésticos, entre otros dispositivos.");
                }else{
                    if(item.getItemAtPosition(i).equals("¿Qué es Android Studio?")){
                        mostrarInformacion.setText("Es un entorno integrado de desarrollo (IDE por sus siglas en ingles), que permite " +
                        "crear aplicaciones para el sistema operativo Android");
                    }else{
                        mostrarInformacion.setText("Los elementos que componen el diseño de la interfaz gráfica en una actividad, " +
                                "se crean usando objetos de las clases View y ViewGroup. ");
                    }
                }
            }
            public void onNothingSelected(AdapterView<?> item) {
                opcionSeleccionada.setText("");
            }
        });
        botonRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vista) {
                Intent intent = new Intent(SpinnerActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        }
    }
