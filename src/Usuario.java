/*
 * Copyright (c) 2024.
 */

package cl.billetera.clases.usuario;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * Se utiliza el modificador de acceso protected para utilizar las
 * variables en otras clases
 */
public class Usuario {
    //declaracion de variables utilizadas por la clase usuario
    protected static String nombreUsuario;
    protected static String rutUsuario;
    protected static String password;
    private static String idUsuario;
    private static String correoElectronico;
    private static boolean isMayorEdad;
    protected static boolean sesionActiva = false;


    /**
     * Obliga que al crear un usuario se deban ingresar todos sus datos
     */
    public Usuario() {
        this.nombreUsuario = nombreUsuario;
        this.rutUsuario = rutUsuario;
        this.idUsuario = idUsuario;
        this.password = password;
        this.correoElectronico = correoElectronico;
        this.sesionActiva = sesionActiva;
    }

    /**
     * accede al nombre del usuario
     */
    public static String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     * @param nombreUsuario se usa al momento de crear un usuario
     *                      para almacenar el nombre del usuario
     */
    public static void setNombreUsuario(String nombreUsuario) {
        Usuario.nombreUsuario = nombreUsuario;
    }

    /**
     * @return se usa para acceder al rut del usuario
     */
    public static String getRutUsuario() {
        return rutUsuario;
    }

    /**
     * @param rutUsuario se usa al momento de crear un usuario
     *                   para almacenar el rut del usuario
     */
    public static void setRutUsuario(String rutUsuario) {
        Usuario.rutUsuario = rutUsuario;
    }

    /**
     * @return se usa para confirmar la contraseña del usuario, es importante jamas
     * mostrarla ya que seria un problema de seguridad
     */
    public static String getPassword() {
        return password;
    }

    /**
     * @param password utilizado para crear la contraseña del usuario
     */
    public static void setPassword(String password) {
        Usuario.password = password;
    }

    /**
     * @return se usa para crear un id de usuario aleatorio
     */
    public static void setIdUsuario(String idUsuario) {
        Usuario.idUsuario = idUsuario.toString();
    }

    /**
     * @return permite acceder al correo electronico del usuario
     */
    public static String getCorreoElectronico() {
        return correoElectronico;
    }

    /**
     * @param correoElectronico permite asignar el correo electronico del usuario
     */
    public static void setCorreoElectronico(String correoElectronico) {
        Usuario.correoElectronico = correoElectronico;
    }

    /**
     * @return reservado en caso que mas adelante se requiera mostrar la edad del usuario o asignarla
     */
    public static boolean isIsMayorEdad() {
        return isMayorEdad;
    }

    public static void setIsMayorEdad(boolean isMayorEdad) {
        Usuario.isMayorEdad = isMayorEdad;
    }

    /**
     * utilizado para leer el estado de la sesion del usuario
     */
    public static boolean isSesionActiva() {
        return sesionActiva;
    }

    /**
     * utilizado para asiganar el estado de la sesion del usuario
     */
    public void setSesionActiva() {
        this.sesionActiva = sesionActiva;
    }

    /**
     * Permite crear un usuario con sus correspondientes datos personales y
     * generar un id.
     */
    public static void crearUsuario() throws IOException, InterruptedException {
        new ProcessBuilder("clear").inheritIO().start().waitFor();
        if (isMayorEdad) {
            System.out.println("Crea usuario y configurar contraseña");

            System.out.println("Ingrese el nombre del Usuario");
            Scanner scanner = new Scanner(System.in);

            setNombreUsuario(scanner.next());
            System.out.println("Ingrese el rut del usuario sin puntos y con guion");
            System.out.println("    ejemplo:  19000123-0");
            scanner.nextLine();
            setRutUsuario(scanner.nextLine());
            setIdUsuario(String.valueOf(new Random()));
            System.out.println("Ingrese su Email:");
            setCorreoElectronico(scanner.nextLine());

            System.out.println("Indique una contraseña de 10 caracteres");
            System.out.println("solo se permiten 10 caracteres, el resto sera eliminado");
            System.out.print("contraseña: ");

            setPassword(scanner.nextLine());
            setPassword(getPassword().substring(0, 10));


            //limpiar consola y volver al menu
            new ProcessBuilder("clear").inheritIO().start().waitFor();
            System.out.println("Usuario creado");
            System.out.print("Volviendo al menu");
            System.out.print(".");
            TimeUnit.SECONDS.sleep(1);
            System.out.print(".");
            TimeUnit.SECONDS.sleep(1);
            System.out.print(".");
            TimeUnit.SECONDS.sleep(1);
        } else {
            System.out.print("Edad no valida para utilizar esta aplicacion ");
        }

    }

    /**
     * se utliza para iniciar la sesion del usuario
     */
    public static void iniciarSesion() throws IOException, InterruptedException {

        new ProcessBuilder("clear").inheritIO().start().waitFor();
        Scanner scanner1 = new Scanner(System.in);
        String textoAComparar1;
        String correo;
        String textoAComparar2;
        String contraseña;
        System.out.println("Ingrese su correo");
        textoAComparar1 = scanner1.nextLine();

        System.out.println("Ingrese su contraseña");
        Scanner scanner2 = new Scanner(System.in);
        textoAComparar2 = scanner2.nextLine();
        correo = getCorreoElectronico();
        contraseña = getPassword();

        if ((textoAComparar1.equals(correo)) && (textoAComparar2.equals(contraseña))) {

            System.out.println("Sesion iniciada correctamente");
            sesionActiva = true;
            //limpiar consola y volver al menu
            new ProcessBuilder("clear").inheritIO().start().waitFor();

            System.out.print("Volviendo al menu");
            System.out.print(".");
            TimeUnit.SECONDS.sleep(1);
            System.out.print(".");
            TimeUnit.SECONDS.sleep(1);
            System.out.print(".");
            TimeUnit.SECONDS.sleep(1);


        } else {
            System.out.println("Usuario o contraseña incorrectos");
            System.out.println("Intentelo nuevamente o contacte con entidad bancaria");

            //limpiar consola y volver al menu
            System.out.print("Volviendo al menu");
            System.out.print(".");
            TimeUnit.SECONDS.sleep(1);
            System.out.print(".");
            TimeUnit.SECONDS.sleep(1);
            System.out.print(".");
            TimeUnit.SECONDS.sleep(1);
            System.out.print(".");
            TimeUnit.SECONDS.sleep(1);
            System.out.print(".");
            TimeUnit.SECONDS.sleep(1);
            System.out.print(".");
            TimeUnit.SECONDS.sleep(1);
            new ProcessBuilder("clear").inheritIO().start().waitFor();
        }


    }

    private static String password() {
        return null;
    }

    private static String correoElectronico() {
        return null;
    }

    protected static boolean getSesionActiva() {
        return false;
    }

    /**
     * @return realiza una comprobacion de la edad del usuario
     */
    public static boolean verificarMayoriaEdadUsuario() throws IOException, InterruptedException {
        //en windows esta linea limpia la consola
        new ProcessBuilder("clear").inheritIO().start().waitFor();
        System.out.println("Ingrese su edad");
        Scanner scanner = new Scanner(System.in);
        int edadusuarioIngresada = Integer.parseInt(scanner.nextLine());

        if ((edadusuarioIngresada >= 18) && edadusuarioIngresada <= 120) {
            isMayorEdad = true;
        } else {
            isMayorEdad = false;
            System.out.println("Edad no valida para utilizar esta aplicacion ");
            System.out.print("Volviendo al menu");
            System.out.print(".");
            TimeUnit.SECONDS.sleep(1);
            System.out.print(".");
            TimeUnit.SECONDS.sleep(1);
            System.out.print(".");
            TimeUnit.SECONDS.sleep(1);
        }
//en windows esta linea limpia la consola
        new ProcessBuilder("clear").inheritIO().start().waitFor();
        return isMayorEdad;
    }


    public static boolean verificarMayoriaEdadUsuario(int edadusuarioIngresada) {

        return false;
    }
}