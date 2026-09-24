package org.example.ejercicio2;


import org.example.ejercicio2.excepciones.CupoExcedidoException;
import org.example.ejercicio2.modelo.Estudiante;
import org.example.ejercicio2.modelo.EventoUniversitario;
import org.example.ejercicio2.modelo.Inscripcion;
import org.example.ejercicio2.modelo.Sala;
import org.example.ejercicio2.modelo.actividades.Curso;
import org.example.ejercicio2.modelo.actividades.Taller;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class App {


    public static void main(String[] args){

        Estudiante Fran = new Estudiante( "Francisco", "67677");
        Estudiante Tizi = new Estudiante("Tiziano", "67676");
        Estudiante Valen = new Estudiante("Valentin", "67678");

        EventoUniversitario evento1 = new EventoUniversitario("93585", "Hackathon", 45000.00, false );

        Sala sala1 = new Sala( 7678 ,"Auditorio" );

        evento1.crearActividad( 2323, "La IA en la actualidad", 1, "Charla", false, "Santiago Perez", 0);
        evento1.crearActividad(4556, "Aprende a aprender", 1, "Taller", true, "Marina", 0);
        evento1.crearActividad(6323, "Programacion avanzada", 1, "Curso", false, null, 4);

        evento1.asignarSala( sala1 );

        try {
            evento1.charlas.get(0).inscribir(Fran);
            evento1.cursos.get(0).inscribir(Tizi);
//            evento1.talleres.get(0).inscribir(Valen);
            evento1.talleres.get(0).inscribir(Fran);

        } catch (CupoExcedidoException e) {
            System.out.println("Error: " + e.getMessage());;
        }



        for ( Curso cur: evento1.cursos ) {
            for ( Inscripcion inscri: cur.inscripciones) {
                System.out.println(cur.generarCertificado(inscri.getEstudiante()));


            }
        }
        for ( Taller ta: evento1.talleres ) {
            for ( Inscripcion inscri: ta.inscripciones) {
                System.out.println(ta.generarCertificado(inscri.getEstudiante()));

            }
        }

//        System.out.println("La cantidad de eventos es " + EventoUniversitario.getCantidadEventos());

        EventoUniversitario eventorecup= new EventoUniversitario();
        try {
            evento1.persistirEvento();
            eventorecup = EventoUniversitario.recuperarEvento( "Hackathon" );

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            eventorecup.mostrarDatos();
        }





    }

}