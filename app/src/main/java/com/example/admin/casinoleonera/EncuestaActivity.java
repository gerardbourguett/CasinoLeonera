package com.example.admin.casinoleonera;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import com.example.admin.casinoleonera.objetos.Encuesta;
import com.example.admin.casinoleonera.objetos.FirebaseReferences;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EncuestaActivity extends Activity {

    private RatingBar mRatingBar, nRatingBar;
    private EditText sugerencia;
    private Button enviar, cancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encuesta);

        mRatingBar = findViewById(R.id.mRatingBar);
        nRatingBar = findViewById(R.id.nRatingBar);
        sugerencia = findViewById(R.id.t_comen);
        enviar = findViewById(R.id.en_enviar);
        cancelar = findViewById(R.id.en_volver);


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference encuestaRef = database.getReference(FirebaseReferences.APP_REFERENCE);

        mRatingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                Toast.makeText(EncuestaActivity.this, "Servicio: " + mRatingBar.getRating(), Toast.LENGTH_SHORT).show();
            }
        });

        nRatingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                Toast.makeText(EncuestaActivity.this, "Atencion: " + nRatingBar.getRating(), Toast.LENGTH_SHORT).show();
            }
        });

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Encuesta encuesta = new Encuesta (mRatingBar.getRating(), nRatingBar.getRating() , sugerencia.getText().toString());
                encuestaRef.child(FirebaseReferences.ENCUESTA_REFERENCE).push().setValue(encuesta);
                Toast.makeText(EncuestaActivity.this, "Datos Enviados. Presiona Volver para salir de la Encuesta", Toast.LENGTH_SHORT).show();
            }
        });

        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EncuestaActivity.this , HomeActivity.class);
                startActivity(intent);
            }
        });



    }
}
