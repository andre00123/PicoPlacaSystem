/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PicoPlaca;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Andre
 */
public class PicoPlacaSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String disponibilidad = "";
        Date date = new Date();
        Scanner sn = new Scanner(System.in);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm");
        boolean salir = false;

        System.out.println("******** Bienvenido al Sistema de PredicciÃ³n de Pico y Placa***********************");

        while (!salir) {
            System.out.println("");
            System.out.println("Escoja una de las siguientes opciones:");
            System.out.println("1. Buscar disponibilidad de transitar");
            System.out.println("2. Salir");

            try {
                System.out.println("Escribe una de las opciones");
                int opcion = sn.nextInt();
                sn.nextLine();

                switch (opcion) {
                    case 1:
                        boolean respuesta = false;
                        String placa;
                        do {
                            System.out.println("A continuaciÃ³n ingrese el nÃºmero de placa de tu vehÃ­culo: ");
                            System.out.println("Ej.: PBV6204");
                            placa = sn.nextLine();
                            if ((placa.length() > 5) && (placa.length() < 8)) {
                                respuesta = true;
                            } else {
                                System.out.println("La placa ingresada no es correcta, vuelva a intentarlo.");
                            }
                        } while (!respuesta);

                        Placa auto = new Placa(placa);
                        respuesta = false;
                        do {
                            System.out.println("A continuaciÃ³n ingrese la fecha y la hora que desea verificar disponibilidad: ");
                            System.out.println("Ej.: 03/24/2013 21:54 (MM/dd/yyyy HH:mm)");
                            disponibilidad = sn.nextLine();
                            try {
                                date = simpleDateFormat.parse(disponibilidad);
                                respuesta = true;
                                System.out.println("date : " + simpleDateFormat.format(date));
                            } catch (ParseException ex) {
                                System.out.println("El formato de fecha que ingreso es incorrecto, intente neuvamente.");
                            }
                        } while (!respuesta);

                        if (date.getDay() == auto.getDia()) {
                            if (((date.getHours() >= 7) && (date.getHours() <= 9) && (date.getMinutes() < 30)) || ((date.getHours() >= 16) && (date.getHours() <= 19) && (date.getMinutes() < 30))) {
                                System.out.println(auto.toString() + "no tiene permitido circular en la fecha y hora seleccionada.");
                            } else {
                                System.out.println(auto.toString() + "si tiene permitido circular en la fecha y hora seleccionada");
                            }
                        } else {
                            System.out.println(auto.toString() + "si tiene permitido circular en la fecha y hora seleccionada");
                        }

                        break;
                    case 2:
                        System.out.println("Gracias por usar nuestro servicio!");
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo nÃºmeros 1 y 2");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un nÃºmero");
                sn.next();
            }
        }
    }

}


