package com.products;
import java.util.Scanner;

import java.util.InputMismatchException;
import com.products.models.Compra;

public class App {

    static void mensaje (String texto){
        System.out.println(texto);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); //Se crea el lector
        String nombreProd; float precio; int cantidad; // declaracion de variables
        
        mensaje("Nombre del producto:");
        nombreProd = sc.nextLine(); //Se guarda el nombre como dato de tipo String

        if(nombreProd.matches("^[a-zA-Z]*$")){ // validara que no se alla ingresado Numeros o Simbolos 

            try {
                mensaje("Precio del producto (0,0):");
                precio = sc.nextFloat(); //Se guarda el precio como dato de tipo Decimal
        
                mensaje("Cantidad de producto:");
                cantidad = sc.nextInt(); //Se guarda la cantidad directamente como dato de tipo entero
    
                Compra tu_compra = new Compra(cantidad, nombreProd, precio);

                mensaje("\n\tEsta es tu compra");
                mensaje("Cantidad - Nombre - Precio");
                mensaje(tu_compra.getCantidad() +"  "+tu_compra.mostrarArticulo());
                mensaje("Total a pagar -->  " + tu_compra.getTotal()+ "  Bs.");
    
            } catch (InputMismatchException e) {
                mensaje("\nError: Tipo de dato no valido");
                mensaje("\nMotivos de este error: \n-Ha ingresado en la Cantidad de producto letras\n-Ha ingresado en el precio del producto letras o un punto (.)");
                mensaje("\nVuelva a ejecutar el programa teniendo en cuenta los motivos mencionados");
            }

        }else {
            mensaje("\nError: Tipo de dato no valido");
            mensaje("\nMotivos de este error: \n-Ha ingresado en el Nombre del producto numeros o simbolos");
            mensaje("\nVuelva a ejecutar el programa teniendo en cuenta los motivos mencionados");
        }

        sc.close(); // cierro el lector
    }
    
}
