
package model;

import java.util.List;
/**
 *
 * @author Ander
 */
public class Cliente {
    
    // Atributos
    private int clienteId;
    private String nombre; 
    private List<Producto> carroCompras; 
    
    // Constructor vacío 
    public Cliente () {}

    // Constructor con todos los atributos 
    public Cliente(int clienteId, String nombre, List<Producto> carroCompras) {
        this.clienteId = clienteId;
        this.nombre = nombre;
        this.carroCompras = carroCompras;
    }

    // Getters y Setters
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

    // Método toString
    @Override
    public String toString() {
        return "Cliente{" + "clienteId=" + clienteId + 
                ", nombre=" + nombre + ", carroCompras=" +
                carroCompras + '}';
    }
     
}
