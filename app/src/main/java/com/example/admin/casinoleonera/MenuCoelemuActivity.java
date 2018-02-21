package com.example.admin.casinoleonera;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.admin.casinoleonera.objetos.AlmuerzoCoelemu;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MenuCoelemuActivity extends Activity {

    private Button co_volver;
    private TextView t_entrada, t_ensalada1, t_ensalada2, t_principal, t_alternativo, t_hipocalorico, t_postre1, t_postre2;
    private DatabaseReference dbcoelemu;
    private ValueEventListener eventListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_coelemu);

        co_volver = findViewById(R.id.co_volver);
        t_entrada = (TextView) findViewById(R.id.t_entrada);
        t_ensalada1 = (TextView)  findViewById(R.id.t_ensalada1);
        t_ensalada2 = (TextView)  findViewById(R.id.t_ensalada2);
        t_principal = (TextView)  findViewById(R.id.t_platofondo);
        t_alternativo = (TextView)  findViewById(R.id.t_alternativo);
        t_hipocalorico = (TextView)  findViewById(R.id.t_hipocalorico);
        t_postre1 = (TextView)  findViewById(R.id.t_postre);
        t_postre2 = (TextView)  findViewById(R.id.t_postre2);

        dbcoelemu = FirebaseDatabase.getInstance().getReference().child("Almuerzo").child("AlmuerzoCoelemu");
        eventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                AlmuerzoCoelemu ac = dataSnapshot.getValue(AlmuerzoCoelemu.class);
                t_entrada.setText(ac.getT_entrada());
                t_ensalada1.setText(ac.getT_ensalada1());
                t_ensalada2.setText(ac.getT_ensalada2());
                t_principal.setText(ac.getT_principal());
                t_alternativo.setText(ac.getT_alternativo());
                t_hipocalorico.setText(ac.getT_hipocalorico());
                t_postre1.setText(ac.getT_postre1());
                t_postre2.setText(ac.getT_postre2());

                Log.e("onDataChange: ", dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e("ERROR!!", databaseError.getMessage());
            }
        };

        dbcoelemu.addValueEventListener(eventListener);

        co_volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuCoelemuActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

    }
}
