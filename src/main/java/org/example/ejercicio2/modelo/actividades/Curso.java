package org.example.ejercicio2.modelo.actividades;

import org.example.ejercicio2.modelo.Estudiante;
import org.example.ejercicio2.modelo.certificacion.Certificable;

public class Curso extends Actividad implements Certificable {
    private int nivel;

    public Curso(int id, String titulo, int cupoMaximo, int nivel) {
        super(id, titulo, cupoMaximo);
        this.nivel = nivel;
    }

    @Override
    public double calcularCostoMateriales() {
        return super.calcularCostoMateriales();
    }

    @Override
    public String getTipo() {
        return super.getTipo();
    }

    @Override
    public String generarCertificado(Estudiante estudiante) {
        return "Certificado generado para " + estudiante.getNombre();
    }
}
