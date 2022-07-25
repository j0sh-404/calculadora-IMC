package com.nrj_clinica.examen;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class BasedeDatos extends SQLiteOpenHelper {
    private static final String nombreBD="Personas_bd";
    private static final int versionBD=1;
    private static final String tablaBD="CREATE TABLE personas(nombre_persona text, edad_persona text, peso_persona text, altura_persona text, tipo_sexo text, NSS text, tipo_peso text )";

    public BasedeDatos(@Nullable Context context) {
        super(context, nombreBD, null, versionBD);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(tablaBD);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS  "+tablaBD);
        sqLiteDatabase.execSQL(tablaBD);
    }

    public  void agregarPersona(String nombre, String edad, String peso, String altura, String tipo_sexo, String NSS, String tipo_peso){
        SQLiteDatabase bd= getWritableDatabase();
        if (bd!=null){
            bd.execSQL("INSERT INTO personas VALUES('"+nombre+"','"+edad+"','"+peso+"','"+altura+"','"+tipo_sexo+"','"+NSS+"','"+tipo_peso+"')");
            bd.close();
        }

    }

    //consulta a base de datos
    public List<listadoPersonas> mostrarPersonas(){
        SQLiteDatabase bd=getReadableDatabase();
        Cursor cursor=bd.rawQuery("SELECT * FROM personas",null);
        List<listadoPersonas> personas= new ArrayList<>();
        if (cursor.moveToFirst()){
            do{
                personas.add(new listadoPersonas(cursor.getString(0), cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6)));
            }while (cursor.moveToNext());
        }
        return personas;
    }
}
