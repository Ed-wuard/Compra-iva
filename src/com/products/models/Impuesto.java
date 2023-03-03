package com.products.models;

public class Impuesto {
    private final double porcentaje= 0.16;
    
    public double calcularImpuesto(double precio){
        
        return (precio * this.porcentaje);
    }
}
