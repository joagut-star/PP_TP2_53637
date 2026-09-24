package org.example.ejercicio4.modelo.certificacion;

import org.example.ejercicio4.modelo.Estudiante;

public interface Certificable {

     String ENTIDAD_EMISORA = "UTN";


     String generarCertificado( Estudiante estudiante );


}
