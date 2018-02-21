package com.example.admin.casinoleonera;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.casinoleonera.objetos.Encuesta;
import com.example.admin.casinoleonera.objetos.FirebaseReferences;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

public class EncuestaActivity extends Activity {

    private Button enviar, volver;
    private RatingBar mRatingBar, nRatingBar;
    private TextView servicio,atencion,sugerencia;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encuesta);

        mRatingBar = findViewById(R.id.ratingBar);
        nRatingBar = findViewById(R.id.ratingBar2);
        enviar = findViewById(R.id.en_enviar);
        volver = findViewById(R.id.en_volver);
        servicio = findViewById(R.id.mRatingText);
        atencion = findViewById(R.id.nRatingText);
        sugerencia = findViewById(R.id.editText2);


    }
}
