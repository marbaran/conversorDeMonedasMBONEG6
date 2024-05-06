package com.marcbara.conversorDeMonedaMB.principal;

import com.marcbara.conversorDeMonedaMB.modelos.CodigosDeMonedas;
import com.marcbara.conversorDeMonedaMB.principal.PrincipalConexionAPI;

import java.io.IOException;
import java.util.Scanner;

public class PrincipalMenu {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner opcionDeseada = new Scanner(System.in);
        Scanner valorDeseado = new Scanner(System.in);
        PrincipalConexionAPI consultaTasa = new PrincipalConexionAPI();
        int opcionIngresada = 0;
        double valorIngresado = 0.00;

        do {
            System.out.println("**********************************");
            System.out.println("*      CONVERSOR DE MONEDAS      *");
            System.out.println("**********************************");
            System.out.println("\n 1) Peso Argentino >>>> Dolar ");
            System.out.println(" 2) Dolar >>>> Peso Argentino ");
            System.out.println(" 3) Real >>>> Dolar ");
            System.out.println(" 4) Dolar >>>> Real ");
            System.out.println(" 5) Euro >>>> Dolar ");
            System.out.println(" 6) Dolar >>>> Euro ");
            System.out.println(" 0) Salir");
            System.out.println("\n Ingrese la opción deseada ");
            System.out.println(" -------------------------");

            opcionIngresada = Integer.parseInt(opcionDeseada.nextLine());

            if (opcionIngresada >= 1 && opcionIngresada <= 6) {
                System.out.println("Ingrese el valor a convertir:");
                valorIngresado = valorDeseado.nextDouble();
            }
            switch(opcionIngresada) {
                case 1:
                    consultaTasa.tasasDeCambio(CodigosDeMonedas.ARS, CodigosDeMonedas.USD, CodigosDeMonedas.ARS, valorIngresado);
                    break;
                case 2:
                    consultaTasa.tasasDeCambio(CodigosDeMonedas.USD, CodigosDeMonedas.ARS, CodigosDeMonedas.ARS, valorIngresado);
                    break;
                case 3:
                    consultaTasa.tasasDeCambio(CodigosDeMonedas.BRL, CodigosDeMonedas.USD, CodigosDeMonedas.BRL, valorIngresado);
                    break;
                case 4:
                    consultaTasa.tasasDeCambio(CodigosDeMonedas.USD, CodigosDeMonedas.BRL, CodigosDeMonedas.BRL, valorIngresado);
                    break;
                case 5:
                    consultaTasa.tasasDeCambio(CodigosDeMonedas.EUR, CodigosDeMonedas.USD, CodigosDeMonedas.EUR, valorIngresado);
                    break;
                case 6:
                    consultaTasa.tasasDeCambio(CodigosDeMonedas.USD, CodigosDeMonedas.EUR, CodigosDeMonedas.EUR, valorIngresado);
                    break;
                case 0:
                    System.out.println("Gracias por usar el conversor");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        } while (opcionIngresada != 0);
    }
}
