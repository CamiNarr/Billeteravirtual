/*
 * Copyright (c) 2024.
 */

package cl.billetera.clases.usuario;


import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public abstract class Cuenta extends Usuario {

   // Saldo en cuenta parte en 0
    public static double saldoEnLaCuenta = 0;


    public Cuenta(long saldoEnLaCuenta, String nombreUsuario, String rutUsuario, String password, String correoElectronico, boolean sesionActiva, boolean isMayorEdad) {

        this.saldoEnLaCuenta = saldoEnLaCuenta;
    }


    public static long getSaldoEnLaCuenta() {

        return (long) saldoEnLaCuenta;
    }


    public static void setSaldoEnLaCuenta(double saldoEnLaCuenta) {
        Cuenta.saldoEnLaCuenta = saldoEnLaCuenta;
    }

    //Con este metodo se ve el saldo en la cuenta

    public static void verSaldo() throws IOException, InterruptedException {
        new ProcessBuilder("clear").inheritIO().start().waitFor();


        boolean condicion;
        condicion = isSesionActiva();
        if (condicion) {
            System.out.println("El saldo en la cuenta es: $" + getSaldoEnLaCuenta());
            System.out.print(".");
            TimeUnit.SECONDS.sleep(1);
            System.out.print(".");
            TimeUnit.SECONDS.sleep(1);
            System.out.print(".");
            TimeUnit.SECONDS.sleep(1);

            //en windows esta linea limpia la consola
            new ProcessBuilder("clear").inheritIO().start().waitFor();
        } else {
            System.out.println("Para ver esta informacion debe iniciar sesion");
            System.out.print(".");
            TimeUnit.SECONDS.sleep(1);
            System.out.print(".");
            TimeUnit.SECONDS.sleep(1);
            System.out.print(".");
            TimeUnit.SECONDS.sleep(1);

            //en mac esta linea limpia la consola
            new ProcessBuilder("clear").inheritIO().start().waitFor();

        }

    }

    public static void verEstadoCuenta() throws InterruptedException, IOException {
        if (cl.billetera.clases.usuario.Usuario.isSesionActiva()) {
            System.out.println("Informacion visible por 10 segundos por seguridad");
            System.out.println("Sesion iniciada");
            System.out.println("-$" + getSaldoEnLaCuenta() + " pesos");
            System.out.println("-Nombre de usuario es=" + getNombreUsuario());
            System.out.println("-Rut de usuario es=" + getRutUsuario());
            System.out.println("-Correo electronico es=" + getCorreoElectronico());

            TimeUnit.SECONDS.sleep(10);


        } else {
            System.out.println("Debe iniciar sesion para consultar esta informacion");
        }
        //limpiar consola
        new ProcessBuilder("clear").inheritIO().start().waitFor();

        System.out.print("Volviendo al menu");
        System.out.print(".");
        TimeUnit.SECONDS.sleep(1);
        System.out.print(".");
        TimeUnit.SECONDS.sleep(1);
        System.out.print(".");
        TimeUnit.SECONDS.sleep(1);
    }

    // Con esto puedo depositar y/o retirar dinero

    public static void menuDeTransaccion() throws InterruptedException, IOException {
        new ProcessBuilder("clear").inheritIO().start().waitFor();

        System.out.println("Indique que desea hacer");
        System.out.println("1)Depositar dinero");
        System.out.println("2)Retirar dinero");
        Scanner scanner = new Scanner(System.in);
        String respuesta = scanner.nextLine();
        if (respuesta.equals("1")) {
            new ProcessBuilder("clear").inheritIO().start().waitFor();

            depositarDinero();



        } else if (respuesta.equals("2")) {
            new ProcessBuilder("clear").inheritIO().start().waitFor();

            retirarDinero();

        }
        System.out.print(".");
        TimeUnit.SECONDS.sleep(1);
        System.out.print(".");
        TimeUnit.SECONDS.sleep(1);
        System.out.print(".");
        TimeUnit.SECONDS.sleep(1);
    }

    //Si la opcion es depositar

    private static void depositarDinero() {
        System.out.println("Cuanto desea depositar?");
        Scanner scanner = new Scanner(System.in);
        long depositar = scanner.nextLong();
        System.out.println("Depositando $" + depositar + " en la cuenta");
        setSaldoEnLaCuenta(getSaldoEnLaCuenta() + depositar);

    }

    // Si la opcion es retirar

    private static void retirarDinero() {
        System.out.println("Cuanto desea retirar dinero?");
        Scanner scanner = new Scanner(System.in);
        long retirar = scanner.nextLong();
        System.out.println("Retirando $" + retirar + " de la cuenta");
        setSaldoEnLaCuenta(getSaldoEnLaCuenta() - retirar);
    }
}
