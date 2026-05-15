
package model;

/**
 *
 * @author Ander
 */
public class Producto {
    
    // Atributos
    private int productoId;
    private String nombre;
    private int tiempoPro;

    // Constructor con todos los atributos 
    public Producto(int productoId, String nombre, int tiempoPro) {
        this.productoId = productoId;
        this.nombre = nombre;
        this.tiempoPro = tiempoPro;
    }

    // Getters y Setters
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

    // Método toString
    @Override
    public String toString() {
        return "Producto{" + "productoId=" + productoId +
                ", nombre=" + nombre + ", tiempoPro=" +
                tiempoPro + '}';
    }
    
    
    
}
