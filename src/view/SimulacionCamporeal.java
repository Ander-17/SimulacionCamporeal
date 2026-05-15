
package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import model.*;

public class SimulacionCamporeal extends JFrame {

    private JTextArea areaInforme;
    private JButton btnIniciar;
    private Random random = new Random();

    public SimulacionCamporeal() {
        // Lineamientos para la ventana
        setTitle("Camporeal System - Panel de Control");
        setSize(700, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Parte principal de la Vista
        JPanel panelPrincipal = new JPanel(new BorderLayout(15, 15));
        panelPrincipal.setBorder(new EmptyBorder(20, 20, 20, 20));
        panelPrincipal.setBackground(new Color(30, 30, 30)); 
        setContentPane(panelPrincipal);

        // Monitor de salida de mensajes 
        areaInforme = new JTextArea();
        areaInforme.setEditable(false);
        areaInforme.setBackground(Color.BLACK);
        areaInforme.setForeground(new Color(0, 255, 200));
        areaInforme.setFont(new Font("Consolas", Font.BOLD, 14));
        
        JScrollPane scroll = new JScrollPane(areaInforme);
        panelPrincipal.add(scroll, BorderLayout.CENTER);


        btnIniciar = new JButton("INICIAR PROCESO DE COBRO");
        btnIniciar.setFont(new Font("Segoe UI", Font.BOLD, 20));
        btnIniciar.setBackground(new Color(50, 50, 50));
        btnIniciar.setForeground(Color.YELLOW);
        btnIniciar.setFocusPainted(false);
        btnIniciar.setOpaque(true);
        btnIniciar.setBorder(BorderFactory.createLineBorder(new Color(0, 255, 200), 2));
        btnIniciar.setPreferredSize(new Dimension(0, 80)); 
        
        panelPrincipal.add(btnIniciar, BorderLayout.SOUTH);

        btnIniciar.addActionListener(e -> ejecutar());
    }

    private void ejecutar() {
        areaInforme.setText("");
        btnIniciar.setEnabled(false);

        // Lista de posible productos que pueden comprar los clientes 
        String[] nombres = {"Arroz", "Leche", "Café", "Aceite", "Pasta", "Pan", "Huevos AA", "Papas",
                            "Cilantro", "Harina Maíz", "Agua 1L", "Coca Cola 3L", "Vinagre", "Shampoo",
                            "Bretaña 350ml", "Desodorante", "Aromática", "Aguardiente Media", "Ron Caldas 1L"};
        
        // Generación de productos de manera aleatoria 
        List<Producto> carrito1 = crearCarrito(nombres);
        List<Producto> carrito2 = crearCarrito(nombres);
        List<Producto> carrito3 = crearCarrito(nombres);

        // Clientes 
        Cliente c1 = new Cliente(1, "Juan", carrito1);
        Cliente c2 = new Cliente(2, "Maria", carrito2);
        Cliente c3 = new Cliente(2, "Jacobo", carrito3);

        // Cajera 
        Cajera cajera1 = new Cajera("Caja 01: Margarita", c1, areaInforme);
        Cajera cajera2 = new Cajera("Caja 02: Flor", c2, areaInforme);
        Cajera cajera3 = new Cajera("Caja 03: Diana", c3, areaInforme);

        // Proceso de inicio de cobre en caja para cada cajera
        cajera1.start();
        cajera2.start();
        cajera3.start();

        // Reactivar el botón 
        new Thread(() -> {
            try {
                cajera1.join();
                cajera2.join();
                btnIniciar.setEnabled(true);
            } catch (Exception ex) {}
        }).start();
    }

    //Método para crear el carrito de compras
    private List<Producto> crearCarrito(String[] nombres) {
        List<Producto> lista = new ArrayList<>();
        int cantidad = random.nextInt(4) + 7;
        for (int i = 0; i < cantidad; i++) {
            lista.add(new Producto(i, nombres[random.nextInt(nombres.length)], random.nextInt(3) + 1));
        }
        return lista;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SimulacionCamporeal().setVisible(true));
    }
}