package org.example.ejercicio4;


import org.example.ejercicio4.excepciones.CupoExcedidoException;
import org.example.ejercicio4.hilos.EnvioTicketsThread;
import org.example.ejercicio4.modelo.Estudiante;
import org.example.ejercicio4.modelo.EventoUniversitario;
import org.example.ejercicio4.modelo.Sala;
import org.example.ejercicio4.modelo.actividades.Actividad;
import org.example.ejercicio4.modelo.actividades.Charla;
import org.example.ejercicio4.modelo.actividades.Curso;
import org.example.ejercicio4.modelo.actividades.Taller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class App {


    public static void main(String[] args){

        Estudiante Fran = new Estudiante( "Francisco", "67677");
        Estudiante Tizi = new Estudiante("Tiziano", "67676");
        Estudiante Valen = new Estudiante("Valentin", "67678");

        EventoUniversitario evento1 = new EventoUniversitario("93585", "Hackathon", 45000.00, false );

        Sala sala1 = new Sala( 7678 ,"Auditorio" );

        evento1.crearActividad( 2323, "La IA en la actualidad", 67, "Charla", false, "Santiago Perez", 0);
        evento1.crearActividad(4556, "Aprende a aprender", 67 ,"Taller", true, "Marina", 0);
        evento1.crearActividad(6323, "Programacion avanzada", 67, "Curso", false, null, 4);
        evento1.crearActividad(7234, "Educacion financiera", 6, "Charla", false, "Lucas", 0);


        evento1.asignarSala( sala1 );



        List<Taller> talleres = new ArrayList();
                talleres= evento1.filtrarActividadesPorTipo(Taller.class);
        List<Charla> charlas = new ArrayList();
                charlas= evento1.filtrarActividadesPorTipo(Charla.class);
        List<Curso> cursos = new ArrayList();
                cursos = evento1.filtrarActividadesPorTipo(Curso.class);


        try {
            talleres.get(0).inscribir(Fran);
            charlas.get(0).inscribir(Tizi);
            cursos.get(0).inscribir(Valen);
            cursos.get(0).inscribir(Fran);
            cursos.get(0).inscribir(Tizi);


        } catch (CupoExcedidoException e) {
            System.out.println( "Error: " + e.getMessage() );
        }

        EnvioTicketsThread hilo = new EnvioTicketsThread(evento1);
        hilo.setDaemon(true);
        hilo.start();



        System.out.println("La cantidad de talleres es de " +  talleres.size());
        System.out.println("La cantidad de charlas es de " +  charlas.size());
        System.out.println("La cantidad de cursos es de " +  cursos.size());

        System.out.println(evento1.calcularCostoMateriales(evento1.actividades));


        System.out.println("Ingrese el tipo de actividad del que desea saber cuales hay");
        Scanner sc = new Scanner(System.in);
        String claseaelegir = sc.nextLine();
        int cc =  0;

        for ( Actividad act: evento1.actividades ) {
            if ( claseaelegir.equals( act.getTipo() ) ) {
            System.out.println( act.getTitulo());
            cc++;
            }

        }
        if ( cc == 0 ) {
            System.out.println("Nombre de actividad no valido");
        }




//        try {
//            evento1.charlas.get(0).inscribir(Fran);
//            evento1.cursos.get(0).inscribir(Tizi);
////            evento1.talleres.get(0).inscribir(Valen);
//            evento1.talleres.get(0).inscribir(Fran);
//
//        } catch (CupoExcedidoException e) {
//            System.out.println("Error: " + e.getMessage());;
//        }


//
//        for ( Curso cur: evento1.cursos ) {
//            for ( Inscripcion inscri: cur.inscripciones) {
//                System.out.println(cur.generarCertificado(inscri.getEstudiante()));
//
//
//            }
//        }
//        for ( Taller ta: evento1.talleres ) {
//            for ( Inscripcion inscri: ta.inscripciones) {
//                System.out.println(ta.generarCertificado(inscri.getEstudiante()));
//
//            }
//        }

//        System.out.println("La cantidad de eventos es " + EventoUniversitario.getCantidadEventos());

//        EventoUniversitario eventorecup= new EventoUniversitario();
//        try {
//            evento1.persistirEvento();
//            eventorecup = EventoUniversitario.recuperarEvento( "Hackathon" );
//
//        } catch (Exception e) {
//            System.out.println("Error: " + e.getMessage());
//        } finally {
//            eventorecup.mostrarDatos();
//        }
//





    }

}