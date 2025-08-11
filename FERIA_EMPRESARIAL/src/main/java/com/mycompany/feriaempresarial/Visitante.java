package com.mycompany.feriaempresarial;

/**
 * Representa un visitante de la feria empresarial.
 * Contiene información básica como nombre, identificación y correo electrónico.
 * 
 * @author Laura
 */
public class Visitante {

    private String NOMBRE;
    private int IDENTIFICACION;
    private String CORREO_ELECTRONICO;

    /**
     * Constructor que crea un visitante con nombre, identificación y correo electrónico.
     * 
     * @param NOMBRE Nombre completo del visitante.
     * @param IDENTIFICACION Número de identificación del visitante.
     * @param CORREO_ELECTRONICO Correo electrónico del visitante.
     */
    public Visitante(String NOMBRE, int IDENTIFICACION, String CORREO_ELECTRONICO) {
        this.NOMBRE = NOMBRE;
        this.IDENTIFICACION = IDENTIFICACION;
        this.CORREO_ELECTRONICO = CORREO_ELECTRONICO;
    }

    /**
     * Obtiene el nombre del visitante.
     * 
     * @return El nombre completo del visitante.
     */
    public String getNOMBRE() {
        return NOMBRE;
    }

    /**
     * Establece un nuevo nombre para el visitante.
     * 
     * @param NOMBRE Nuevo nombre completo del visitante.
     */
    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    /**
     * Obtiene la identificación del visitante.
     * 
     * @return El número de identificación del visitante.
     */
    public int getIDENTIFICACION() {
        return IDENTIFICACION;
    }

    /**
     * Establece un nuevo número de identificación para el visitante.
     * 
     * @param IDENTIFICACION Nuevo número de identificación.
     */
    public void setIDENTIFICACION(int IDENTIFICACION) {
        this.IDENTIFICACION = IDENTIFICACION;
    }

    /**
     * Obtiene el correo electrónico del visitante.
     * 
     * @return Correo electrónico del visitante.
     */
    public String getCORREO_ELECTRONICO() {
        return CORREO_ELECTRONICO;
    }

    /**
     * Establece un nuevo correo electrónico para el visitante.
     * 
     * @param CORREO_ELECTRONICO Nuevo correo electrónico.
     */
    public void setCORREO_ELECTRONICO(String CORREO_ELECTRONICO) {
        this.CORREO_ELECTRONICO = CORREO_ELECTRONICO;
    }
}