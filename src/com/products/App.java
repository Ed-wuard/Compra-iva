package com.products;
import java.util.Scanner;

import java.util.InputMismatchException;
import java.util.List;

import com.products.models.Compra;
import com.products.models.Pedido;

public class App {

    static void msj (String texto){
        System.out.println(texto);
    }

    static void realizarPedido (Compra tu_compra, Pedido pedido){
        tu_compra.agregarArticulo(pedido);
    }

    static void finalizarCompra (Compra tu_compra){
        msj("\n\tEsta es tu compra");
        List<Pedido> compra = tu_compra.getPedidos();
        for(int i = 0; i< compra.size(); i++){
            String articulo = compra.get(i).getCantidad() +" "+ compra.get(i).getArticulo().getNombreprod() + " de " + compra.get(i).getArticulo().getPrecio() + "Bs";
            msj(articulo + "\n");
        }
        msj("Total a pagar -->  " + tu_compra.getTotal()+ "  Bs.");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); //Se crea el lector

        Compra tu_compra = new Compra();

        int pregunta = 1;
        
        while (pregunta == 1) {
            String nombreProd; float precio; int cantidad; // declaracion de variables

            msj("Nombre del producto:");
            nombreProd = sc.nextLine(); //Se guarda el nombre como dato de tipo String

            if(nombreProd.matches("^[a-zA-Z]*$")){ // validara que no se alla ingresado Numeros o Simbolos 

                try {
                    
                    msj("Precio del producto (0,0):");
                    precio = sc.nextFloat(); //Se guarda el precio como dato de tipo Decimal
            
                    msj("Cantidad de producto:");
                    cantidad = sc.nextInt(); //Se guarda la cantidad directamente como dato de tipo entero
        
                    Pedido tu_pedido = new Pedido(nombreProd, precio, cantidad);
                    realizarPedido(tu_compra, tu_pedido);

                    msj("Desea Realizar otro pedido?");
                    msj("ingrese 1 para si y 0 para no");
                    pregunta = sc.nextInt();
                    

                } catch (InputMismatchException e) {
                    msj("\nError: Tipo de dato no valido");
                    msj("\nMotivos de este error: \n-Ha ingresado en la Cantidad de producto letras\n-Ha ingresado en el precio del producto letras o un punto (.)");
                    msj("\nVuelva a ejecutar el programa teniendo en cuenta los motivos mencionados");
                }

            }else {
                msj("\nError: Tipo de dato no valido");
                msj("\nMotivos de este error: \n-Ha ingresado en el Nombre del producto numeros o simbolos");
                msj("\nVuelva a ejecutar el programa teniendo en cuenta los motivos mencionados");
            }
        }
        sc.close();

        finalizarCompra(tu_compra);
         // cierro el lector
    }
    
}
