package Figuras;

/**
 * Clase que modela un Cubo (Hexaedro Regular) (Parte propuesta Ejercicio 8.3).
 */
public class Cubo extends FiguraGeometrica {
    private double lado;

    public Cubo(double lado) {
        this.lado = lado;
        this.setVolumen(calcularVolumen());
        this.setSuperficie(calcularSuperficie());
    }

    public double calcularVolumen() {
        return Math.pow(lado, 3.0);
    }

    public double calcularSuperficie() {
        return 6.0 * Math.pow(lado, 2.0);
    }
}
