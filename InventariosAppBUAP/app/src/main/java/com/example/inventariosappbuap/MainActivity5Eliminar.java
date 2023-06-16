package com.example.inventariosappbuap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity5Eliminar extends AppCompatActivity {

    Spinner spinner;
    //EditText editTextTextPersonName7;
    EditText editTextNumber5; //ID
    EditText editTextTextPersonName8; //nombre
    EditText editTextNumber2; // precio
    EditText editTextTextPersonName10; //tipo
    EditText editTextTextPersonName11; //Descripcion
    Button button11;
    Button button12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity5_eliminar);
        spinner = findViewById(R.id.spinner);
        //editTextTextPersonName7 = findViewById(R.id.editTextTextPersonName7);
        editTextTextPersonName8 = findViewById(R.id.editTextTextPersonName8);
        editTextTextPersonName10 = findViewById(R.id.editTextTextPersonName10);
        editTextTextPersonName11 = findViewById(R.id.editTextTextPersonName11);
        editTextNumber2 = findViewById(R.id.editTextNumber2);
        editTextNumber5 = findViewById(R.id.editTextNumber5);
        button11 = findViewById(R.id.button11);
        button12 = findViewById(R.id.button12);

        ConectionSQLite conn = new ConectionSQLite(getApplicationContext(),"dbUsuario",null,1);
        SQLiteDatabase db = conn.getWritableDatabase();
        String sql = "select * from usuario";
        //Cursor c = db.rawQuery(sql, null);
        ArrayList<String> elementos = new ArrayList<>();

        Cursor cursor = db.rawQuery(sql,null);
        //Cursor c = db.rawQuery(sql,null);
        while(cursor.moveToNext()){
            String line = "";
            //line+= "ID: " + cursor.getInt(0) + "\n";
            line+= cursor.getInt(0);

            elementos.add(line);
        }
        //elementos.add("1") ;
        //elementos.add("2") ;
        //elementos.add("3") ;
        ArrayAdapter adp = new ArrayAdapter(MainActivity5Eliminar.this, android.R.layout.simple_spinner_dropdown_item,elementos);
        spinner.setAdapter(adp);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //String elemento = (String) spinner.getAdapter().getItem(i);
                //Toast.makeText(MainActivity5Eliminar.this, "Seleccinaste: "+elemento, Toast.LENGTH_SHORT).show();

                String elemento = (String) spinner.getAdapter().getItem(i);
                int number = Integer.parseInt(elemento);
                //int idArticulo = Integer.parseInt(elemento);
                //int idr = (int) spinner2.getAdapter().getItem(i);

                ConectionSQLite conn = new ConectionSQLite(getApplicationContext(),"dbUsuario",null,1);
                SQLiteDatabase db = conn.getWritableDatabase();
                String sql = "select * from usuario";



                Cursor cursorNew = db.rawQuery(sql,null);
                //Cursor c = db.rawQuery(sql,null);
                while(cursorNew.moveToNext()){
                    if(number == cursorNew.getInt(0)){
                        String cadena1 = String.valueOf(cursorNew.getInt(0));
                        editTextNumber5.setText(cadena1);
                        editTextTextPersonName8.setText(cursorNew.getString(1));
                        String cadena2 = String.valueOf(cursorNew.getInt(2));
                        editTextNumber2.setText(cadena2);
                        editTextTextPersonName10.setText(cursorNew.getString(3));
                        editTextTextPersonName11.setText(cursorNew.getString(4));
                    }

                }

                Toast.makeText(MainActivity5Eliminar.this, "Seleccionaste: "+elemento, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //ELIMINAR
        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                clickDelete(view);

            }
        });
        // setting onClickListner
        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // create an intent to switch to second activity upon clicking
                Intent intent = new Intent(MainActivity5Eliminar.this,MainActivity2.class);
                startActivity(intent);
            }
        });

    }
    public void clickDelete(View v){
        ConectionSQLite conn = new ConectionSQLite(getApplicationContext(),"dbUsuario",null,1);

        String sql = "DELETE FROM usuario WHERE id = '"+editTextNumber5.getText().toString()+"'";
        SQLiteDatabase db = conn.getWritableDatabase();
        db.execSQL(sql);
        db.close();
        clearItem();
        Toast.makeText(this, "Articulo eliminado exitosamente, salir para actualizar", Toast.LENGTH_SHORT).show();
    }
    public void clearItem(){

        editTextTextPersonName8.setText("");
        editTextNumber2.setText("");
        editTextTextPersonName10.setText("");
        editTextTextPersonName11.setText("");
    }
}