/*
 * Copyright (c) 2024.
 */

package cl.billetera.clases.usuario;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Dolar implements Conversor {
    public double dolar = 950;

    // Se ingresa el valor del dolar
    public double getDolar() {
        return dolar;
    }

    //Con esto se hace la conversion, ya sea de pesos a dolares o dolares a pesos
    //En la cuenta tambien convierte los pesos a dolares

    @Override
    public void convertir() {
        boolean seguir = true;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Indique que desea convertir");
        System.out.println("1)Pesos a Dolar");
        System.out.println("2)Dolar a pesos");
        System.out.println("3)Pesos en la cuenta a Dolar");
        System.out.println("4)volver");

        while (seguir) {
            try {
                String menu = scanner.nextLine();
                switch (menu) {
                    case "1":
                        //menu 1
                        System.out.println("Pesos a Dolar");
                        System.out.println("Ingrese cantidad a convertir");
                        double peso = scanner.nextDouble();
                        System.out.println("$" + peso + " pesos son: usd$" + peso / getDolar() + " dolares");
                        System.out.print("Volviendo al menu");
                        System.out.print(".");
                        TimeUnit.SECONDS.sleep(1);
                        System.out.print(".");
                        TimeUnit.SECONDS.sleep(1);
                        System.out.print(".");
                        TimeUnit.SECONDS.sleep(1);
                        //limpiar consola
                        new ProcessBuilder("clear").inheritIO().start().waitFor();
                        seguir = false;

                        break;

                    case "2":
                        //menu 2
                        System.out.println("Dolar a pesos");
                        System.out.println("Ingrese cantidad a convertir");
                        double dolar = scanner.nextDouble();
                        System.out.println("$" + dolar + " dolares son: $" + getDolar() * getDolar() + " pesos");
                        System.out.print("Volviendo al menu");
                        System.out.print(".");
                        TimeUnit.SECONDS.sleep(1);
                        System.out.print(".");
                        TimeUnit.SECONDS.sleep(1);
                        System.out.print(".");
                        TimeUnit.SECONDS.sleep(1);
                        //limpiar consola
                        new ProcessBuilder("clear").inheritIO().start().waitFor();
                        seguir = false;

                        break;

                    case "3":
                        //menu 3
                        System.out.println("Pesos en la cuenta a Dolar");
                        System.out.println("$" + Cuenta.getSaldoEnLaCuenta() + " pesos son: " + Cuenta.getSaldoEnLaCuenta() / getDolar() + " dolares");
                        System.out.print("Volviendo al menu");
                        System.out.print(".");
                        TimeUnit.SECONDS.sleep(1);
                        System.out.print(".");
                        TimeUnit.SECONDS.sleep(1);
                        System.out.print(".");
                        TimeUnit.SECONDS.sleep(1);
                        //limpiar consola
                        new ProcessBuilder("clear").inheritIO().start().waitFor();
                        seguir = false;

                        break;

                    case "4":
                        //salir
                        System.out.print("Volviendo al menu");
                        System.out.print(".");
                        TimeUnit.SECONDS.sleep(1);
                        System.out.print(".");
                        TimeUnit.SECONDS.sleep(1);
                        System.out.print(".");
                        TimeUnit.SECONDS.sleep(1);
                        //limpiar consola
                        new ProcessBuilder("clear").inheritIO().start().waitFor();

                        seguir = false;
                        break;

                    default:
                        //mensaje por defecto al detectar una excepcion
                        System.out.println("Accion invalida, intentelo denuevo");
                        seguir = false;
                        break;


                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }
    }
}