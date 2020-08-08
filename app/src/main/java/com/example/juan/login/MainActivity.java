package com.example.juan.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
EditText user,pass;
Button btnIniciar, btnRegistrar;
daoUsuario dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user=(EditText)findViewById(R.id.Usuario);
        pass=(EditText)findViewById(R.id.Contraseña);
        btnIniciar=(Button)findViewById(R.id.btnIniciar);
        btnRegistrar=(Button)findViewById(R.id.btnRegistrar);
        dao=new daoUsuario(this);

        btnIniciar.setOnClickListener(this);
        btnRegistrar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnIniciar:
                String u=user.getText().toString();
                String p=pass.getText().toString();
                if(u.equals("")){
                    Toast.makeText(this,"INGRESE UN USUARIO",Toast.LENGTH_SHORT).show();
                }
                else if(p.equals("")){
                    Toast.makeText(this,"INGRESE UNA CONTRASEÑA",Toast.LENGTH_SHORT).show();
                }
                else if(dao.login(u,p)==1){
                    Usuario ux=dao.getUsuario(u,p);
                    Toast.makeText(this,"Bienvenido",Toast.LENGTH_SHORT).show();
                    Intent i2 = new Intent(MainActivity.this,Inicio.class);
                    i2.putExtra("Id",ux.getId());
                    startActivity(i2);
                }else{
                    Toast.makeText(this,"Usuario no registrado",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btnRegistrar:
                Intent i = new Intent(MainActivity.this,Registrar.class);
                startActivity(i);
                break;
        }

    }
}