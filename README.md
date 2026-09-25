Trabajo Práctico 2 - Paradigmas de Programación

UTN - Facultad Regional Mendoza (FRM)

Este repositorio contiene el código fuente del TP2 de Paradigmas de Programación. Se trata de un sistema de gestión de Eventos Universitarios desarrollado en Java bajo el paradigma Orientado a Objetos.

Temas Implementados

El proyecto da solución a los 4 ejercicios planteados en las especificaciones, incorporando:

Excepciones y Persistencia (Ej 1): Manejo de errores personalizados (CupoExcedidoException) y almacenamiento de eventos en archivos mediante serialización.

Interfaces y Polimorfismo (Ej 2): Uso de la interfaz Certificable para emitir certificados solo en actividades válidas (Talleres y Cursos).

Genéricos y Wildcards (Ej 3): Filtrado de actividades y cálculo de costos utilizando métodos parametrizados (<T extends Actividad>) y wildcards (<? extends Actividad>).

Concurrencia y Clases Anidadas (Ej 4): Modelado de TicketDeAcceso como clase interna de Inscripcion y uso de hilos (EnvioTicketsThread) para el envío concurrente de tickets.

Ejecución

El proyecto está diseñado para importarse en IntelliJ IDEA.
El punto de entrada es la clase App.java, donde se ejecutan los flujos principales (exitosos y con fallos controlados) comprobables por consola.

Alumno: Joaquin Gutierrez
Legajo: 53637
