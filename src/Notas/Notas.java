package Notas;

/**
 * Esta clase denominada Notas define un array de notas numéricas de tipo double.
 * Incluye métodos para calcular el promedio, desviación estándar, nota mayor y nota menor.
 */
public class Notas {
    double[] listaNotas;

    /**
     * Constructor de la clase Notas, instancia un array con 5 notas de tipo double.
     */
    public Notas() {
        listaNotas = new double[5];
    }

    /**
     * Método que calcula el promedio de las notas ingresadas.
     * @return El promedio numérico del array de notas.
     */
    public double calcularPromedio() {
        double suma = 0;
        for (int i = 0; i < listaNotas.length; i++) {
            suma += listaNotas[i];
        }
        return suma / listaNotas.length;
    }

    /**
     * Método que calcula la desviación estándar del conjunto de notas.
     * @return La desviación estándar del array de notas.
     */
    public double calcularDesviación() {
        double prom = calcularPromedio();
        double suma = 0;
        for (int i = 0; i < listaNotas.length; i++) {
            suma += Math.pow(listaNotas[i] - prom, 2);
        }
        return Math.sqrt(suma / listaNotas.length);
    }

    /**
     * Método que calcula la menor nota dentro del array.
     * @return La menor nota.
     */
    public double calcularMenor() {
        double menor = listaNotas[0];
        for (int i = 1; i < listaNotas.length; i++) {
            if (listaNotas[i] < menor) {
                menor = listaNotas[i];
            }
        }
        return menor;
    }

    /**
     * Método que calcula la mayor nota dentro del array.
     * @return La mayor nota.
     */
    public double calcularMayor() {
        double mayor = listaNotas[0];
        for (int i = 1; i < listaNotas.length; i++) {
            if (listaNotas[i] > mayor) {
                mayor = listaNotas[i];
            }
        }
        return mayor;
    }
}
