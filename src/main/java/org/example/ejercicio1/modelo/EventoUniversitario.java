package org.example.ejercicio1.modelo;

import org.example.ejercicio1.modelo.actividades.Charla;
import org.example.ejercicio1.modelo.actividades.Taller;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EventoUniversitario implements Serializable {
    private String id;
    private String titulo;
    private double costoBase;
    private boolean gratuito;
    private static int cantidadEventos;


    private Sala sala;

    public EventoUniversitario() {
    }

    public EventoUniversitario(String id) {
        this.id = id;
    }

    public EventoUniversitario(String id, String titulo, double costoBase, boolean gratuito) {
        this.id = id;
        this.titulo = titulo;
        this.costoBase = costoBase;
        this.gratuito = gratuito;
        cantidadEventos++;
    }
    public EventoUniversitario(EventoUniversitario obj){
        this.id = obj.id;
        this.titulo = obj.titulo;
        this.costoBase = obj.costoBase;
        this.gratuito = obj.gratuito;
        cantidadEventos++;
    }
    public double calcularCostoEstimado(){
        double total = costoBase;
        if(gratuito) {
            return 0.0;
        }

        for (Taller ta: talleres){
            total += ta.calcularCostoMateriales();
        }
        return total * 1.21;

    }


    public void asignarSala(Sala sala){
        this.sala = sala;
        System.out.println("El evento de " + this.titulo + " tiene asignado el " + sala.getNombre());
    }
    public void mostrarDatos(){
        System.out.println("ID: " + this.id);
        System.out.println(this.titulo);
        System.out.println("Costo " + this.costoBase);
        if (gratuito){
            System.out.println("Es gratis.");
        } else {
            System.out.println("No es gratis.");
        }
        System.out.println("Sala: " + this.sala.getNombre());

        System.out.println("Talleres:");

        for ( Taller ta: talleres) {

            System.out.println(ta.getTitulo());
            ta.mostrarIdentificación();
            System.out.println("--------");

        }

        System.out.println("Charlas:");
        for ( Charla cha: charlas) {

            System.out.println(cha.getTitulo());
            cha.mostrarIdentificación();
            System.out.println("--------");
        }


    }

    public static int getCantidadEventos() {
        return cantidadEventos;
    }


    public List<Taller> talleres = new ArrayList<>();
    public List<Charla> charlas = new ArrayList<>();

    public void crearActividad(int idAct, String tituloAct, int cupo, String tipoAct, boolean reqNot, String diser){
        if (tipoAct.equalsIgnoreCase("Taller")) {
            Taller taller = new Taller(idAct, tituloAct, cupo, reqNot );
            talleres.add(taller);
        }
        else if (tipoAct.equalsIgnoreCase("Charla")) {
            Charla charla = new Charla(idAct, tituloAct, cupo, diser  );
            charlas.add(charla);
        }

    }

    public void persistirEvento (){
        try {
            FileOutputStream fos = new FileOutputStream( titulo + ".dat" );
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(this);
            oos.close();
            fos.close();

        } catch (IOException e) {
            System.out.println("Error al guardar los datos");;
        }

    }

    public static EventoUniversitario recuperarEvento(String titulo){
        try {
            FileInputStream fis = new FileInputStream( titulo + ".dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            EventoUniversitario eventito = (EventoUniversitario) ois.readObject();
            return eventito;

            //o return (EventoUniversitario) ois.readObject();

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        } catch (ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }


    }

}

