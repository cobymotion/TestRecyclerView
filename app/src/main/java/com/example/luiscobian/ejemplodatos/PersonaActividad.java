package com.example.luiscobian.ejemplodatos;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class PersonaActividad extends AppCompatActivity {

    public static final List<Persona> bd = new ArrayList<>();
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ventana_principal);

        rv = (RecyclerView) findViewById(R.id.rv);

        FloatingActionButton boton = (FloatingActionButton)
                 findViewById(R.id.addActivity);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PersonaActividad.this, AgregarActividad.class);
                startActivity(i);
            }
        });


        actualizaRecycler();

    }

    @Override
    public void onResume() {
        super.onResume();
        actualizaRecycler();
    }

    private void actualizaRecycler() {
        rv.setAdapter(new AdaptadorPersonalizado(bd));
        rv.hasFixedSize();
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
    }

}
