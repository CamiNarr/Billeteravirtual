package cl.billetera.clases;


import cl.billetera.clases.usuario.*;
import com.sun.jdi.InternalException;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

// Trae a las clases para ejecutar la configuracion inicial de la cuenta, es decir;
// crear usuario, iniciar sesion, ver saldo, depositar o retirar, ver estado, conversion de monedas

public class Menu {

    public static String menu;


    // Se utiliza la opcion de TimeUnit.SECONDS.sleep(3); para que el usuario al cerrar alcance
    // a leer el mensaje que la aplicacion le entrega

    public static void menuAplicacion() throws IOException, InternalException, InterruptedException {

        boolean seguir = true;
        Scanner scanner = new Scanner(System.in);
            new ProcessBuilder("clear").inheritIO().start().waitFor();
            //Para sistemas operativos como Linux O macOS, usar el comando "clear"

                System.out.println("Bienvenido a su billetera!");
                System.out.println(".");
                TimeUnit.SECONDS.sleep(1);
                System.out.println(".");
                TimeUnit.SECONDS.sleep(1);
                System.out.println(".");
                TimeUnit.SECONDS.sleep(1);

                //ambas necesarias para la opcion 6 y 7 del menu
                Dolar dolar = new Dolar();
                Euro euro = new Euro();


                while (seguir) {
                    try {

                        System.out.println("MENU");

                        System.out.println("    1) Crear usuario");

                        System.out.println("    2) Iniciar sesion");

                        System.out.println("    3) Ver saldo en la cuenta");

                        System.out.println("    4) Depositar o retirar dinero");

                        System.out.println("    5) Ver estado de Cuenta");

                        System.out.println("    6) Conversion dolar a peso");

                        System.out.println("    7) Conversion euro a peso");

                        System.out.println("    8) Ver valores de conversion");

                        System.out.println("    9) Salir (La informacion ingresada sera eliminada)");


                        System.out.print("Escriba un numero: ");


                        menu = scanner.next();


                        switch (menu) {
                            case "1":
                                Usuario.verificarMayoriaEdadUsuario();
                                Usuario.crearUsuario();

                                break;

                            case "2":
                                Usuario.iniciarSesion();

                                break;

                            case "3":
                                Cuenta.verSaldo();

                                break;

                            case "4":
                                Cuenta.menuDeTransaccion();

                                break;

                            case "5":
                                Cuenta.verEstadoCuenta();

                                break;

                            case "6":
                                dolar.convertir();

                                break;

                            case "7":
                                euro.convertir();

                                break;
                            case "8":
                                System.out.println("Valores de conversion");
                                System.out.println("El dolar se paga a $" + dolar.getDolar() + "pesos");
                                System.out.println("El euro se paga a $" + euro.getEuro() + "pesos");
                                TimeUnit.SECONDS.sleep(4);
                                break;


                            case "9":
                                new ProcessBuilder("clear").inheritIO().start().waitFor();
                                System.out.println("");
                                System.out.println("Muchas gracias por preferir Alke-Wallet");
                                System.out.print(".");
                                TimeUnit.SECONDS.sleep(1);
                                System.out.print(".");
                                TimeUnit.SECONDS.sleep(1);
                                System.out.print(".");
                                TimeUnit.SECONDS.sleep(1);
                                new ProcessBuilder("clear").inheritIO().start().waitFor();
                                seguir = false;
                                break;


                            default:
                                System.out.println("Accion invalida, intentar nuevamente");

                                break;

                        }
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            }
    }
