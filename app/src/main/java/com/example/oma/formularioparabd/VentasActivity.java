package com.example.oma.formularioparabd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class VentasActivity extends AppCompatActivity {

    private RecyclerView recyclerViewVentas;
    private VentaAdaptador adaptadorVentas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventas);

        recyclerViewVentas=findViewById(R.id.recycler);
        recyclerViewVentas.setLayoutManager(new LinearLayoutManager(this));

        BD dblite=new BD(getApplicationContext());
        adaptadorVentas=new VentaAdaptador(dblite.mostrarVentas());
        recyclerViewVentas.setAdapter(adaptadorVentas);
    }
}