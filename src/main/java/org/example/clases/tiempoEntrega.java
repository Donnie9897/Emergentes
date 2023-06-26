package org.example.clases;

public class tiempoEntrega {

    String codigoSuplidor;
    String codigoComponente;
    int tiempoEntrega;
    double precio;
    double descuento;
    String activo;

    public tiempoEntrega() {
        this.codigoSuplidor = new String();
        this.codigoComponente = new String();
        this.tiempoEntrega = tiempoEntrega;
        this.precio = precio;
        this.descuento = descuento;
        this.activo = new String();
    }

    public String getCodigoSuplidor() {
        return codigoSuplidor;
    }

    public String getCodigoComponente() {
        return codigoComponente;
    }

    public int getTiempoEntrega() {
        return tiempoEntrega;
    }

    public double getPrecio() {
        return precio;
    }

    public double getDescuento() {
        return descuento;
    }

    public String getActivo() {
        return activo;
    }
}
