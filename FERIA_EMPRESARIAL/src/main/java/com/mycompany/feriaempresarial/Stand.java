package com.mycompany.feriaempresarial;

import java.util.ArrayList;

/**
 * La clase Stand representa un espacio asignado dentro de la feria empresarial.
 * Contiene información sobre el número único, ubicación, tamaño, estado de ocupación,
 * la empresa asignada y los comentarios recibidos.
 * 
 * @author Laura
 */
public class Stand {

    private int NUMERO_UNICO;
    private String UBICACION;
    private String TAMANO;
    private boolean ocupado = false;
    private Empresa empresaAsignada = null;

    private ArrayList<Comentario> comentarios = new ArrayList<>();

    /**
     * Constructor para crear un Stand con número único, ubicación y tamaño.
     * 
     * @param numeroUnico Número único identificador del stand.
     * @param ubicacion Ubicación del stand dentro de la feria.
     * @param tamano Tamaño del stand (ejemplo: pequeño, mediano, grande).
     */
    public Stand(int numeroUnico, String ubicacion, String tamano) {
        this.NUMERO_UNICO = numeroUnico;
        this.UBICACION = ubicacion;
        this.TAMANO = tamano;
    }

    /**
     * @return El número único del stand.
     */
    public int getNUMERO_UNICO() {
        return NUMERO_UNICO;
    }

    /**
     * Establece un nuevo número único para el stand.
     * 
     * @param NUMERO_UNICO Nuevo número único del stand.
     */
    public void setNUMERO_UNICO(int NUMERO_UNICO) {
        this.NUMERO_UNICO = NUMERO_UNICO;
    }

    /**
     * @return La ubicación del stand.
     */
    public String getUBICACION() {
        return UBICACION;
    }

    /**
     * Establece la ubicación del stand.
     * 
     * @param UBICACION Nueva ubicación del stand.
     */
    public void setUBICACION(String UBICACION) {
        this.UBICACION = UBICACION;
    }

    /**
     * @return El tamaño del stand.
     */
    public String getTAMANO() {
        return TAMANO;
    }

    /**
     * Establece el tamaño del stand.
     * 
     * @param TAMANO Nuevo tamaño del stand.
     */
    public void setTAMANO(String TAMANO) {
        this.TAMANO = TAMANO;
    }

    /**
     * @return True si el stand está ocupado, false si está disponible.
     */
    public boolean isOcupado() {
        return ocupado;
    }

    /**
     * @return La empresa asignada al stand, o null si está disponible.
     */
    public Empresa getEmpresaAsignada() {
        return empresaAsignada;
    }

    /**
     * Asigna una empresa al stand y cambia el estado a ocupado.
     * 
     * @param empresa Empresa que se asigna al stand.
     */
    public void asignarEmpresa(Empresa empresa) {
        this.empresaAsignada = empresa;
        this.ocupado = true;
    }

    /**
     * Libera el stand, eliminando la empresa asignada y marcándolo como disponible.
     */
    public void liberarStand() {
        this.empresaAsignada = null;
        this.ocupado = false;
    }

    /**
     * Muestra por consola la información del stand, incluyendo estado y empresa asignada.
     */
    public void mostrarInformacion() {
        System.out.println("NUMERO UNICO: " + NUMERO_UNICO);
        System.out.println("UBICACION: " + UBICACION);
        System.out.println("TAMAÑO: " + TAMANO);
        if (ocupado && empresaAsignada != null) {
            System.out.println("ESTADO: OCUPADO POR " + empresaAsignada.getNOMBRE());
        } else {
            System.out.println("ESTADO: DISPONIBLE");
        }
        System.out.println("------------");
    }

    /**
     * Agrega un comentario a la lista de comentarios del stand.
     * 
     * @param comentario Comentario que se agrega al stand.
     */
    public void agregarComentario(Comentario comentario) {
        comentarios.add(comentario);
    }

    /**
     * Muestra por consola todos los comentarios asociados al stand.
     * Si no hay comentarios, indica que el stand no tiene comentarios.
     */
    public void mostrarComentarios() {
        if (comentarios.isEmpty()) {
            System.out.println("STAND SIN COMENTARIOS.");
        } else {
            System.out.println("COMENTARIOS DEL STAND: " + NUMERO_UNICO + ":");
            for (Comentario c : comentarios) {
                c.VISIBILIZAR();
            }
        }
    }

    /**
     * @return La lista de comentarios del stand.
     */
    public ArrayList<Comentario> getComentarios() {
        return comentarios;
    }

    // Métodos comentados para futuras implementaciones
    /*
    public String REGISTRAR() {
        // TODO - implementar registro del stand
        throw new UnsupportedOperationException();
    }

    public String ADORNAR() {
        // TODO - implementar decoración del stand
        throw new UnsupportedOperationException();
    }

    public String MOSTRAR_PRODUCTOS() {
        // TODO - implementar mostrar productos del stand
        throw new UnsupportedOperationException();
    }

    public String ASIGNAR_REPRESENTANTE() {
        // TODO - implementar asignación de representante al stand
        throw new UnsupportedOperationException();
    }
    */
}