package com.example.admin.casinoleonera.objetos;

import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by admin on 20-02-2018.
 */

public class Encuesta {
    Float servicio;
    Float atencion;
    String sugerencia;

    public Encuesta() {
    }

    public Encuesta(Float servicio, Float atencion, String sugerencia) {
        this.servicio = servicio;
        this.atencion = atencion;
        this.sugerencia = sugerencia;
    }

    public Float getServicio() {
        return servicio;
    }

    public void setServicio(Float servicio) {
        this.servicio = servicio;
    }

    public Float getAtencion() {
        return atencion;
    }

    public void setAtencion(Float atencion) {
        this.atencion = atencion;
    }

    public String getSugerencia() {
        return sugerencia;
    }

    public void setSugerencia(String sugerencia) {
        this.sugerencia = sugerencia;
    }

    @Override
    public String toString() {
        return "Encuesta{" +
                "servicio=" + servicio +
                ", atencion=" + atencion +
                ", sugerencia='" + sugerencia + '\'' +
                '}';
    }
}