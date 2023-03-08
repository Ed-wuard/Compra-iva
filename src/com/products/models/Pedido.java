package com.products.models;

public class Pedido {
    private Producto articulo;
    private int cantidad;
    private double monto;

    public Pedido(String nom, double prec, int cantidad) {
        this.articulo = new Producto(nom, prec);
        this.cantidad = cantidad;
    }

    public double getMonto() {
        this.monto = this.articulo.getPrecio() * this.cantidad;
        return monto;
    }
    

    public Producto getArticulo() {
        return articulo;
    }

    public int getCantidad() {
        return cantidad;
    }

    @Override
    public String toString() {
        return "Pedido [articulo=" + articulo + ", cantidad=" + cantidad + ", monto=" + monto + "]";
    }
    
    
    
}
