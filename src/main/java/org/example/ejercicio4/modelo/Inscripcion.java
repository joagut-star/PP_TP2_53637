package org.example.ejercicio4.modelo;

import java.io.Serializable;
import java.time.LocalDate;

public class Inscripcion implements Serializable {

    public static class ticketDeAcceso{
        private String idTicket;
        private LocalDate fechaEminsion;

        public String getIdTicket() {
            return idTicket;
        }

        public ticketDeAcceso(String idTicket, LocalDate fechaEminsion) {
            this.idTicket = idTicket;
            this.fechaEminsion = fechaEminsion;
        }


        public void enviarTicket(String idTicket) {
            System.out.println("Ticket enviado "+idTicket);
        }
    };

    private LocalDate fecha;
    private String estado;
    private Estudiante estudiante;
    private ticketDeAcceso ticket;

    public ticketDeAcceso getTicket() {
        return ticket;
    }

    @Override
    public String toString() {
        return "Inscripcion{" +
                "fecha=" + fecha +
                ", estado='" + estado + '\'' +
                ", estudiante=" + estudiante +
                '}';
    }

    public Inscripcion() {
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public Inscripcion(LocalDate fecha, String estado, Estudiante estudiante, ticketDeAcceso ticket) {
        this.fecha = fecha;
        this.estado = estado;
        this.estudiante = estudiante;
        this.ticket = ticket;
    }

    public Inscripcion(LocalDate fecha, String estado, Estudiante estudiante) {
        this.fecha = fecha;
        this.estado = estado;
        this.estudiante = estudiante;
    }

    public Inscripcion(String estado, LocalDate fecha) {
        this.estado = estado;
        this.fecha = fecha;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }



}
