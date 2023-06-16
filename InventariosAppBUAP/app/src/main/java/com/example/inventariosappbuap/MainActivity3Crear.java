package com.example.inventariosappbuap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.Random;

public class MainActivity3Crear extends AppCompatActivity {
    Button button7;//CREAR
    Button button8;//SALIR
    //int numId ;
    EditText editTextTextPersonName; //Nombre articulo
    EditText editTextNumber; //Precio
    EditText editTextTextPersonName2; //Tipo
    EditText editTextTextPersonName3; // Descripción

    ConectionSQLite conn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity3_crear);

        //ConectionSQLite conn = new ConectionSQLite(getApplicationContext(),"dbUsuario",null,1);

        editTextTextPersonName = findViewById(R.id. editTextTextPersonName);
        editTextNumber = findViewById(R.id. editTextNumber);
        editTextTextPersonName2 = findViewById(R.id.editTextTextPersonName2);
        editTextTextPersonName3 = findViewById(R.id.editTextTextPersonName3);

        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);


        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickInsert(view);
            }
        });
        // setting onClickListner
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // create an intent to switch to second activity upon clicking
                Intent intent = new Intent(MainActivity3Crear.this,MainActivity2.class);
                startActivity(intent);
            }
        });

    }
    public void clickInsert(View v){
        //int numId = 2;
        //ConectionSQLite conn = new ConectionSQLite(getApplicationContext(),"dbUsuario",null,1);
        Random rand = new Random();
        ConectionSQLite conn = new ConectionSQLite(getApplicationContext(),"dbUsuario",null,1);
        String valid = "";
        String error = "";
        //String sql = "insert into usuario (id, nombre, precio, tipo, descripcion) values ('"+1+"','"+editTextTextPersonName.getText().toString()+"', '" +editTextNumber.getText().toString()+"','"+editTextTextPersonName2.getText().toString()+"','"+editTextTextPersonName3.getText().toString()+"')";
        if(editTextTextPersonName.getText().toString().equals(valid) ){
            error+="Falta ID, ";
        }
        if(editTextNumber.getText().toString().equals(valid)){
            error+="Falta Nombre, ";
        }
        if(editTextTextPersonName2.getText().toString().equals(valid)){
            error+="Falta Precio, ";
        }
        if(editTextTextPersonName3.getText().toString().equals(valid)){
            error+="Falta Descripción ";
        }
        if(error.equals(valid)) {
            String nombre  = editTextTextPersonName.getText().toString().replaceAll("^\"|\"$", "");
            nombre = nombre.replace("'", "");
            String tipo = editTextTextPersonName2.getText().toString().replaceAll("^\"|\"$", "");
            tipo = tipo.replace("'", "");
            String descripcion = editTextTextPersonName3.getText().toString().replaceAll("^\"|\"$", "");
            descripcion = descripcion.replace("'", "");
            //String sql = "insert into usuario (id, nombre, precio, tipo, descripcion) values ('" + rand.nextInt(50000) + "','" + editTextTextPersonName.getText().toString() + "', '" + editTextNumber.getText().toString() + "','" + editTextTextPersonName2.getText().toString() + "','" + editTextTextPersonName3.getText().toString() + "')";
            String sql = "insert into usuario (id, nombre, precio, tipo, descripcion) values ('" + rand.nextInt(50000) + "','" + nombre + "', '" + editTextNumber.getText().toString() + "','" + tipo + "','" + descripcion + "')";
            SQLiteDatabase db = conn.getWritableDatabase();

            db.execSQL(sql);
            db.close();
            Toast.makeText(this, "Articulo creado exitosamente", Toast.LENGTH_SHORT).show();
            clearItem();
        }
        else{
            Toast.makeText(this, "Articulo no creado, verifica los campos ingresados", Toast.LENGTH_SHORT).show();
        }
    }

    public void clearItem(){
        editTextTextPersonName.setText("");
        editTextNumber.setText("");
        editTextTextPersonName2.setText("");
        editTextTextPersonName3.setText("");

    }
}