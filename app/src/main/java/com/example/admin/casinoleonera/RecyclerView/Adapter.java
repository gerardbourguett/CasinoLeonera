package com.example.admin.casinoleonera.RecyclerView;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.admin.casinoleonera.R;
import com.example.admin.casinoleonera.objetos.Encuesta;

import java.util.List;

/**
 * Created by Gerard on 02-03-2018.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.EncuestaViewHolder>{

    List<Encuesta> encuestas;

    public Adapter(List<Encuesta> encuestas) {
        this.encuestas = encuestas;
    }

    @Override
    public EncuestaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_row, parent, false);
        EncuestaViewHolder holder = new EncuestaViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(EncuestaViewHolder holder, int position) {
        Encuesta encuesta = encuestas.get(position);
        holder.tv_planta.setText(encuesta.getPlanta());
        holder.tv_servicio.setText(encuesta.getServicio().byteValue());
        holder.tv_atencion.setText(encuesta.getAtencion().byteValue());
        holder.tv_sugerencia.setText(encuesta.getSugerencia());
    }

    @Override
    public int getItemCount() {
        return encuestas.size();
    }

    public static class EncuestaViewHolder extends RecyclerView.ViewHolder {

        TextView tv_planta, tv_servicio, tv_atencion, tv_sugerencia;

        public EncuestaViewHolder(View itemView) {
            super(itemView);
            tv_planta = itemView.findViewById(R.id.tv_planta);
            tv_servicio = itemView.findViewById(R.id.tv_servicio);
            tv_atencion = itemView.findViewById(R.id.tv_atencion);
            tv_sugerencia = itemView.findViewById(R.id.tv_sugerencia);
        }
    }
}
