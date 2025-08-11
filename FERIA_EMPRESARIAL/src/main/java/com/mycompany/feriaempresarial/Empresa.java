package com.mycompany.feriaempresarial;

/**
 * La clase Empresa representa una empresa participante en la feria empresarial.
 * Contiene información básica como nombre, sector y correo electrónico de contacto.
 * 
 * @author Laura
 */
public class Empresa {
    private String NOMBRE;
    private String SECTOR;
    private String CORREO_ELECTRONICO;

    /**
     * Constructor para crear una Empresa con nombre, sector y correo electrónico.
     * 
     * @param NOMBRE Nombre de la empresa.
     * @param SECTOR Sector o industria a la que pertenece la empresa.
     * @param CORREO_ELECTRONICO Correo electrónico de contacto de la empresa.
     */
    public Empresa(String NOMBRE, String SECTOR, String CORREO_ELECTRONICO) {
        this.NOMBRE = NOMBRE;
        this.SECTOR = SECTOR;
        this.CORREO_ELECTRONICO = CORREO_ELECTRONICO;
    }

    /**
     * @return El nombre de la empresa.
     */
    public String getNOMBRE() {
        return NOMBRE;
    }

    /**
     * Establece el nombre de la empresa.
     * 
     * @param NOMBRE Nuevo nombre de la empresa.
     */
    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    /**
     * @return El sector al que pertenece la empresa.
     */
    public String getSECTOR() {
        return SECTOR;
    }

    /**
     * Establece el sector de la empresa.
     * 
     * @param SECTOR Nuevo sector de la empresa.
     */
    public void setSECTOR(String SECTOR) {
        this.SECTOR = SECTOR;
    }

    /**
     * @return El correo electrónico de contacto de la empresa.
     */
    public String getCORREO_ELECTRONICO() {
        return CORREO_ELECTRONICO;
    }

    /**
     * Establece el correo electrónico de contacto de la empresa.
     * 
     * @param CORREO_ELECTRONICO Nuevo correo electrónico de contacto.
     */
    public void setCORREO_ELECTRONICO(String CORREO_ELECTRONICO) {
        this.CORREO_ELECTRONICO = CORREO_ELECTRONICO;
    }

    // Métodos comentados para futuras implementaciones
    /*
    public String REGISTRAR() {
        // TODO - implementar registro de la empresa
        throw new UnsupportedOperationException();
    }

    public String MOSTRAR_PRODUCTOS() {
        // TODO - implementar mostrar productos de la empresa
        throw new UnsupportedOperationException();
    }

    public String RESPONDER_CONSULTAS() {
        // TODO - implementar respuesta a consultas de clientes
        throw new UnsupportedOperationException();
    }

    public String EVALUAR_RESULTADO() {
        // TODO - implementar evaluación de resultados post-feria
        throw new UnsupportedOperationException();
    }
    */
}