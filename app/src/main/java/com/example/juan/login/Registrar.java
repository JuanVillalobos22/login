package com.example.juan.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Registrar extends AppCompatActivity implements View.OnClickListener {
EditText us, ap, nom,pas;
Button reg, can;
daoUsuario dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        nom=(EditText)findViewById(R.id.Rnombre);
        ap=(EditText)findViewById(R.id.Rapellidos);
        us=(EditText)findViewById(R.id.Rcorreo);
        pas=(EditText)findViewById(R.id.Rcontraseña);
        reg=(Button)findViewById(R.id.btnRegistrar2);
        can=(Button)findViewById(R.id.btnCancelarR);
        dao=new daoUsuario(this);

        reg.setOnClickListener(this);
        can.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnRegistrar2:
                Usuario u = new Usuario();
                u.setNombres(nom.getText().toString());
                u.setApellidos(ap.getText().toString());
                u.setUsuario(us.getText().toString());
                u.setPassword(pas.getText().toString());
                if(!u.isNull()){
                    Toast.makeText(this,"ERROR  campos vacios",Toast.LENGTH_LONG).show();
                }else if(dao.insertUsuario(u)){
                    Toast.makeText(this,"¡Registro Exitoso!",Toast.LENGTH_LONG).show();
                    Intent i2 = new Intent(Registrar.this,Inicio.class);
                    startActivity(i2);
                    finish();
                }else{
                    Toast.makeText(this,"Usuario ya registrado",Toast.LENGTH_LONG).show();
                }
                break;

            case R.id.btnCancelarR:
                Intent i = new Intent(Registrar.this,MainActivity.class);
                startActivity(i);
                finish();
        }
    }
}