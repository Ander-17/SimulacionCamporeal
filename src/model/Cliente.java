/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;
/**
 *
 * @author Administrator
 */
public class Cliente {
    
    private int clienteId;
    private String nombre; 
    private List<Producto> carroCompras; // Cambiado a Lista de Productos
    
    public Cliente () {}

    public Cliente(int clienteId, String nombre, List<Producto> carroCompras) {
        this.clienteId = clienteId;
        this.nombre = nombre;
        this.carroCompras = carroCompras;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Producto> getCarroCompras() {
        return carroCompras;
    }

    public void setCarroCompras(List<Producto> carroCompras) {
        this.carroCompras = carroCompras;
    }

    @Override
    public String toString() {
        return "Cliente{" + "clienteId=" + clienteId + ", nombre=" + nombre + ", carroCompras=" + carroCompras + '}';
    }
     
}
