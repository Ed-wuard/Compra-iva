package com.products.models;

public class Producto {
    private String nombreprod;
    private double precio;
    Impuesto iva;

    
    public Producto(String nom, double pre){
        this.nombreprod = nom;
        this.precio = pre; 
        this.iva = new Impuesto(); 
    }
    
    public String getNombreprod(){
        return nombreprod;
    }
    
    public double getPrecio(){
        return precio;
    }

    public double getIva() {
        return iva.calcularImpuesto(this.precio);
    }
}
