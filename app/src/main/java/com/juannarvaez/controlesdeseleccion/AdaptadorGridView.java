package com.juannarvaez.controlesdeseleccion;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AdaptadorGridView extends BaseAdapter {
    private Context contexto;
    private ArrayList<String> vectorDatos;
    private TextView informacion;
    public AdaptadorGridView(Context contexto, ArrayList<String> datos){

        this.contexto = contexto;
        this.vectorDatos = datos;
    }

    @Override
    public int getCount() {
        return  vectorDatos.size();

    }

    @Override
    public Object getItem(int position) {
        return vectorDatos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){

            LayoutInflater layout_inflater = (LayoutInflater)
                    contexto.getSystemService(contexto.LAYOUT_INFLATER_SERVICE);
            convertView = layout_inflater.inflate(R.layout.item_grid_view, null);
        }

        informacion = (TextView) convertView.findViewById(R.id.informacion);
        informacion.setText(vectorDatos.get(position));
        return convertView;

    }
}
