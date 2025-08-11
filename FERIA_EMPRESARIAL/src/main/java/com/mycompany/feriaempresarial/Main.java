/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.feriaempresarial;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * Clase principal que ejecuta la aplicación de la Feria Empresarial.
 * Ofrece un menú de opciones para gestionar empresas, stands, visitantes y generar reportes.
 * 
 * Permite:
 * - Registrar y editar empresas
 * - Asignar y liberar stands
 * - Registrar visitantes y dejar comentarios en stands
 * - Generar reportes de participación y actividad
 * 
 * @author laura
 */
public class Main {

    /**
     * Método principal que inicia la ejecución del programa.
     * Muestra el menú principal y redirige a los submenús de gestión según la opción seleccionada.
     * 
     * @param args Argumentos de línea de comandos (no utilizados).
     */    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Empresa> empresas = new ArrayList<>();
        ArrayList<Stand> stands = new ArrayList<>();
        ArrayList<Visitante> visitantes = new ArrayList<>();
        
        boolean salir = false;

        while (!salir) { 
            System.out.println("\n--- MENU PRINCIPAL ---");
            System.out.println("1. MENU EMPRESAS");
            System.out.println("2. MENU STANDS");
            System.out.println("3. MENU VISITANTES");
            System.out.println("4. REPORTES");
            System.out.println("5. SALIR");
            System.out.println("SELECCIONAR UNA OPCION");
            
            int opcion = Integer.parseInt(sc.nextLine());
            
            switch (opcion) {
                case 1: 
                    menuEmpresas(sc,empresas);
                    break;
                case 2:
                    menuStands(sc,stands,empresas);
                    break;
                case 3:
                    menuVisitantes(sc,visitantes,stands);
                    break;
                case 4:
                    menuReportes(stands, visitantes);
                    break;
                case 5:
                    salir = true;
                    System.out.println("SALIENDO DEL PROGRAMA, ¡HASTA PRONTO!");
                    break;
                default:
                    System.out.println("OPCION NO VALIDA, INTENTE DE NUEVO");
                    
            }
        }
        sc.close();
    }

//----------------------- MENU EMPRESAS ---------------------------------------    
    /**
     * Muestra el submenú para gestionar empresas.
     * Permite registrar, mostrar, editar y eliminar empresas.
     *
     * @param sc Scanner para entrada de datos del usuario.
     * @param empresas Lista de empresas registradas en la feria.
     */
    public static void menuEmpresas(Scanner sc, ArrayList<Empresa> empresas) {
        boolean salir = false;
        while (!salir){
            System.out.println("\n--MENU EMPRESAS--");
            System.out.println("1. REGISTRAR EMPRESA");
            System.out.println("2. MOSTRAR EMPRESAS");
            System.out.println("3. EDITAR EMPRESA");
            System.out.println("4. ELIMINAR EMPRESA");
            System.out.println("5. SALIR");
            System.out.println("SELECCIONE UNA OPCION");
            
            int opcion = Integer.parseInt(sc.nextLine());
            
            switch (opcion) {
                case 1: 
                    System.out.println("INGRESE EL NOMBRE DE LA EMPRESA:");
                    String nombre = sc.nextLine();
                    
                    System.out.println("INGRESE EL SECTOR (EJ: TECNOLOGIA, SALUD, EDUCACION)");
                    String sector = sc.nextLine();
                    
                    System.out.println("INGRESE EL CORREO ELECTRONICO");
                    String correo = sc.nextLine();
                    
                    empresas.add(new Empresa(nombre, sector, correo));
                    System.out.println("EMPRESA REGISTRADA CORRECTAMENTE");
                    break;
                
                case 2:
                    if (empresas.isEmpty()) {
                        System.out.println("NO HAY EMPRESAS REGISTRADAS");
                    }else{
                        System.out.println("EMPRESAS REGISTRADAS");
                        for(Empresa e: empresas) {
                            System.out.println("NOMBRE" + e.getNOMBRE());
                            System.out.println("SECTOR" + e.getSECTOR());
                            System.out.println("CORREO ELECTRONICO" + e.getCORREO_ELECTRONICO());
                            System.out.println("-----------------");
                        }
                    }
                    break;
                    
                case 3:
                    if (empresas.isEmpty()) {
                        System.out.println("NO HAY EMPRESAS PARA EDITAR.");
                        break;
                    }
                    System.out.println("INGRESE EL NOMBRE DE LA EMPRESA A EDITAR:");
                    String nombreEditar = sc.nextLine();
                    Empresa empresaEditar = null;
                    
                    for (Empresa e: empresas) {
                        if (e.getNOMBRE().equalsIgnoreCase(nombreEditar)) {
                            empresaEditar = e;
                            break;
                        }
                    }
                    
                    if (empresaEditar!= null) {
                        System.out.println("INGRESE EL NUEVO SECTOR:");
                        String nuevoSector = sc.nextLine();
                        System.out.println("INGRESE EL NUEVO CORREO ELECTRONICO:");
                        String nuevoCorreo = sc.nextLine();

                        empresaEditar.setSECTOR(nuevoSector);
                        empresaEditar.setCORREO_ELECTRONICO(nuevoCorreo);
                        System.out.println("EMPRESA EDITADA CORRECTAMENTE.");
                    }else{
                        System.out.println("NO SE ENCONTRO UNA EMPRESA CON ESE NOMBRE.");
                    }
                    break;

                case 4:
                    if (empresas.isEmpty()) {
                        System.out.println("NO HAY EMPRESAS PARA ELIMINAR.");
                        break;
                    }
                    System.out.println("INGRESE EL NOMBRE DE LA EMPRESA A ELIMINAR:");
                    String nombreEliminar = sc.nextLine();
                    boolean eliminada = empresas.removeIf(e -> e.getNOMBRE().equalsIgnoreCase(nombreEliminar));

                    if (eliminada) {
                        System.out.println("EMPRESA ELIMINADA.");
                    } else {
                        System.out.println("NO SE ENCONTRO UNA EMPRESA CON ESE NOMBRE.");
                    }
                    break;

                case 5:
                    salir = true;
                    break;

                    default:
                    System.out.println("OPCIÓN NO VÁLIDA, INTENTE DE NUEVO.");
        }
    }
}

//---------------------------MENU STANDS ---------------------------------------
    /**
     * Muestra el submenú para gestionar stands.
     * Permite registrar stands, asignarlos a empresas y ver su estado (ocupado o disponible).
     *
     * @param sc Scanner para entrada de datos del usuario.
     * @param stands Lista de stands registrados.
     * @param empresas Lista de empresas disponibles para asignar stands.
     */  
    public static void menuStands(Scanner sc,ArrayList<Stand>stands,ArrayList<Empresa> empresas) {
        boolean salir = false;
        while (!salir) {
            System.out.println("\n--MENU STANDS--");
            System.out.println("1. REGISTRAR STAND");
            System.out.println("2. ASIGNAR STAND A EMPRESA");
            System.out.println("3. MOSTRAR STANDS DISPONIBLES");
            System.out.println("4. MOSTRAR STANDS OCUPADOS");
            System.out.println("5. SALIR");
            System.out.println("SELECCIONE UNA OPCION:");
        
            int opcion = Integer.parseInt(sc.nextLine());
            
            switch (opcion) {
                case 1:
                    System.out.println("NUMERO UNICO DEL STAND:");
                    int numero = Integer.parseInt(sc.nextLine());
                    System.out.println("UBICACION:");
                    String ubicacion = sc.nextLine();
                    System.out.println("TAMAÑO (PEQUEÑO, MEDIANO, GRANDE):");
                    String tamano = sc.nextLine();
                    
                    stands.add(new Stand(numero,ubicacion,tamano));
                    System.out.println("STAND REGISTRADO.");
                    break;
                    
                case 2:
                    if (stands.isEmpty()||empresas.isEmpty()) {
                        System.out.println("NO HAY STANDS O EMPRESAS DISPONIBLES.");
                        break;
                    }
                    
                    System.out.println("NOMBRE DE LA EMPRESA A ASIGNAR");
                    String nombreEmpresa = sc.nextLine();
                    Empresa empresa = null;
                    for (Empresa e: empresas) {
                        if (e.getNOMBRE().equalsIgnoreCase(nombreEmpresa)) {
                            empresa =e;
                            break;
                        }
                    }
                    
                    if (empresa ==null) {
                        System.out.println("EMPRESA NO ENCONTRADA.");
                        break;
                    }
                    
                    System.out.println("STANDS DISPONIBLES:");
                    for (Stand s: stands) {
                        if (!s.isOcupado()) {
                            System.out.println("NUMERO:" + s.getNUMERO_UNICO() + "-UBICACION:" + s.getUBICACION());
                        }
                    }
                    
                    System.out.println("NUMERO DEL STAND A ASIGNAR:");
                    int numeroAsignar = Integer.parseInt(sc.nextLine());
                    Stand standAAsignar = null;
                    for (Stand s: stands) {
                        if (s.getNUMERO_UNICO()==numeroAsignar && !s.isOcupado()) {
                            standAAsignar = s;
                            break;
                        }
                    }
                    
                    if (standAAsignar !=null) {
                        standAAsignar.asignarEmpresa(empresa);
                        System.out.println("STAND ASIGNADO A:" + empresa.getNOMBRE());
                    }else{
                        System.out.println("STAND NO DISPONIBLE O NO ENCONTRADO.");
                    }
                    break;
                
                case 3:
                    System.out.println("STANDS DISPONIBLES:");
                    for (Stand s: stands) {
                        if (!s.isOcupado()) { 
                            s.mostrarInformacion();
                        }
                    }
                    break;
                    
                case 4:
                    System.out.println("STANDS OCUPADOS:");
                    for (Stand s: stands) {
                        if (s.isOcupado()) {
                            s.mostrarInformacion();
                        }
                    }
                    break;
                    
                case 5:
                    salir = true;
                    break;  
                    
                default:
                    System.out.println("OPCION NO VALIDA");
            }
        }
    }


    
//--------------------------- MENU VISITANTES-----------------------------------
/**
     * Muestra el submenú para gestionar visitantes.
     * Permite registrar, editar, eliminar visitantes, y dejar comentarios sobre los stands.
     *
     * @param sc Scanner para entrada de datos del usuario.
     * @param visitantes Lista de visitantes registrados.
     * @param stands Lista de stands disponibles para comentar.
     */
    public static void menuVisitantes(Scanner sc, ArrayList<Visitante> visitantes, ArrayList<Stand> stands) {

        boolean salir = false;
        while (!salir){
            System.out.println("\n--MENU---");
            System.out.println("1. REGISTRAR VISITANTE");
            System.out.println("2. MOSTRAR VISITANTES");
            System.out.println("3. EDITAR VISITANTE");
            System.out.println("4. ELIMINAR VISITANTE");
            System.out.println("5. VISITAR STAND Y COMENTAR");
            System.out.println("6. SALIR");
            System.out.println("SELECCIONE UNA OPCION");
            
            int opcion = Integer.parseInt(sc.nextLine());
            
            switch (opcion) {
                case 1: // REGISTRAR VISITANTE
            System.out.println("INGRESE EL NOMBRE Y APELLIDO DEL VISITANTE:");
            String nombre = sc.nextLine();

            System.out.println("INGRESE EL NUMERO DE IDENTIFICACION:");
            int id = Integer.parseInt(sc.nextLine());

            System.out.println("INGRESE EL CORREO ELECTRONICO:");
            String correo = sc.nextLine();

            visitantes.add(new Visitante(nombre, id, correo));
            System.out.println("VISITANTE REGISTRADO CORRECTAMENTE.\n");
            break;
            
                case 2: //MOSTRAR VISITANTES
                    if (visitantes.isEmpty()) {
                        System.out.println("NO HAY VISITANTES REGISTRADOS");
                    } else {
                        System.out.println("VISITANTES REGISTRADOS:");
                        for (Visitante v : visitantes) {
                            System.out.println("NOMBRE: " + v.getNOMBRE());
                            System.out.println("ID: " + v.getIDENTIFICACION());
                            System.out.println("CORREO: " + v.getCORREO_ELECTRONICO());
                            System.out.println("-----------------------");
                            
                        }
                    }
                    break;

                case 3: // EDITAR VISITANTE POR NÚMERO DE IDENTIFICACIÓN
                    if (visitantes.isEmpty()) {
                        System.out.println("NO HAY VISITANTES PARA EDITAR");
                        break;
                    }
                    System.out.println("INGRESE EL NUMERO DE IDENTIFICACION DEL VISITANTE A EDITAR:");
                    int idEditar = Integer.parseInt(sc.nextLine());
                    Visitante visitanteEditar = null;
                    for (Visitante v : visitantes) {
                        if (v.getIDENTIFICACION() == idEditar) {
                            visitanteEditar = v;
                            break;
                        }
                    }
                    if (visitanteEditar != null) {
                        System.out.println("INGRESE EL NUEVO NOMBRE Y APELLIDO:");
                        String nuevoNombre = sc.nextLine();
                        System.out.println("INGRESE EL NUEVO CORREO ELECTRONICO:");
                        String nuevoCorreo = sc.nextLine();

                        visitanteEditar.setNOMBRE(nuevoNombre);
                        visitanteEditar.setCORREO_ELECTRONICO(nuevoCorreo);

                        System.out.println("VISITANTE EDITADO CORRECTAMENTE");
                    } else {
                        System.out.println("NO SE ENCONTRO UN VISITANTE CON ESE NUMERO DE IDENTIFICACION.");
                    }
                    break;

                case 4:// ELIMINAR VISITANTE POR NÚMERO DE IDENTIFICACIÓN
                    if (visitantes.isEmpty()) {
                        System.out.println("NO HAY VISITANTES PARA ELIMINAR.");
                        break;
                    }
                    System.out.println("INGRESE EL NUMERO DE IDENTIFICACION DEL VISITANTE QUE DESEA ELIMINAR:");
                    int idEliminar = Integer.parseInt(sc.nextLine());
                    boolean eliminado = visitantes.removeIf(v -> v.getIDENTIFICACION() == idEliminar);

                    if (eliminado) {
                        System.out.println("VISITANTE ELIMINADO.");
                    } else {
                        System.out.println("NO SE ENCONTRO UN VISITANTE CON ESE NUMERO DE IDENTIFICACION PARA ELIMINAR.");
                    }
                    break;
                    
                case 5:// VISITAR STAND Y COMENTAR
                    if (visitantes.isEmpty() || stands.isEmpty()) {
                        System.out.println("NO HAY VISITANTES O STANDS DISPONIBLES.");
                        break;
                    }

                    System.out.println("INGRESE SU NUMERO DE IDENTIFICACION:");
                    int idVisitante = Integer.parseInt(sc.nextLine());

                    Visitante visitante = null;
                    for (Visitante v : visitantes) {
                        if (v.getIDENTIFICACION() == idVisitante) {
                            visitante = v;
                            break;
                        }
                    }

                    if (visitante == null) {
                        System.out.println("VISITANTE NO ENCONTRADO.");
                        break;
                    }

                    System.out.println("STANDS DISPONIBLES PARA COMENTAR:");
                    for (Stand s : stands) {
                        System.out.println("NUMERO: " + s.getNUMERO_UNICO() + " - UBICACION: " + s.getUBICACION());
                    }

                    System.out.println("INGRESE EL NUMERO DEL STAND QUE DESEA VISITAR:");
                    int numeroStand = Integer.parseInt(sc.nextLine());
                    Stand stand = null;
                    for (Stand s : stands) {
                        if (s.getNUMERO_UNICO() == numeroStand) {
                            stand = s;
                            break;
                        }
                    }

                    if (stand == null) {
                        System.out.println("STAND NO ENCONTRADO.");
                        break;
                    }

                    System.out.println("INGRESE SU CALIFICACION (1 A 5 ESTRELLAS):");
                    int calificacion = Integer.parseInt(sc.nextLine());

                    if (calificacion < 1 || calificacion > 5) {
                        System.out.println("CALIFICACION INVALIDA. DEBE SER ENTRE 1 Y 5.");
                        break;
                    }

                    System.out.println("ESCRIBA SU COMENTARIO:");
                    String textoComentario = sc.nextLine();

                    Comentario comentario = new Comentario(visitante.getNOMBRE(), calificacion, textoComentario);
                    stand.agregarComentario(comentario);

                    System.out.println("¡COMENTARIO AGREGADO EXITOSAMENTE!");
                    break;
                    
                case 6://SALIR
                    salir= true;
                    System.out.println("SALIENDO DEL PROGRAMA, ¡HASTA PRONTO!");
                    break;
                    
                default:
                    System.out.println("OPCION NO VALIDA, INTENTE DE NUEVO.");
            }            
        }
    }        
//------------------------MENU REPORTES ----------------------------------------
    /**
     * Muestra el submenú de reportes.
     * Permite consultar empresas con sus stands asignados y visitantes que han dejado comentarios.
     *
     * @param stands Lista de stands registrados en la feria.
     * @param visitantes Lista de visitantes registrados.
     */
    public static void menuReportes(ArrayList<Stand> stands, ArrayList<Visitante> visitantes) {
        Scanner sc = new Scanner(System.in);
        boolean salir = false;
    
        while (!salir) {
            System.out.println("\n--- MENU DE REPORTES ---");
            System.out.println("1. EMPRESAS Y SUS STANDS");
            System.out.println("2. VISITANTES Y STANDS VISITADOS");
            System.out.println("3. VOLVER AL MENU PRINCIPAL");
            System.out.print("SELECCIONE UNA OPCION: ");
            int opcion = Integer.parseInt(sc.nextLine());
    
            switch (opcion) {
                case 1:
                    System.out.println("\n--- EMPRESAS Y STANDS ASIGNADOS ---");
                    for (Stand s : stands) {
                        if (s.isOcupado() && s.getEmpresaAsignada() != null) {
                            System.out.println("EMPRESA: " + s.getEmpresaAsignada().getNOMBRE());
                            System.out.println("STAND #: " + s.getNUMERO_UNICO());
                            System.out.println("UBICACION: " + s.getUBICACION());
                            System.out.println("TAMANO: " + s.getTAMANO());
                            System.out.println("----------------------");
                        }
                    }
                    break;

                case 2:
                    System.out.println("\n--- VISITANTES Y STANDS VISITADOS ---");
                    for (Stand s : stands) {
                        for (Comentario c : s.getComentarios()) {
                            System.out.println("VISITANTE: " + c.getNOMBRE_VISITANTE());
                            System.out.println("STAND #: " + s.getNUMERO_UNICO());
                            System.out.println("FECHA: " + c.getFECHA());
                            System.out.println("CALIFICACION: " + c.getCALIFICACION() + " ESTRELLAS");
                            System.out.println("COMENTARIO: " + c.getCOMENTARIO());
                            System.out.println("----------------------");
                        }
                    }
                    break;

                case 3:
                    salir = true;
                    break;

                default:
                    System.out.println("OPCION NO VALIDA, INTENTE DE NUEVO.");
            
            }
        }
    }
}