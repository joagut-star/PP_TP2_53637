package org.example.ejercicio3.modelo.actividades;

import org.example.ejercicio3.excepciones.CupoExcedidoException;
import org.example.ejercicio3.modelo.Estudiante;
import org.example.ejercicio3.modelo.Inscripcion;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Actividad implements Serializable {
    private int  id;
    protected String titulo;
    private int cupoMaximo;
    public static int CUPO_MINIMO;
    public List<Inscripcion> inscripciones = new ArrayList<>();

    public Actividad(int id, String titulo, int cupoMaximo) {
        this.id = id;
        this.titulo = titulo;
        this.cupoMaximo = cupoMaximo;
    }

    public Inscripcion inscribir(Estudiante estudiante) throws CupoExcedidoException {
        if (cupoMaximo == inscripciones.size()) {
            throw new CupoExcedidoException("No hay cupos");
        }
        Inscripcion inscripcion = new Inscripcion(  LocalDate.now(), "inscripto" , estudiante);
        inscripciones.add( inscripcion );
        return inscripcion;
    }

    public void mostrarInscripciones() {
        for (Inscripcion inscri : inscripciones ) {

            System.out.println("El estudiante "+ inscri.getEstudiante().getNombre() + " " +inscri.getEstado()+ " en la fecha " + inscri.getFecha() + " en la actividad de " + this.titulo);
        }

    }

    public String getTitulo() {
        return titulo;
    }

    public final void mostrarIdentificación() {
        System.out.println("ID: " + this.id);
    }

    public double calcularCostoMateriales(){
        return 0.0;
    }

    public String getTipo(){
        return null;
    }


}
