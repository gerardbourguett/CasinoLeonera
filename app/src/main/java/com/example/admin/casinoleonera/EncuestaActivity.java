package com.example.admin.casinoleonera;

import android.app.Activity;
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

public class EncuestaActivity extends Activity {

    Button enviar, volver;
    RatingBar mRatingBar, nRatingBar;
    TextView servicio, atencion;
    EditText sugerencia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encuesta);

        mRatingBar = findViewById(R.id.ratingBar);
        nRatingBar = findViewById(R.id.ratingBar2);
        enviar = findViewById(R.id.en_enviar);
        volver = findViewById(R.id.en_volver);
        servicio = findViewById(R.id.mRatingText);
        atencion = findViewById(R.id.nRatingText);
        sugerencia = findViewById(R.id.editText2);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myref = database.getReference(FirebaseReferences.ENCUESTA_REFERENCE);

        mRatingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                servicio.setText(String.valueOf(v));
            }
        });

        nRatingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                atencion.setText(String.valueOf(v));
            }
        });

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Encuesta encuesta = new Encuesta(servicio, atencion, sugerencia);
                myref.child(FirebaseReferences.ENCUESTA_REFERENCE).push().setValue(encuesta);
                Toast.makeText(getApplicationContext(), "Enviado!!", Toast.LENGTH_SHORT).show();
            }
        });

    }


}
