package com.products.models;

public class Compra {
    private int cantidad;
    private double total;
    Producto articulo;

    public Compra(int cant, String nomp, double prec) {
        this.cantidad = cant;
        this.articulo = new Producto(nomp, prec);
    }

    public double getTotal(){
        this.total = articulo.getPrecio() * this.cantidad + (this.articulo.getIva() * this.cantidad);
        return total;
    }

    public String mostrarArticulo() {

        return this.articulo.getNombreprod() + "  " + this.articulo.getPrecio();
    }

    public int getCantidad() {
        return cantidad;
    }

    
}
