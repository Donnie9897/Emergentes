package org.example.clases;

import java.util.Date;

public class MovimientoInventario {

    String codigoMovimiento;
    Date fechaMovimiento;
    String codigoAlmacen;
    String tipoMovimiento;
    Componente componente;
    int cantidad;

    public MovimientoInventario() {
        this.codigoMovimiento = codigoMovimiento;
        this.fechaMovimiento = fechaMovimiento;
        this.tipoMovimiento = tipoMovimiento;
        this.componente = componente;
        this.cantidad = cantidad;
    }

    public String getCodigoMovimiento() {
        return codigoMovimiento;
    }

    public Date getFechaMovimiento() {
        return fechaMovimiento;
    }

    public Componente getComponente() {
        return componente;
    }

    public int getCantidad() {
        return cantidad;
    }


}
