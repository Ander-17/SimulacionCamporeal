/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package simulacioncamporeal;

import java.util.*;
import model.Cajera;
import model.Cliente;
import model.Producto;


/**
 *
 * @author Anderson Lopera
 */
public class SimulacionCamporeal {

    public static void main(String[] args) {
        Random random = new Random();

        Producto producto1 = new Producto(1, "Arroz", random.nextInt(5) + 1);
        Producto producto2 = new Producto(2, "Frijoles", random.nextInt(5) + 1);
        Producto producto3 = new Producto(3, "Aceite", random.nextInt(5) + 1);
        Producto producto4 = new Producto(4, "Huevos", random.nextInt(5) + 1);
        Producto producto5 = new Producto(5, "Leche", random.nextInt(5) + 1);

        List<Producto> carritoCliente1 = new ArrayList<>();
        carritoCliente1.add(producto1); 
        carritoCliente1.add(producto2); 
        carritoCliente1.add(producto3); 

        List<Producto> carritoCliente2 = new ArrayList<>();
        carritoCliente2.add(producto4); 
        carritoCliente2.add(producto5); 
        carritoCliente2.add(producto1); 

        Cliente cliente1 = new Cliente(1, "Juan", carritoCliente1);
        Cliente cliente2 = new Cliente(2, "Maria", carritoCliente2);

        long tiempoInicial = System.currentTimeMillis();

        Cajera cajera1 = new Cajera(1, "Ana (Caja 1)", cliente1, tiempoInicial);
        Cajera cajera2 = new Cajera(2, "Luisa (Caja 2)", cliente2, tiempoInicial);

        cajera1.start();
        cajera2.start();
    }

}
