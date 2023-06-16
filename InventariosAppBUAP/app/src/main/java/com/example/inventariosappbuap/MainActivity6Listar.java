package com.example.inventariosappbuap;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity6Listar extends AppCompatActivity {

    Button button13;
    EditText editTextTextMultiLine;
    ConectionSQLite conn;
    ArrayList<String> mylist;
    RecyclerView idRv;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity6_listar);

        idRv = (RecyclerView) findViewById(R.id.idRv);
        idRv.setLayoutManager(new GridLayoutManager(this, 1));

        button13 = findViewById(R.id.button13);

        //editTextTextMultiLine = findViewById(R.id.editTextTextMultiLine);
        ConectionSQLite conn = new ConectionSQLite(getApplicationContext(),"dbUsuario",null,1);
        SQLiteDatabase db = conn.getWritableDatabase();
        String sql = "select * from usuario";
        /*String line = "Datos: \n";

        try{
            Cursor c = db.rawQuery(sql, null);
            while(c.moveToNext()){
                line+= c.getInt(0)+" ";
                line+= c.getString(1)+" ";
                line+= c.getInt(2)+" ";
                line+= c.getString(3)+" ";
                line+= c.getString(4)+"\n ";
            }
            editTextTextMultiLine.setText(line);
            db.close();
        }
        catch(Exception e){
            editTextTextMultiLine.setText(e.getMessage());
            db.close();
        }*/
        //try{
        mylist = new ArrayList<String>();
        Cursor cursor = db.rawQuery(sql,null);
        //Cursor c = db.rawQuery(sql,null);
        while(cursor.moveToNext()){
            String line = "---------------\n";
            line+= "ID articulo: " + cursor.getInt(0) + "\n";
            line+= "Nombre articulo: " + cursor.getString(1) + "\n";
            line+= "Precio articulo: $" + cursor.getInt(2) + "\n";
            line+= "Tipo articulo: " + cursor.getString(3) + "\n";
            line+= "Descripcion articulo : " + cursor.getString(4) + "\n\n";
            mylist.add(line);
        }

        //editTextTextMultiLine.setText(line);
        adapter adapter = new adapter(mylist);
        idRv.setAdapter(adapter);

        // setting onClickListner
        button13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // create an intent to switch to second activity upon clicking
                Intent intent = new Intent(MainActivity6Listar.this,MainActivity2.class);
                startActivity(intent);

            }
        });
    }
    public void clickSelect(View v){
        ConectionSQLite conn = new ConectionSQLite(getApplicationContext(),"dbUsuario",null,1);
        SQLiteDatabase db = conn.getWritableDatabase();
        String sql = "select * from usuario";
        String line = "";

        try{
            Cursor c = db.rawQuery(sql, null);
            while(c.moveToNext()){
                line+= c.getInt(0)+" ";
                line+= c.getInt(1)+" ";
                line+= c.getInt(2)+"\n ";
            }
        }
        catch(Exception e){

        }

    }

}