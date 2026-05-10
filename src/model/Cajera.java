/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Cajera extends Thread { 
    
    private int cajeraId;
    private String nombre; 
    private Cliente cliente;
    private long tiempoinicial;
    
    public Cajera () {}

    public Cajera(int cajeraId, String nombre, Cliente cliente, long tiempoinicial) {
        this.cajeraId = cajeraId;
        this.nombre = nombre;
        this.cliente = cliente;
        this.tiempoinicial = tiempoinicial;
    }

    public int getCajeraId() {
        return cajeraId;
    }

    public void setCajeraId(int cajeraId) {
        this.cajeraId = cajeraId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public long getTiempoinicial() {
        return tiempoinicial;
    }

    public void setTiempoinicial(long tiempoinicial) {
        this.tiempoinicial = tiempoinicial;
    }

    @Override
    public String toString() {
        return "Cajera{" + "cajeraId=" + cajeraId + ", nombre=" + nombre + ", cliente=" + cliente.getNombre() + ", tiempoinicial=" + tiempoinicial + '}';
    }
    
    
    @Override
    public void run() {
        System.out.println("La cajera " + this.nombre + " COMIENZA a procesar la compra del cliente " 
                + this.cliente.getNombre() + " en el tiempo: 0 seg");
        
        int tiempoTotalCompra = 0;
        
        if (this.cliente.getCarroCompras() != null) {
            for (int i = 0; i < this.cliente.getCarroCompras().size(); i++) {
                Producto producto = this.cliente.getCarroCompras().get(i);
                tiempoTotalCompra += producto.getTiempoPro();
                this.esperarXSegundos(producto.getTiempoPro());
                System.out.println("Procesado el producto " + producto.getNombre() 
                        + " del cliente " + this.cliente.getNombre() + " -> Tiempo: " 
                        + producto.getTiempoPro() + " seg");
            }
        }

        System.out.println("La cajera " + this.nombre + " HA TERMINADO de procesar al cliente " 
                + this.cliente.getNombre() + " en el tiempo total de: " + tiempoTotalCompra + " seg");
    }

    
    private void esperarXSegundos(int segundos) {
        try {
            Thread.sleep(segundos * 1000L);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}
