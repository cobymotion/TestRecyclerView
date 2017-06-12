package com.example.luiscobian.ejemplodatos;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AgregarActividad extends AppCompatActivity {

    EditText texto1;
    EditText texto2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_actividad);

        Button boton = (Button) findViewById(R.id.idAgrega);
        texto1 = (EditText) findViewById(R.id.texto1);
        texto2 = (EditText) findViewById(R.id.texto2);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Persona persona = new Persona(texto1.getText().toString(),
                        texto2.getText().toString());
                PersonaActividad.bd.add(persona);
                BaseContactos bdHelper = new BaseContactos(AgregarActividad.this);
                SQLiteDatabase bd = bdHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("nombre",texto1.getText().toString());
                values.put("telefono",texto2.getText().toString());
                bd.insert("contacto",null, values);
                finish();

            }
        });
    }
}
