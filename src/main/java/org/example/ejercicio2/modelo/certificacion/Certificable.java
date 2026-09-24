package org.example.ejercicio2.modelo.certificacion;

import org.example.ejercicio2.modelo.Estudiante;

public interface Certificable {

     String ENTIDAD_EMISORA = "UTN";


     String generarCertificado( Estudiante estudiante );


}
