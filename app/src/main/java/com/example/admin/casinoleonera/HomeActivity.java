package com.example.admin.casinoleonera;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class HomeActivity extends Activity {

    Button batuco, coelemu, cerrar, encuesta;
    TextView bienvenida;

    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        batuco = findViewById(R.id.batuco);
        coelemu = findViewById(R.id.coelemu);
        cerrar = findViewById(R.id.c_sesion);
        encuesta = findViewById(R.id.encuesta);
        bienvenida = findViewById(R.id.th_bienv);

        firebaseAuth = FirebaseAuth.getInstance();

        if (firebaseAuth.getCurrentUser() == null) {
            finish();
            Intent intent = new Intent(HomeActivity.this, MainActivity.class);

            Toast.makeText(HomeActivity.this,
                    "Por favor, ingrese para continuar", Toast.LENGTH_LONG).show();
        }

        firebaseUser = firebaseAuth.getCurrentUser();
        bienvenida.setText("Te damos la bienvenida " + firebaseUser.getEmail());



        batuco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, MenuBatucoActivity.class);
                startActivity(intent);
            }
        });

        coelemu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, MenuCoelemuActivity.class);
                startActivity(intent);
            }
        });

        cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebaseAuth.signOut();
                finish();
                Intent intent = new Intent(HomeActivity.this, MainActivity.class);
                startActivity(intent);
                Toast.makeText(HomeActivity.this,
                        "Has cerrado sesión satisfactoriamente", Toast.LENGTH_LONG).show();
            }
        });

        encuesta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, EncuestaActivity.class);
                startActivity(intent);
            }
        });
    }
}
