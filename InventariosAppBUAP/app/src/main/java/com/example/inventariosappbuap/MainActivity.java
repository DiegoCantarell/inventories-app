package com.example.inventariosappbuap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn1;
    EditText txtUser;
    EditText txtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = (Button) findViewById(R.id.button);
        txtUser = (EditText) findViewById(R.id.txtUser);
        txtPassword = (EditText) findViewById(R.id.txtPassword);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                btn1Click(v);
            }
        });

    }
    public void btn1Click(View v){
        String user = txtUser.getText().toString();
        String pass = txtPassword.getText().toString();
        if(user.equals("admin")   && pass.equals("123")){
            //Bundle parametros = new Bundle();
            //parametros.putString("dato",user);
            Intent i = new Intent(this, MainActivity2.class);
            i.putExtra("dato",user);
            startActivity(i);

        }
        else{
            Toast.makeText(this, "Error de usuario", Toast.LENGTH_SHORT).show();
        }

    }
}