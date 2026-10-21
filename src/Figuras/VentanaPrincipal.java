package Figuras;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * Ventana principal para la selección de figuras geométricas (Ejercicio 8.3).
 * Incluye la parte propuesta con opción para Cubo.
 */
public class VentanaPrincipal extends JFrame implements ActionListener {
    private Container contenedor;
    private JButton cilindro, esfera, pirámide, cubo;

    public VentanaPrincipal() {
        inicio();
        setTitle("Figuras Geométricas");
        setSize(420, 140);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }

    private void inicio() {
        contenedor = getContentPane();
        contenedor.setLayout(null);

        cilindro = new JButton("Cilindro");
        cilindro.setBounds(20, 35, 85, 30);
        cilindro.addActionListener(this);

        esfera = new JButton("Esfera");
        esfera.setBounds(115, 35, 85, 30);
        esfera.addActionListener(this);

        pirámide = new JButton("Pirámide");
        pirámide.setBounds(210, 35, 90, 30);
        pirámide.addActionListener(this);

        // Parte propuesta: Cubo
        cubo = new JButton("Cubo");
        cubo.setBounds(310, 35, 80, 30);
        cubo.addActionListener(this);

        contenedor.add(cilindro);
        contenedor.add(esfera);
        contenedor.add(pirámide);
        contenedor.add(cubo);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == cilindro) {
            VentanaCilindro vCilindro = new VentanaCilindro();
            vCilindro.setVisible(true);
        }
        if (evento.getSource() == esfera) {
            VentanaEsfera vEsfera = new VentanaEsfera();
            vEsfera.setVisible(true);
        }
        if (evento.getSource() == pirámide) {
            VentanaPirámide vPirámide = new VentanaPirámide();
            vPirámide.setVisible(true);
        }
        if (evento.getSource() == cubo) {
            VentanaCubo vCubo = new VentanaCubo();
            vCubo.setVisible(true);
        }
    }
}
