package org.example.ejercicio3.modelo.actividades;

import org.example.ejercicio3.modelo.Estudiante;
import org.example.ejercicio3.modelo.certificacion.Certificable;

public class Taller extends Actividad implements Certificable {
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

    @Override
    public String generarCertificado(Estudiante estudiante) {
        return "Certificado generado para " + estudiante.getNombre();
    }
}
