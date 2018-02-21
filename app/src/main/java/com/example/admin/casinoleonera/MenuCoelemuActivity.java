package com.example.admin.casinoleonera;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MenuCoelemuActivity extends Activity {

    Button co_volver;
    TextView t_entrada, t_ensalada1, t_ensalada2, t_principal, t_alternativo, t_hipocalorico, t_postre1, t_postre2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_batuco);

        co_volver = findViewById(R.id.co_volver);

        t_entrada = findViewById(R.id.t_entrada);
        t_ensalada1 = findViewById(R.id.t_ensalada1);
        t_ensalada2 = findViewById(R.id.t_ensalada2);
        t_principal = findViewById(R.id.t_platofondo);
        t_alternativo = findViewById(R.id.t_alternativo);
        t_hipocalorico = findViewById(R.id.t_hipocalorico);
        t_postre1 = findViewById(R.id.t_postre);
        t_postre2 = findViewById(R.id.t_postre2);


        co_volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuCoelemuActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}
