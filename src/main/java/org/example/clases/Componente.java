package org.example.clases;

import java.util.ArrayList;

public class Componente {

    String id;
    String nombre;
    String almacen;
    ArrayList<Proveedor> proveedores;
    double precio;
    double descuento;
    int cantidad;

    int inventarioMinimo;

    public Componente() {
        this.id = id;
        this.nombre = nombre;
        this.almacen = almacen;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getAlmacen() {
        return almacen;
    }

    public ArrayList<Proveedor> getProveedores() {
        return proveedores;
    }

    public double getPrecio() {
        return precio;
    }

    public double getDescuento() {
        return descuento;
    }

    public int getCantidad() {
        return cantidad;
    }
    public int getInventarioMinimo(){return inventarioMinimo;}

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAlmacen(String almacen) {
        this.almacen = almacen;
    }

    public void setProveedores(ArrayList<Proveedor> proveedores) {
        this.proveedores = proveedores;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }


}
