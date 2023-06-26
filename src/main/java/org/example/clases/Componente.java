package org.example.clases;

import java.util.ArrayList;
import java.util.List;

public class Componente {

    String codigoComponente;
    String descripcion;
    int unidad;
    List almacenes;
    int inventarioMinimo;

    public Componente() {
        this.codigoComponente = new String();
        this.descripcion = new String();
        this.unidad = unidad;
        this.almacenes = almacenes;
        this.inventarioMinimo  = inventarioMinimo;
    }

    public String getCodigoComponente() {
        return codigoComponente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public List getAlmacenes() {
        return almacenes;
    }

    public int getUnidad() {
        return unidad;
    }
    public int getInventarioMinimo(){return inventarioMinimo;}

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setAlmacenes(List almacenes) {
        this.almacenes = almacenes;
    }

    public void setUnidad(int unidad) {
        this.unidad = unidad;
    }


}
