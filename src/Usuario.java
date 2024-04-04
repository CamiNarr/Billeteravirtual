

package cl.billetera.clases.usuario;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class Usuario {
    // Declaracion de variables utilizadas por la clase usuario
    
    protected static String nombreUsuario;
    protected static String rutUsuario;
    protected static String password;
    private static String idUsuario;
    private static String correoElectronico;
    private static boolean isMayorEdad;
    protected static boolean sesionActiva = false;


    // Con esto se condiciona que se deban ingresar todos los datos al crear un usuario
    
    public Usuario() {
        this.nombreUsuario = nombreUsuario;
        this.rutUsuario = rutUsuario;
        this.idUsuario = idUsuario;
        this.password = password;
        this.correoElectronico = correoElectronico;
        this.sesionActiva = sesionActiva;
    }

        // Accede al nombre del usuario
    
    public static String getNombreUsuario() {
        return nombreUsuario;
    }

   
    public static void setNombreUsuario(String nombreUsuario) {
        Usuario.nombreUsuario = nombreUsuario;
    }

   
    public static String getRutUsuario() {
        return rutUsuario;
    }
   // Al momento de crear un usuario con esto almaceno el rut del usuario
  
    public static void setRutUsuario(String rutUsuario) {
        Usuario.rutUsuario = rutUsuario;
    }

  
    public static String getPassword() {
        return password;
    }

  // Para crear la contraseña
    public static void setPassword(String password) {
        Usuario.password = password;
    }

 // Para crear un Id de usuario
    public static void setIdUsuario(String idUsuario) {
        Usuario.idUsuario = idUsuario.toString();
    }

  
    public static String getCorreoElectronico() {
        return correoElectronico;
    }

    
    public static void setCorreoElectronico(String correoElectronico) {
        Usuario.correoElectronico = correoElectronico;
    }

   
    public static boolean isIsMayorEdad() {
        return isMayorEdad;
    }

    public static void setIsMayorEdad(boolean isMayorEdad) {
        Usuario.isMayorEdad = isMayorEdad;
    }

  
    public static boolean isSesionActiva() {
        return sesionActiva;
    }


    public void setSesionActiva() {
        this.sesionActiva = sesionActiva;
    }

   
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


            // Limpiar consola y volver al menu
            
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

              // Para iniciar sesion de usuario
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

    
    public static boolean verificarMayoriaEdadUsuario() throws IOException, InterruptedException {
        //esta linea limpia la consola
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
// esta linea limpia la consola
        new ProcessBuilder("clear").inheritIO().start().waitFor();
        return isMayorEdad;
    }


    public static boolean verificarMayoriaEdadUsuario(int edadusuarioIngresada) {

        return false;
    }
}
