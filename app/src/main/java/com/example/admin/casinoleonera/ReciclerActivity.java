package com.example.admin.casinoleonera;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.admin.casinoleonera.RecyclerView.Adapter;
import com.example.admin.casinoleonera.objetos.Encuesta;
import com.example.admin.casinoleonera.objetos.FirebaseReferences;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ReciclerActivity extends AppCompatActivity {

    RecyclerView rv;

    List<Encuesta> encuestas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recicler);

        rv = findViewById(R.id.reciclerView);

        rv.setLayoutManager(new LinearLayoutManager(this));

        encuestas = new ArrayList<>();

        FirebaseDatabase database = FirebaseDatabase.getInstance();

        final Adapter adapter = new Adapter(encuestas);

        rv.setAdapter(adapter);

        database.getReference().getRoot().addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                encuestas.removeAll(encuestas);
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    Encuesta enc = snapshot.getValue(Encuesta.class);
                    encuestas.add(enc);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
