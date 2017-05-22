package com.example.luiscobian.ejemplodatos;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by luiscobian on 5/16/17.
 */

public class AdaptadorPersonalizado extends
   RecyclerView.Adapter<AdaptadorPersonalizado.VistaPersona>{

    private List<Persona> datos;

    public AdaptadorPersonalizado(List<Persona> datos) {
        this.datos = datos;
    }

    @Override
    public VistaPersona onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from
                 (parent.getContext()).inflate(R.layout.activity_persona_actividad
                ,parent,false);
        VistaPersona vistaPersona = new VistaPersona(v);
        return vistaPersona;
    }

    @Override
    public void onBindViewHolder(VistaPersona holder, int position) {

        Persona persona = datos.get(position);
        holder.tvNombre.setText(persona.getNombre());
        holder.tvTelefono.setText(persona.getTelefono());
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    public static class VistaPersona extends RecyclerView.ViewHolder {

        TextView tvNombre;
        TextView tvTelefono;

        public VistaPersona(View itemView) {
            super(itemView);
            tvNombre = (TextView) itemView.findViewById(R.id.txtNombre);
            tvTelefono = (TextView) itemView.findViewById(R.id.txtTelefono);
        }
    }

}
