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

public class MainActivity4Modificar extends AppCompatActivity {
    Button  button9;
    Button button10;
    int idr,var;
    Spinner spinner2;
    EditText editTextNumber4; //ID
    EditText editTextTextPersonName4; //NOMBRE \
    EditText editTextNumber3; //PRECIO
    EditText editTextTextPersonName5;// TIPO
    EditText editTextTextPersonName6;// DESCRIPCIÓN

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity4_modificar);
        spinner2 = findViewById(R.id.spinner2);
        button9 = findViewById(R.id.button9);
        button10 = findViewById(R.id.button10);

        editTextTextPersonName4 = findViewById(R.id.editTextTextPersonName4);
        editTextNumber3 = findViewById(R.id.editTextNumber3);
        editTextNumber4 = findViewById(R.id.editTextNumber4);
        editTextTextPersonName5 = findViewById(R.id.editTextTextPersonName5);
        editTextTextPersonName6 = findViewById(R.id.editTextTextPersonName6);




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
        ArrayAdapter adp = new ArrayAdapter(MainActivity4Modificar.this, android.R.layout.simple_spinner_dropdown_item,elementos);
        spinner2.setAdapter(adp);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                String elemento = (String) spinner2.getAdapter().getItem(i);
                int number = Integer.parseInt(elemento);
                //int idArticulo = Integer.parseInt(elemento);
                //int idr = (int) spinner2.getAdapter().getItem(i);
                var = idr;
                /*ConectionSQLite conn = new ConectionSQLite(getApplicationContext(),"dbUsuario",null,1);
                SQLiteDatabase db = conn.getWritableDatabase();
                String sql = "select * from usuario";

                Cursor cursor1 = db.rawQuery(sql,null);
                while(cursor1.moveToNext()){
                    if(var == cursor1.getInt(0)){
                        editTextTextPersonName4.setText(cursor1.getString(1));
                        //editTextTextPersonName4.setText("hola");
                        editTextNumber3.setText(cursor1.getInt(2));
                        editTextTextPersonName5.setText(cursor1.getString(3));
                        editTextTextPersonName6.setText(cursor1.getString(4));
                    }

                }*/
                ConectionSQLite conn = new ConectionSQLite(getApplicationContext(),"dbUsuario",null,1);
                SQLiteDatabase db = conn.getWritableDatabase();
                String sql = "select * from usuario";



                Cursor cursorNew = db.rawQuery(sql,null);
                //Cursor c = db.rawQuery(sql,null);
                while(cursorNew.moveToNext()){
                    if(number == cursorNew.getInt(0)){
                        String cadena1 = String.valueOf(cursorNew.getInt(0));
                        editTextNumber4.setText(cadena1);
                        editTextTextPersonName4.setText(cursorNew.getString(1));
                        String cadena2 = String.valueOf(cursorNew.getInt(2));
                        editTextNumber3.setText(cadena2);
                        editTextTextPersonName5.setText(cursorNew.getString(3));
                        editTextTextPersonName6.setText(cursorNew.getString(4));
                    }

                }
               /* var = idr;


               // try{
                    Cursor cursor1 = db.rawQuery(sql,null);
                    int idArticulo = new Integer(elemento).intValue();

                    while(cursor1.moveToNext()){
                        //String toast = String.valueOf(cursor1.getInt(0));
                        //Toast.makeText(MainActivity4Modificar.this, "Seleccinaste: "+toast, Toast.LENGTH_SHORT).show();
                        if(idr == cursor1.getInt(0)){
                            editTextTextPersonName4.setText(cursor1.getString(1));
                            //editTextTextPersonName4.setText("hola");
                            editTextNumber3.setText(cursor1.getInt(2));
                            editTextTextPersonName5.setText(cursor1.getString(3));
                            editTextTextPersonName6.setText(cursor1.getString(4));
                        }
                    }
                //    db.close();
               // }
               // catch(Exception e){
                //    db.close();
                //}
                */
                Toast.makeText(MainActivity4Modificar.this, "Seleccionaste: "+elemento, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                clickUpdate(view);

            }
        });

        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // create an intent to switch to second activity upon clicking
                Intent intent = new Intent(MainActivity4Modificar.this,MainActivity2.class);
                startActivity(intent);
            }
        });


    }
    public void clickUpdate(View v){

        ConectionSQLite conn = new ConectionSQLite(getApplicationContext(),"dbUsuario",null,1);
        String valid = "";
        String error = "";
        if(editTextTextPersonName4.getText().toString().equals(valid)){
            error+="Falta ID, ";
        }
        if(editTextNumber3.getText().toString().equals(valid)){
            error+="Falta Nombre, ";
        }
        if(editTextTextPersonName5.getText().toString().equals(valid) ){
            error+="Falta Precio, ";
        }
        if(editTextTextPersonName6.getText().toString().equals(valid)){
            error+="Falta Descripción ";
        }
        if(error.equals(valid)) {
            String nombre  = editTextTextPersonName4.getText().toString().replaceAll("^\"|\"$", "");
            nombre = nombre.replace("'", "");
            String tipo = editTextTextPersonName5.getText().toString().replaceAll("^\"|\"$", "");
            tipo = tipo.replace("'", "");
            String descripcion =editTextTextPersonName6.getText().toString().replaceAll("^\"|\"$", "");
            descripcion = descripcion.replace("'", "");
            //String sql = "update usuario set nombre = '" + editTextTextPersonName4.getText().toString() + "',precio = '" + editTextNumber3.getText().toString() + "',tipo = '" + editTextTextPersonName5.getText().toString() + "',descripcion = '" + editTextTextPersonName6.getText().toString() + "' where id = '" + editTextNumber4.getText().toString() + "'";
            String sql = "update usuario set nombre = '" + nombre + "',precio = '" + editTextNumber3.getText().toString() + "',tipo = '" + tipo + "',descripcion = '" + descripcion + "' where id = '" + editTextNumber4.getText().toString() + "'";
            //String sql = "DELETE FROM usuario WHERE id = '"+editTextNumber5.getText().toString()+"'";
            SQLiteDatabase db = conn.getWritableDatabase();
            db.execSQL(sql);
            db.close();
            clearItem();
            Toast.makeText(this, "Articulo actualizado exitosamente", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Articulo no actualizado, verifica los campos ingresados", Toast.LENGTH_SHORT).show();
        }
    }
    public void clearItem(){
        editTextTextPersonName4.setText("");
        editTextNumber3.setText("");
        editTextTextPersonName6.setText("");
        editTextTextPersonName5.setText("");
    }
}