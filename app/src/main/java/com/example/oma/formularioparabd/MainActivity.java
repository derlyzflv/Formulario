package com.example.oma.formularioparabd;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Spinner comboproductos;
    EditText orden,cliente,fecha,cantidad,precio,total;
    Button agregar,mostrar;

    private int dia, mes, ano;
    private static DatePickerDialog.OnDateSetListener oyenteSelectorFecha;
    private static final int TIPO_DIALOGO=0;

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
        mostrar=findViewById(R.id.mostar_datos);

        Calendar calendario=Calendar.getInstance();
        ano=calendario.get(Calendar.YEAR);
        mes=calendario.get(Calendar.MONTH);
        dia=calendario.get(Calendar.DAY_OF_MONTH);
        mostrarFecha();
        oyenteSelectorFecha=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                ano=i;
                mes=i1;
                dia=i2;
                mostrarFecha();
            }
        };

        final BD dblite=new BD(getApplicationContext());

        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dblite.agregarVentas(orden.getText().toString(),cliente.getText().toString(),fecha.getText().toString(),comboproductos.getSelectedItem().toString(),
                        cantidad.getText().toString(),precio.getText().toString(),total.getText().toString());
                Toast.makeText(getApplicationContext(),"Se agrego correctamente",Toast.LENGTH_SHORT).show();
            }
        });
        mostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mostrarVentas=new Intent(getApplicationContext(),VentasActivity.class);
                startActivity(mostrarVentas);
            }
        });
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id){
            case 0:
                return new DatePickerDialog(this,oyenteSelectorFecha,ano,mes,dia);
        }
        return null;
    }
    public void mostrarCalendario(View control){
        showDialog(TIPO_DIALOGO);
    }
    public void mostrarFecha() {
        fecha.setText(ano + "/" + (mes + 1) + "/" + dia);
    }
}