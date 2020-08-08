package com.example.juan.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Inicio extends AppCompatActivity implements View.OnClickListener {
TextView nombre, monedas;
Button btnEditar, btnRecargar, btnSalir;
int id =0;
Usuario u;
daoUsuario  dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        nombre=(TextView)findViewById(R.id.nombreusuario);
        btnEditar=(Button)findViewById(R.id.btnEditar);
        btnRecargar=(Button)findViewById(R.id.btnRecargar);
        btnSalir=(Button)findViewById(R.id.btnSalir);
        btnEditar.setOnClickListener(this);
        btnRecargar.setOnClickListener(this);
        btnSalir.setOnClickListener(this);
        dao=new daoUsuario(this);


        Bundle  b=getIntent().getExtras();
        id=b.getInt("id");
        u=dao.getUsuarioById(id);
        nombre.setText(u.getNombres()+" "+u.getApellidos());

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnEditar:
                Intent a = new Intent(Inicio.this,Editar.class);
                startActivity(a);
                break;
            case R.id.btnRecargar:
                Intent c = new Intent(Inicio.this,Recargar.class);
                startActivity(c);
                break;
            case R.id.btnSalir:
                Intent i2 = new Intent(Inicio.this,MainActivity.class);
                startActivity(i2);
                finish();
                break;
        }
    }
}