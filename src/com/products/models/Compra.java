package com.products.models;

import java.util.ArrayList;
import java.util.List;

public class Compra {
    private double total;
    private List<Pedido> pedidos = new ArrayList<>();
    Impuesto iva = new Impuesto();

    public void agregarArticulo(Pedido pedido){
        this.pedidos.add(pedido);
    }

    public double getTotal(){
        double subTotal = 0;
        for(int i = 0; i< this.pedidos.size(); i++){
            subTotal += this.pedidos.get(i).getMonto();
        }
        
        this.total = this.iva.calcularImpuesto(subTotal) + subTotal;
        return total;
    }

    public List<Pedido> getPedidos() {
        
        return pedidos;
    }
    
}
