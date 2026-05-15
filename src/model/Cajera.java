
package model;

import javax.swing.JTextArea;

public class Cajera extends Thread {
    
    // Atributos
    private String nombre;
    private Cliente cliente;
    private JTextArea areaInforme;

  
    
    // Constructor con todos los atributos 
    public Cajera(String nombre, Cliente cliente, JTextArea areaInforme) {
        this.nombre = nombre;
        this.cliente = cliente;
        this.areaInforme = areaInforme;
    }

    // Método toString
    @Override
    public void run() {
        areaInforme.append("" + nombre + " comienza atención de: " +
                cliente.getNombre() + "\n--------------------------------------------------\n");
        
        int sumaTotal = 0;

        for (Producto p : cliente.getCarroCompras()) {
            try {
                // Tiempo aleatorio desde el procducto 
                Thread.sleep(p.getTiempoPro() * 1000); 
                sumaTotal += p.getTiempoPro();
                
                // Salida de la cajera y el cliente en proceso de cobro 
                areaInforme.append("[" + nombre + "] Cliente: " + cliente.getNombre() + 
                   " | " + p.getNombre() + " | Tiempo de proceso: " + p.getTiempoPro() + "s\n");
                
                areaInforme.setCaretPosition(areaInforme.getDocument().getLength());
                
            } catch (InterruptedException e) {
                areaInforme.append("Error en caja " + nombre + "\n");
            }
        }

        // Salida del total del cliente de tiempo en caja 
        areaInforme.append("--------------------------------------------------\n");
        areaInforme.append("✅ " + nombre + " FINALIZÓ con " + cliente.getNombre() 
                           + ". Total: " + sumaTotal + " seg.\n\n");
    }
}