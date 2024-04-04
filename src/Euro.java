/*
 * Copyright (c) 2024.
 */

package cl.billetera.clases.usuario;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

//Ubicacion de los metodos de Moneda Euro, que sirve para convertir pesos a euros o euros a pesos
// En la cuenta tambien se convierten los pesos a euros

public class Euro implements Conversor {
    public double euro = 910;

    public double getEuro() {
        return euro;
    }

    @Override
    public void convertir() {
        boolean seguir = true;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Indique que desea convertir");
        System.out.println("1)Pesos a Euro");
        System.out.println("2)Euro a pesos");
        System.out.println("3)Pesos en la cuenta a Euro");
        System.out.println("4)volver");

        while (seguir) {
            try {
                String menu = scanner.nextLine();
                switch (menu) {
                    case "1":
                        //menu 1
                        System.out.println("Pesos a Euro");
                        System.out.println("Ingrese cantidad a convertir");
                        double peso = scanner.nextDouble();
                        System.out.println("$" + peso + " pesos son: " + peso * getEuro() + " euros");
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
                        System.out.println("Euro a pesos");
                        System.out.println("Ingrese cantidad a convertir");
                        double euro = scanner.nextDouble();
                        System.out.println("$" + euro + " euros son: $" + getEuro() / getEuro() + " pesos");
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
                        System.out.println("Pesos en la cuenta a Euro");

                        System.out.println("$" + Cuenta.getSaldoEnLaCuenta() + " pesos son: " + Cuenta.getSaldoEnLaCuenta() / getEuro() + " euros");
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

                        break;

                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }
    }


}
