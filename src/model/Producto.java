/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Administrator
 */
public class Producto {
    
    private int productoId;
    private String nombre;
    private int tiempoPro;
    
    public Producto () {}

    public Producto(int productoId, String nombre, int tiempoPro) {
        this.productoId = productoId;
        this.nombre = nombre;
        this.tiempoPro = tiempoPro;
    }

    public int getProductoId() {
        return productoId;
    }

    public void setProductoId(int productoId) {
        this.productoId = productoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTiempoPro() {
        return tiempoPro;
    }

    public void setTiempoPro(int tiempoPro) {
        this.tiempoPro = tiempoPro;
    }

    @Override
    public String toString() {
        return "Producto{" + "productoId=" + productoId + ", nombre=" + nombre + ", tiempoPro=" + tiempoPro + '}';
    }
    
    
    
}
