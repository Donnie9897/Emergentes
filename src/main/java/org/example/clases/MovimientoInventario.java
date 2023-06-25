package org.example.clases;

import java.util.Date;

public class MovimientoInventario {

    String tipo;
    Date fecha;
    String almacen;
    Componente componente;
    int cantidad;

    public MovimientoInventario() {
        this.tipo = tipo;
        this.fecha = fecha;
        this.almacen = almacen;
        this.componente = componente;
        this.cantidad = cantidad;
    }

    public String getTipo() {
        return tipo;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getAlmacen() {
        return almacen;
    }

    public Componente getComponente() {
        return componente;
    }

    public int getCantidad() {
        return cantidad;
    }


}
