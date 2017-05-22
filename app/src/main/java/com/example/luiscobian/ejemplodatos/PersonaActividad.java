package com.example.luiscobian.ejemplodatos;

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
        //TODO: Provisional para quitarlo despues
        bd.add(new Persona("Prueba", "Telefono Prueba"));
        bd.add(new Persona("Prueba", "Telefono Prueba"));
        bd.add(new Persona("Prueba", "Telefono Prueba"));
        bd.add(new Persona("Prueba", "Telefono Prueba"));

        FloatingActionButton boton = (FloatingActionButton)
                 findViewById(R.id.addActivity);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PersonaActividad.this, "prueba",
                             Toast.LENGTH_LONG).show();
            }
        });


        actualizaRecycler();

    }

    private void actualizaRecycler() {
        rv.setAdapter(new AdaptadorPersonalizado(bd));
        rv.hasFixedSize();
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
    }

}
