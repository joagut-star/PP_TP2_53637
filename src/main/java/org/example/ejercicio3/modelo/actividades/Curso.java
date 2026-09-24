package org.example.ejercicio3.modelo.actividades;

import org.example.ejercicio3.modelo.Estudiante;
import org.example.ejercicio3.modelo.certificacion.Certificable;

public class Curso extends Actividad implements Certificable {
    private int nivel;

    public Curso(int id, String titulo, int cupoMaximo, int nivel) {
        super(id, titulo, cupoMaximo);
        this.nivel = nivel;
    }

    @Override
    public double calcularCostoMateriales() {
        switch(nivel){
            case 1: return 3000;
            case 2: return 4000;
            case 3: return 5000;
            case 4: return 6000;
            case 5: return 7000;
        }

        return super.calcularCostoMateriales();
    }

    @Override
    public String getTipo() {
        return "Curso";
    }

    @Override
    public String generarCertificado(Estudiante estudiante) {
        return "Certificado generado para " + estudiante.getNombre();
    }
}
