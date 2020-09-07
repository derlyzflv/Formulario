package com.example.oma.formularioparabd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner comboproductos;
    EditText orden,cliente,fecha,cantidad,precio,total;
    Button agregar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        comboproductos=findViewById(R.id.productos_spinner);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.productos,android.R.layout.simple_spinner_item);
        comboproductos.setAdapter(adapter);

        orden=findViewById(R.id.orden_edit);
        cliente=findViewById(R.id.cliente_edit);
        fecha=findViewById(R.id.fecha_edit);
        cantidad=findViewById(R.id.cantidad_edit);
        precio=findViewById(R.id.precio_edit);
        total=findViewById(R.id.total_edit);
        agregar=(Button) findViewById(R.id.agregar_boton);

        final BD dblite=new BD(getApplicationContext());

        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dblite.agregarVentas(orden.getText().toString(),cliente.getText().toString(),fecha.getText().toString(),comboproductos.getSelectedItem().toString(),
                        cantidad.getText().toString(),precio.getText().toString(),total.getText().toString());
                Toast.makeText(getApplicationContext(),"Se agrego correctamente",Toast.LENGTH_SHORT).show();
            }
        });
    }
}