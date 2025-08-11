package com.mycompany.feriaempresarial;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * La clase Comentario representa la valoración que un visitante deja sobre un Stand.
 * Incluye el nombre del visitante, la fecha, la calificación y el comentario.
 * 
 * @author Laura
 */
public class Comentario {

    private String NOMBRE_VISITANTE;
    private String FECHA;
    private int CALIFICACION;
    private String COMENTARIO;

    /**
     * Crea un comentario con nombre de visitante, calificación y comentario.
     * La fecha se asigna automáticamente con la fecha actual del sistema.
     * 
     * @param nombreVisitante Nombre del visitante que realiza el comentario.
     * @param calificacion Calificación dada al stand (de 1 a 5).
     * @param comentario Texto del comentario realizado por el visitante.
     */
    public Comentario(String nombreVisitante, int calificacion, String comentario) {
        this.NOMBRE_VISITANTE = nombreVisitante;
        this.CALIFICACION = calificacion;
        this.COMENTARIO = comentario;
        this.FECHA = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")); // corregido
    }

    /**
     * @return Nombre del visitante que dejó el comentario.
     */
    public String getNOMBRE_VISITANTE() {
        return NOMBRE_VISITANTE;
    }

    /**
     * @param NOMBRE_VISITANTE Nuevo nombre del visitante.
     */
    public void setNOMBRE_VISITANTE(String NOMBRE_VISITANTE) {
        this.NOMBRE_VISITANTE = NOMBRE_VISITANTE;
    }

    /**
     * @return Fecha en la que se realizó el comentario.
     */
    public String getFECHA() {
        return FECHA;
    }

    /**
     * @param FECHA Nueva fecha del comentario.
     */
    public void setFECHA(String FECHA) {
        this.FECHA = FECHA;
    }

    /**
     * @return Calificación dada por el visitante.
     */
    public int getCALIFICACION() {
        return CALIFICACION;
    }

    /**
     * @param CALIFICACION Nueva calificación del comentario.
     */
    public void setCALIFICACION(int CALIFICACION) {
        this.CALIFICACION = CALIFICACION;
    }

    /**
     * @return Texto del comentario.
     */
    public String getCOMENTARIO() {
        return COMENTARIO;
    }

    /**
     * @param COMENTARIO Nuevo texto del comentario.
     */
    public void setCOMENTARIO(String COMENTARIO) {
        this.COMENTARIO = COMENTARIO;
    }

    /**
     * Muestra en consola los detalles del comentario, incluyendo nombre, fecha,
     * calificación y contenido.
     */
    public void VISIBILIZAR() {
        System.out.println("VISITANTE: " + NOMBRE_VISITANTE);
        System.out.println("FECHA: " + FECHA);
        System.out.println("CALIFICACION: " + CALIFICACION + " ESTRELLAS");
        System.out.println("COMENTARIO: " + COMENTARIO);
        System.out.println("-----------------");
    }

    /**
     * Devuelve la calificación para fines estadísticos.
     * 
     * @return Calificación dada por el visitante.
     */
    public int OBTENER_ESTADISTICA() {
        return CALIFICACION;
    }

    /**
     * Asigna y retorna la calificación del comentario.
     * 
     * @return Calificación dada por el visitante.
     */
    public int ASIGNAR_CALIFICACION() {
        return CALIFICACION;
    }

    /**
     * Retorna un mensaje indicando que el comentario está vinculado al visitante.
     * 
     * @return Mensaje de vinculación con el visitante.
     */
    public String VINCULAR() {
        return "COMENTARIO VINCULADO AL VISITANTE: " + NOMBRE_VISITANTE;
    }
}