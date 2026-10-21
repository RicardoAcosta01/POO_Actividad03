package Figuras;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class VentanaCubo extends JFrame implements ActionListener {
    private Container contenedor;
    private JLabel lado, volumen, superficie;
    private JTextField campoLado;
    private JButton calcular;

    public VentanaCubo() {
        inicio();
        setTitle("Cubo");
        setSize(280, 200);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void inicio() {
        contenedor = getContentPane();
        contenedor.setLayout(null);

        lado = new JLabel("Lado (cms):");
        lado.setBounds(20, 20, 135, 23);
        campoLado = new JTextField();
        campoLado.setBounds(125, 20, 120, 23);

        calcular = new JButton("Calcular");
        calcular.setBounds(125, 50, 120, 23);
        calcular.addActionListener(this);

        volumen = new JLabel("Volumen (cm³):");
        volumen.setBounds(20, 90, 230, 23);

        superficie = new JLabel("Superficie (cm²):");
        superficie.setBounds(20, 120, 230, 23);

        contenedor.add(lado);
        contenedor.add(campoLado);
        contenedor.add(calcular);
        contenedor.add(volumen);
        contenedor.add(superficie);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        try {
            double l = Double.parseDouble(campoLado.getText().trim());
            if (l <= 0) {
                JOptionPane.showMessageDialog(this, "El lado debe ser mayor que cero.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Cubo cubo = new Cubo(l);
            volumen.setText("Volumen (cm³): " + String.format("%.2f", cubo.getVolumen()));
            superficie.setText("Superficie (cm²): " + String.format("%.2f", cubo.getSuperficie()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Campo nulo o error en formato de número", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
