package Figuras;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class VentanaPirámide extends JFrame implements ActionListener {
    private Container contenedor;
    private JLabel base, altura, apotema, volumen, superficie;
    private JTextField campoBase, campoAltura, campoApotema;
    private JButton calcular;

    public VentanaPirámide() {
        inicio();
        setTitle("Pirámide");
        setSize(280, 250);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void inicio() {
        contenedor = getContentPane();
        contenedor.setLayout(null);

        base = new JLabel("Base (cms):");
        base.setBounds(20, 20, 135, 23);
        campoBase = new JTextField();
        campoBase.setBounds(125, 20, 120, 23);

        altura = new JLabel("Altura (cms):");
        altura.setBounds(20, 50, 135, 23);
        campoAltura = new JTextField();
        campoAltura.setBounds(125, 50, 120, 23);

        apotema = new JLabel("Apotema (cms):");
        apotema.setBounds(20, 80, 135, 23);
        campoApotema = new JTextField();
        campoApotema.setBounds(125, 80, 120, 23);

        calcular = new JButton("Calcular");
        calcular.setBounds(125, 110, 120, 23);
        calcular.addActionListener(this);

        volumen = new JLabel("Volumen (cm³):");
        volumen.setBounds(20, 150, 230, 23);

        superficie = new JLabel("Superficie (cm²):");
        superficie.setBounds(20, 180, 230, 23);

        contenedor.add(base);
        contenedor.add(campoBase);
        contenedor.add(altura);
        contenedor.add(campoAltura);
        contenedor.add(apotema);
        contenedor.add(campoApotema);
        contenedor.add(calcular);
        contenedor.add(volumen);
        contenedor.add(superficie);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        try {
            double b = Double.parseDouble(campoBase.getText().trim());
            double h = Double.parseDouble(campoAltura.getText().trim());
            double a = Double.parseDouble(campoApotema.getText().trim());

            if (b <= 0 || h <= 0 || a <= 0) {
                JOptionPane.showMessageDialog(this, "Los valores deben ser mayores que cero.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Piramide pirámide = new Piramide(b, h, a);
            volumen.setText("Volumen (cm³): " + String.format("%.2f", pirámide.getVolumen()));
            superficie.setText("Superficie (cm²): " + String.format("%.2f", pirámide.getSuperficie()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Campo nulo o error en formato de número", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
