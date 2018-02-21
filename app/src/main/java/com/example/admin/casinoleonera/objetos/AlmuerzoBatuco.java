package com.example.admin.casinoleonera.objetos;

import android.widget.TextView;

/**
 * Created by admin on 20-02-2018.
 */

public class AlmuerzoBatuco {
    String t_entrada, t_ensalada1, t_ensalada2, t_principal, t_alternativo, t_hipocalorico, t_postre1, t_postre2;

    public AlmuerzoBatuco() {
    }

    public AlmuerzoBatuco(String t_entrada, String t_ensalada1, String t_ensalada2, String t_principal,
                          String t_alternativo, String t_hipocalorico, String t_postre1, String t_postre2) {
        this.t_entrada = t_entrada;
        this.t_ensalada1 = t_ensalada1;
        this.t_ensalada2 = t_ensalada2;
        this.t_principal = t_principal;
        this.t_alternativo = t_alternativo;
        this.t_hipocalorico = t_hipocalorico;
        this.t_postre1 = t_postre1;
        this.t_postre2 = t_postre2;
    }

    public String getT_entrada() {
        return t_entrada;
    }

    public void setT_entrada(String t_entrada) {
        this.t_entrada = t_entrada;
    }

    public String getT_ensalada1() {
        return t_ensalada1;
    }

    public void setT_ensalada1(String t_ensalada1) {
        this.t_ensalada1 = t_ensalada1;
    }

    public String getT_ensalada2() {
        return t_ensalada2;
    }

    public void setT_ensalada2(String t_ensalada2) {
        this.t_ensalada2 = t_ensalada2;
    }

    public String getT_principal() {
        return t_principal;
    }

    public void setT_principal(String t_principal) {
        this.t_principal = t_principal;
    }

    public String getT_alternativo() {
        return t_alternativo;
    }

    public void setT_alternativo(String t_alternativo) {
        this.t_alternativo = t_alternativo;
    }

    public String getT_hipocalorico() {
        return t_hipocalorico;
    }

    public void setT_hipocalorico(String t_hipocalorico) {
        this.t_hipocalorico = t_hipocalorico;
    }

    public String getT_postre1() {
        return t_postre1;
    }

    public void setT_postre1(String t_postre1) {
        this.t_postre1 = t_postre1;
    }

    public String getT_postre2() {
        return t_postre2;
    }

    public void setT_postre2(String t_postre2) {
        this.t_postre2 = t_postre2;
    }

    @Override
    public String toString() {
        return "AlmuerzoBatuco{" +
                "t_entrada='" + t_entrada + '\'' +
                ", t_ensalada1='" + t_ensalada1 + '\'' +
                ", t_ensalada2='" + t_ensalada2 + '\'' +
                ", t_principal='" + t_principal + '\'' +
                ", t_alternativo='" + t_alternativo + '\'' +
                ", t_hipocalorico='" + t_hipocalorico + '\'' +
                ", t_postre1='" + t_postre1 + '\'' +
                ", t_postre2='" + t_postre2 + '\'' +
                '}';
    }
}
