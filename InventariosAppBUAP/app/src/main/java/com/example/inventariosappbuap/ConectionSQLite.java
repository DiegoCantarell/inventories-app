package com.example.inventariosappbuap;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ConectionSQLite extends SQLiteOpenHelper {
    String dropTabla = "DROP TABLE usuario;";
    String tabla = "Create table usuario (id integer PRIMARY KEY AUTOINCREMENT, nombre text, precio text, tipo text, descripcion text)";
    //String tabla = "Create table usuario (id INTEGER PRIMARY KEY AUTOINCREMENT, tipo text, descripcion text)";
    //String tabla2 = "Create table articulo (id INTEGER , nombre text, precio text, tipo text, descripcion text)";
    public ConectionSQLite(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //sqLiteDatabase.execSQL(dropTabla);
        sqLiteDatabase.execSQL(tabla);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists usuario");
        onCreate(sqLiteDatabase);
    }
}
