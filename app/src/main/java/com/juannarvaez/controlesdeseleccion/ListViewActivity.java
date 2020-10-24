package com.juannarvaez.controlesdeseleccion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class ListViewActivity extends AppCompatActivity {
    ListView listaOpciones;
    TextView opcionSeleccionada;
    TextView mostrarInformacion;
    private Button botonRegresar;
    String vectorOpciones[] = new String[]{"¿Qué es Android?","¿Qué es Android Studio?","Interfaz de Usuario Android"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        listaOpciones = (ListView) findViewById(R.id.listaOpciones);
        opcionSeleccionada = (TextView) findViewById(R.id.opcionSeleccionada);
        mostrarInformacion = (TextView) findViewById(R.id.mostrarInformacion);
        botonRegresar = (Button) findViewById(R.id.botonRegresar);
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, R.layout.list_view_opciones, vectorOpciones);
        listaOpciones.setAdapter(adaptador);
        listaOpciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> item, View vista, int i, long id) {
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
        });
        botonRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vista) {
                Intent intent = new Intent(ListViewActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
