package com.example.oma.formularioparabd;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class BD extends SQLiteOpenHelper {
    private static final String NOMBRE_DB="dblite.bd";
    private static final int VERSION_DB=1;
    private static final String TABLA_REGISTRO="CREATE TABLE VENTAS(ORDEN TEXT PRIMARY KEY, CLIENTE TEXT, FECHA TEXT, PRODUCTO TEXT, CANTIDAD NUMBER, PRECIO NUMBER, TOTAL NUMBER)";

    public BD (Context context) {
        super(context, NOMBRE_DB, null, VERSION_DB);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(TABLA_REGISTRO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS CREATE"+TABLA_REGISTRO );
        sqLiteDatabase.execSQL(TABLA_REGISTRO);
    }

    public void agregarVentas(String orden ,String cliente,String fecha,String producto,String cantidad,String precio,String total  ) {
        SQLiteDatabase bd=getWritableDatabase();
        if(bd!=null){
            bd.execSQL("INSERT INTO VENTAS VALUES('"+orden+"','"+cliente+"','"+fecha+"','"+producto+"','"+cantidad+"','"+precio+"','"+total+"')");
            bd.close();
        }
    }
    public List<VentaModelo> mostrarVentas(){

        SQLiteDatabase bd=getReadableDatabase();
        Cursor cursor=bd.rawQuery("SELECT ORDEN,CLIENTE,FECHA,PRODUCTO,CANTIDAD,TOTAL FROM VENTAS",null);
        List<VentaModelo> ventas=new ArrayList<>();
        if (cursor.moveToFirst()){
            do{
                ventas.add(new VentaModelo(cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5)));
            }while (cursor.moveToNext());
        }
        return ventas;
    }

}

