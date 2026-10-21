package Figuras;

/**
 * Clase abstracta que representa una Figura Geométrica en 3D.
 */
public class FiguraGeometrica {
    private double volumen;
    private double superficie;

    public void setVolumen(double volumen) {
        this.volumen = volumen;
    }

    public double getVolumen() {
        return volumen;
    }

    public void setSuperficie(double superficie) {
        this.superficie = superficie;
    }

    public double getSuperficie() {
        return superficie;
    }
}
