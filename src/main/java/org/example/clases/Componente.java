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
        this.codigoComponente = codigoComponente;
        this.descripcion = descripcion;
        this.almacenes = almacenes;
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

    public ArrayList<Suplidor> getProveedores() {
        return proveedores;
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
