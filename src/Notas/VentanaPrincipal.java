package Notas;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * Esta clase define la interfaz gráfica para el ingreso de 5 notas,
 * calculando promedio, desviación estándar, mayor y menor.
 * Incluye la parte propuesta: validación de campos vacíos y datos no numéricos con JOptionPane.
 */
public class VentanaPrincipal extends JFrame implements ActionListener {
    private Container contenedor;
    private JLabel nota1, nota2, nota3, nota4, nota5;
    private JLabel promedio, desviación, mayor, menor;
    private JTextField campoNota1, campoNota2, campoNota3, campoNota4, campoNota5;
    private JButton calcular, limpiar;

    public VentanaPrincipal() {
        inicio();
        setTitle("Notas");
        setSize(280, 380);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }

    private void inicio() {
        contenedor = getContentPane();
        contenedor.setLayout(null);

        // Nota 1
        nota1 = new JLabel("Nota 1:");
        nota1.setBounds(20, 20, 135, 23);
        campoNota1 = new JTextField();
        campoNota1.setBounds(105, 20, 135, 23);

        // Nota 2
        nota2 = new JLabel("Nota 2:");
        nota2.setBounds(20, 50, 135, 23);
        campoNota2 = new JTextField();
        campoNota2.setBounds(105, 50, 135, 23);

        // Nota 3
        nota3 = new JLabel("Nota 3:");
        nota3.setBounds(20, 80, 135, 23);
        campoNota3 = new JTextField();
        campoNota3.setBounds(105, 80, 135, 23);

        // Nota 4
        nota4 = new JLabel("Nota 4:");
        nota4.setBounds(20, 110, 135, 23);
        campoNota4 = new JTextField();
        campoNota4.setBounds(105, 110, 135, 23);

        // Nota 5
        nota5 = new JLabel("Nota 5:");
        nota5.setBounds(20, 140, 135, 23);
        campoNota5 = new JTextField();
        campoNota5.setBounds(105, 140, 135, 23);

        // Botón Calcular
        calcular = new JButton("Calcular");
        calcular.setBounds(20, 170, 100, 23);
        calcular.addActionListener(this);

        // Botón Limpiar
        limpiar = new JButton("Limpiar");
        limpiar.setBounds(125, 170, 80, 23);
        limpiar.addActionListener(this);

        // Resultados
        promedio = new JLabel("Promedio = ");
        promedio.setBounds(20, 210, 220, 23);

        desviación = new JLabel("Desviación estándar = ");
        desviación.setBounds(20, 240, 220, 23);

        mayor = new JLabel("Nota mayor = ");
        mayor.setBounds(20, 270, 220, 23);

        menor = new JLabel("Nota menor = ");
        menor.setBounds(20, 300, 220, 23);

        // Agregar al contenedor
        contenedor.add(nota1);
        contenedor.add(campoNota1);
        contenedor.add(nota2);
        contenedor.add(campoNota2);
        contenedor.add(nota3);
        contenedor.add(campoNota3);
        contenedor.add(nota4);
        contenedor.add(campoNota4);
        contenedor.add(nota5);
        contenedor.add(campoNota5);
        contenedor.add(calcular);
        contenedor.add(limpiar);
        contenedor.add(promedio);
        contenedor.add(desviación);
        contenedor.add(mayor);
        contenedor.add(menor);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == calcular) {
            // Validación de campos (Parte propuesta)
            if (campoNota1.getText().trim().isEmpty() ||
                campoNota2.getText().trim().isEmpty() ||
                campoNota3.getText().trim().isEmpty() ||
                campoNota4.getText().trim().isEmpty() ||
                campoNota5.getText().trim().isEmpty()) {
                
                JOptionPane.showMessageDialog(this, 
                    "Es obligatorio ingresar las cinco notas.", 
                    "Campo Vacío", JOptionPane.WARNING_MESSAGE);
                return;
            }

            try {
                Notas notas = new Notas();
                notas.listaNotas[0] = Double.parseDouble(campoNota1.getText().trim());
                notas.listaNotas[1] = Double.parseDouble(campoNota2.getText().trim());
                notas.listaNotas[2] = Double.parseDouble(campoNota3.getText().trim());
                notas.listaNotas[3] = Double.parseDouble(campoNota4.getText().trim());
                notas.listaNotas[4] = Double.parseDouble(campoNota5.getText().trim());

                // Validar que las notas estén en un rango válido (0.0 a 5.0 o 0 a 100 según el sistema)
                for (int i = 0; i < 5; i++) {
                    if (notas.listaNotas[i] < 0 || notas.listaNotas[i] > 5) {
                        JOptionPane.showMessageDialog(this,
                            "La nota " + (i + 1) + " debe estar entre 0.0 y 5.0",
                            "Rango Inválido", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                }

                promedio.setText("Promedio = " + String.format("%.2f", notas.calcularPromedio()));
                desviación.setText("Desviación estándar = " + String.format("%.2f", notas.calcularDesviación()));
                mayor.setText("Nota mayor = " + String.format("%.2f", notas.calcularMayor()));
                menor.setText("Nota menor = " + String.format("%.2f", notas.calcularMenor()));

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, 
                    "Error: Ingrese únicamente valores numéricos válidos en las notas.", 
                    "Error de Formato", JOptionPane.ERROR_MESSAGE);
            }
        }

        if (evento.getSource() == limpiar) {
            campoNota1.setText("");
            campoNota2.setText("");
            campoNota3.setText("");
            campoNota4.setText("");
            campoNota5.setText("");
            promedio.setText("Promedio = ");
            desviación.setText("Desviación estándar = ");
            mayor.setText("Nota mayor = ");
            menor.setText("Nota menor = ");
        }
    }
}
