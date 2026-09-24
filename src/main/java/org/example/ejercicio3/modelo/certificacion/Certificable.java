package org.example.ejercicio3.modelo.certificacion;

import org.example.ejercicio3.modelo.Estudiante;

public interface Certificable {

     String ENTIDAD_EMISORA = "UTN";


     String generarCertificado( Estudiante estudiante );


}
