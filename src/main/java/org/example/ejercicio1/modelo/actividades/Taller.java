package org.example.ejercicio1.modelo.actividades;

public class Taller extends Actividad {
    private boolean requiereNotebook;


    public Taller(int id, String titulo, int cupoMaximo, boolean requiereNotebook) {
        super(id, titulo, cupoMaximo);
        this.requiereNotebook = requiereNotebook;
    }

    @Override
    public double calcularCostoMateriales() {
        if (requiereNotebook) {
            return 5000.0;
        }
        return 2000.0;

    }

    @Override
    public String getTipo() {
        return "Taller";
    }

    @Override
    public String toString() {
        return "Taller{" +
                "inscripciones=" + inscripciones +
                ", requiereNotebook=" + requiereNotebook +
                '}';
    }
}
