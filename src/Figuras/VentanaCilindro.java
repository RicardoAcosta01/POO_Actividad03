package Figuras;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class VentanaCilindro extends JFrame implements ActionListener {
    private Container contenedor;
    private JLabel radio, altura, volumen, superficie;
    private JTextField campoRadio, campoAltura;
    private JButton calcular;

    public VentanaCilindro() {
        inicio();
        setTitle("Cilindro");
        setSize(280, 220);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void inicio() {
        contenedor = getContentPane();
        contenedor.setLayout(null);

        radio = new JLabel("Radio (cms):");
        radio.setBounds(20, 20, 135, 23);
        campoRadio = new JTextField();
        campoRadio.setBounds(125, 20, 120, 23);

        altura = new JLabel("Altura (cms):");
        altura.setBounds(20, 50, 135, 23);
        campoAltura = new JTextField();
        campoAltura.setBounds(125, 50, 120, 23);

        calcular = new JButton("Calcular");
        calcular.setBounds(125, 80, 120, 23);
        calcular.addActionListener(this);

        volumen = new JLabel("Volumen (cm³):");
        volumen.setBounds(20, 120, 230, 23);

        superficie = new JLabel("Superficie (cm²):");
        superficie.setBounds(20, 150, 230, 23);

        contenedor.add(radio);
        contenedor.add(campoRadio);
        contenedor.add(altura);
        contenedor.add(campoAltura);
        contenedor.add(calcular);
        contenedor.add(volumen);
        contenedor.add(superficie);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        boolean error = false;
        try {
            double r = Double.parseDouble(campoRadio.getText().trim());
            double h = Double.parseDouble(campoAltura.getText().trim());
            
            if (r <= 0 || h <= 0) {
                JOptionPane.showMessageDialog(this, "Los valores deben ser mayores que cero.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Cilindro cilindro = new Cilindro(r, h);
            volumen.setText("Volumen (cm³): " + String.format("%.2f", cilindro.getVolumen()));
            superficie.setText("Superficie (cm²): " + String.format("%.2f", cilindro.getSuperficie()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Campo nulo o error en formato de número", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
