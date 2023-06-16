package com.example.inventariosappbuap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView textView3;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView3 = (TextView) findViewById(R.id.textView3);
        //Bundle parametros = this.getIntent().getExtras();
        String nom = getIntent().getStringExtra("dato");
        textView3.setText("SISTEMA DE INVENTARIOS FCC ");


        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);

        // setting onClickListnerr
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // create an intent to switch to second activity upon clicking
                Intent intent = new Intent(MainActivity2.this,MainActivity.class);
                startActivity(intent);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // create an intent to switch to second activity upon clicking
                Intent intent = new Intent(MainActivity2.this,MainActivity3Crear.class);
                startActivity(intent);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // create an intent to switch to second activity upon clicking
                Intent intent = new Intent(MainActivity2.this,MainActivity4Modificar.class);
                startActivity(intent);
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // create an intent to switch to second activity upon clicking
                Intent intent = new Intent(MainActivity2.this,MainActivity5Eliminar.class);
                startActivity(intent);
            }

        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // create an intent to switch to second activity upon clicking
                Intent intent = new Intent(MainActivity2.this,MainActivity6Listar.class);
                startActivity(intent);
            }

        });

        }

}