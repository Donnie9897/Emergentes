package org.example.clases;

import java.util.ArrayList;
import java.util.Date;

public class OrdenCompra {

    String proveedor;
    Date fechaOrden;
    ArrayList<Componente> componentes;
    double montoTotal;

    public OrdenCompra() {
        this.proveedor = new String();
    }

    public String getProveedor() {
        return proveedor;
    }


    public Date getFechaOrden() {
        return fechaOrden;
    }

    public ArrayList<Componente> getComponentes() {
        return componentes;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public void setFechaOrden(Date fechaOrden) {
        this.fechaOrden = fechaOrden;
    }

    public void setComponentes(ArrayList<Componente> componentes) {
        this.componentes = componentes;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public void agregarComponente(Componente aux){
        componentes.add(aux);
    }
}
