package Figuras;

/**
 * Clase que modela un Cilindro y calcula su volumen y superficie.
 */
public class Cilindro extends FiguraGeometrica {
    private double radio;
    private double altura;

    public Cilindro(double radio, double altura) {
        this.radio = radio;
        this.altura = altura;
        this.setVolumen(calcularVolumen());
        this.setSuperficie(calcularSuperficie());
    }

    public double calcularVolumen() {
        return Math.PI * altura * Math.pow(radio, 2.0);
    }

    public double calcularSuperficie() {
        double areaL = 2.0 * Math.PI * radio * altura;
        double areaB = 2.0 * Math.PI * Math.pow(radio, 2.0);
        return areaL + areaB;
    }
}
