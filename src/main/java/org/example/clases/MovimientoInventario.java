package org.example.clases;

import java.util.Date;
import java.util.List;

public class MovimientoInventario {

    String codigoMovimiento;
    Date fechaMovimiento;
    String codigoAlmacen;
    String tipoMovimiento;
    String componente;
    List detalle;
    int cantidad;

    public MovimientoInventario() {
        this.codigoMovimiento = new String();
        this.fechaMovimiento = new Date();
        this.codigoAlmacen = new String();
        this.tipoMovimiento = new String();
        this.componente = new String();
        this.cantidad = cantidad;
    }

    public MovimientoInventario(String codigoMovimiento, Date fechaMovimiento, String codigoAlmacen, String tipoMovimiento,  List detalle) {
        this.codigoMovimiento = codigoMovimiento;
        this.fechaMovimiento = fechaMovimiento;
        this.codigoAlmacen = codigoAlmacen;
        this.tipoMovimiento = tipoMovimiento;
        this.detalle = detalle;
    }

    public void setCodigoMovimiento(String codigoMovimiento) {
        this.codigoMovimiento = codigoMovimiento;
    }

    public void setFechaMovimiento(Date fechaMovimiento) {
        this.fechaMovimiento = fechaMovimiento;
    }

    public void setCodigoAlmacen(String codigoAlmacen) {
        this.codigoAlmacen = codigoAlmacen;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public void setComponente(String componente) {
        this.componente = componente;
    }

    public List getDetalle() {
        return detalle;
    }

    public void setDetalle(List detalle) {
        this.detalle = detalle;
    }

    public void setCantidad(int cantidad) {
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

    public String getComponente() {
        return componente;
    }

    public int getCantidad() {
        return cantidad;
    }


}
