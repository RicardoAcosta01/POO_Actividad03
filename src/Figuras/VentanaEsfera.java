package Figuras;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class VentanaEsfera extends JFrame implements ActionListener {
    private Container contenedor;
    private JLabel radio, volumen, superficie;
    private JTextField campoRadio;
    private JButton calcular;

    public VentanaEsfera() {
        inicio();
        setTitle("Esfera");
        setSize(280, 200);
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

        calcular = new JButton("Calcular");
        calcular.setBounds(125, 50, 120, 23);
        calcular.addActionListener(this);

        volumen = new JLabel("Volumen (cm³):");
        volumen.setBounds(20, 90, 230, 23);

        superficie = new JLabel("Superficie (cm²):");
        superficie.setBounds(20, 120, 230, 23);

        contenedor.add(radio);
        contenedor.add(campoRadio);
        contenedor.add(calcular);
        contenedor.add(volumen);
        contenedor.add(superficie);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        try {
            double r = Double.parseDouble(campoRadio.getText().trim());
            if (r <= 0) {
                JOptionPane.showMessageDialog(this, "El radio debe ser mayor que cero.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Esfera esfera = new Esfera(r);
            volumen.setText("Volumen (cm³): " + String.format("%.2f", esfera.getVolumen()));
            superficie.setText("Superficie (cm²): " + String.format("%.2f", esfera.getSuperficie()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Campo nulo o error en formato de número", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
