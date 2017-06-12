package com.example.luiscobian.ejemplodatos;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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

    private List<Persona> getDatos(){
        List<Persona> datos = new ArrayList<>();
        BaseContactos bdHelper = new BaseContactos(this);
        SQLiteDatabase bd = bdHelper.getReadableDatabase();
        String columns[] = {"nombre","telefono"};
        Cursor c = bd.query(
                "contacto",                     // The table to query
                columns,                               // The columns to return
                null,                                // The columns for the WHERE clause
                null,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                "nombre ASC"                                 // The sort order
        );
        if (c.moveToFirst()) {
            //Recorremos el cursor hasta que no haya más registros
            do {
                String nombre= c.getString(0);
                String telefono = c.getString(1);
                datos.add(new Persona(nombre,telefono));
            } while(c.moveToNext());
        }
        return datos;
    }

    private void actualizaRecycler() {
        rv.setAdapter(new AdaptadorPersonalizado(getDatos()));
        rv.hasFixedSize();
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
    }

}
