package org.example.ejercicio4.hilos;

import org.example.ejercicio4.modelo.EventoUniversitario;
import org.example.ejercicio4.modelo.Inscripcion;
import org.example.ejercicio4.modelo.actividades.Actividad;

import java.beans.beancontext.BeanContextChild;

public class EnvioTicketsThread extends Thread {

    public EventoUniversitario evento;

    public EnvioTicketsThread(EventoUniversitario evento) {
        this.evento = evento;
    }

    @Override
    public void run() {
        System.out.println("Iniciando thread");

        while (true) {
            for (Actividad act : evento.actividades) {
                System.out.println("Actividad: " + act);
                for (Inscripcion inscri : act.inscripciones) {
                    System.out.println("Inscripcion: " + inscri);
                    inscri.getTicket().enviarTicket(inscri.getTicket().getIdTicket());
                }
            }
            ;
            try {
                Thread.sleep(6700);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }


    }
}
