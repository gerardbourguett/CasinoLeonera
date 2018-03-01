package com.example.admin.casinoleonera;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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
    private RadioGroup planta;
    private RadioButton seleccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encuesta);

        mRatingBar = findViewById(R.id.mRatingBar);
        nRatingBar = findViewById(R.id.nRatingBar);
        sugerencia = findViewById(R.id.t_comen);
        enviar = findViewById(R.id.en_enviar);
        cancelar = findViewById(R.id.en_volver);
        planta = findViewById(R.id.radioGroup);


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference encuestaRef = database.getReference(FirebaseReferences.APP_REFERENCE);

        mRatingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {    }
        });

        nRatingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {    }
        });

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int radioId = planta.getCheckedRadioButtonId();

                seleccion = findViewById(radioId);

                Encuesta encuesta = new Encuesta (seleccion.getText().toString(), mRatingBar.getRating(), nRatingBar.getRating() , sugerencia.getText().toString());
                encuestaRef.child(FirebaseReferences.ENCUESTA_REFERENCE).push().setValue(encuesta);
                Toast.makeText(EncuestaActivity.this, "Datos Enviados.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(EncuestaActivity.this , HomeActivity.class);
                startActivity(intent);
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

    public void checkButton(View v){
        int radioId = planta.getCheckedRadioButtonId();

        seleccion = findViewById(radioId);
    }

}
