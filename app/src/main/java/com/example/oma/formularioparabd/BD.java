package com.example.oma.formularioparabd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS '"+TABLA_REGISTRO );
        sqLiteDatabase.execSQL(TABLA_REGISTRO);
    }

    public void agregarVentas(String orden ,String cliente,String fecha,String producto,String cantidad,String precio,String total  ) {
        SQLiteDatabase bd=getWritableDatabase();
        if(bd!=null){
            bd.execSQL("INSERT INTO VENTAS VALUES('"+orden+"','"+cliente+"','"+fecha+"','"+producto+"','"+cantidad+"','"+precio+"','"+total+"')");
            bd.close();
        }
    }

}

