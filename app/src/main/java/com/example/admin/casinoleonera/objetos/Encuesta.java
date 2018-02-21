package com.example.admin.casinoleonera.objetos;

import android.widget.TextView;

/**
 * Created by admin on 20-02-2018.
 */

public class Encuesta {
    private Float servicio_nota;
    private Float atencion;
    private String sugerencia;

    public Encuesta() {
    }

    public Encuesta(Float servicio_nota, Float atencion, String sugerencia) {
        this.servicio_nota = servicio_nota;
        this.atencion = atencion;
        this.sugerencia = sugerencia;
    }

    public Float getServicio_nota() {
        return servicio_nota;
    }

    public void setServicio_nota(Float servicio_nota) {
        this.servicio_nota = servicio_nota;
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
}
