package com.mycompany.feriaempresarial;

import java.util.ArrayList;

/**
 * Clase que gestiona la lista de visitantes de la feria empresarial.
 * Permite registrar, mostrar, editar y eliminar visitantes.
 * 
 * @author Laura
 */
public class Gestor_Visitantes {

    private ArrayList<Visitante> visitantes = new ArrayList<>();

    /**
     * Registra un nuevo visitante en la lista.
     * 
     * @param visitante Objeto de tipo Visitante a registrar.
     */
    public void registrarVisitante(Visitante visitante) {
        visitantes.add(visitante);
        System.out.println("VISITANTE REGISTRADO CORRECTAMENTE.");
    }

    /**
     * Muestra todos los visitantes registrados por consola.
     */
    public void mostrarVisitantes() {
        for (Visitante v : visitantes) {
            System.out.println("NOMBRE: " + v.getNOMBRE());
            System.out.println("ID: " + v.getIDENTIFICACION());
            System.out.println("CORREO: " + v.getCORREO_ELECTRONICO());
            System.out.println("-----------------------");
        }
    }

    /**
     * Elimina un visitante de la lista según su identificación.
     * 
     * @param identificacion Número de identificación del visitante a eliminar.
     */
    public void eliminarVisitante(int identificacion) {
        visitantes.removeIf(v -> v.getIDENTIFICACION() == identificacion);
        System.out.println("VISITANTE ELIMINADO.");
    }

    /**
     * Edita el nombre y correo electrónico de un visitante específico.
     * 
     * @param identificacion Identificación del visitante a editar.
     * @param nuevoNombre Nuevo nombre que se desea asignar.
     * @param nuevoCorreo Nuevo correo electrónico que se desea asignar.
     */
    public void editarVisitante(int identificacion, String nuevoNombre, String nuevoCorreo) {
        for (Visitante v : visitantes) {
            if (v.getIDENTIFICACION() == identificacion) {
                v.setNOMBRE(nuevoNombre);
                v.setCORREO_ELECTRONICO(nuevoCorreo);
                System.out.println("VISITANTE EDITADO CORRECTAMENTE");
                return;
            }
        }
        System.out.println("VISITANTE NO ENCONTRADO");
    }
}