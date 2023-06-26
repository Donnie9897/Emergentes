package org.example.clases;

import java.util.Date;
import java.util.List;

public class MovimientoInventario {

    String codigoMovimiento;
    Date fechaMovimiento;
    String codigoAlmacen;
    String tipoMovimiento;
    Componente componente;
    List detalle;
    int cantidad;

    public MovimientoInventario() {
        this.codigoMovimiento = new String();
        this.fechaMovimiento = new Date();
        this.codigoAlmacen = new String();
        this.tipoMovimiento = new String();
        this.componente = new Componente();
        this.cantidad = cantidad;
    }

    public String getCodigoMovimiento() {
        return codigoMovimiento;
    }

    public Date getFechaMovimiento() {
        return fechaMovimiento;
    }

    public String getCodigoAlmacen() {
        return codigoAlmacen;
    }

    public Componente getComponente() {
        return componente;
    }

    public int getCantidad() {
        return cantidad;
    }


}
