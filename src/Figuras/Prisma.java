package Figuras;

/**
 * Clase que modela un Prisma Rectangular (Parte propuesta Ejercicio 8.3).
 */
public class Prisma extends FiguraGeometrica {
    private double base;
    private double profundidad;
    private double altura;

    public Prisma(double base, double profundidad, double altura) {
        this.base = base;
        this.profundidad = profundidad;
        this.altura = altura;
        this.setVolumen(calcularVolumen());
        this.setSuperficie(calcularSuperficie());
    }

    public double calcularVolumen() {
        return base * profundidad * altura;
    }

    public double calcularSuperficie() {
        return 2.0 * (base * profundidad + base * altura + profundidad * altura);
    }
}
