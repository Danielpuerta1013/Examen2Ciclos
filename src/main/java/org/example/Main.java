package org.example;


import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Integer contadorJuegos=0;
        Integer contadorGanadas=0;
        Integer contadorPerdidas=0;
        Integer contadorEmpates=0;
        Scanner sc=new Scanner(System.in);
        int opcionMenu;
        System.out.println("taller para el parcial 2");
        System.out.println("1. Empresa Moda Express");
        System.out.println("2. Piedra papel y tijera");
        System.out.println("3.salir");
        do {
            System.out.print("ingrese la opcion deseada: ");
            opcionMenu=sc.nextInt();
            if (opcionMenu==1){
                System.out.println("Sistema de gestion de descuentos Moda Express");
                sc.nextLine();
                System.out.print("ingrese su nombre: ");
                String NombreUsuario=sc.nextLine();
                System.out.println("ingrese su tipo de cliente: /regular/vip");
                String tipoCliente=sc.nextLine().toLowerCase();
                System.out.println("ingrese la cantidad de articulos comprados: ");
                int cantidadArticulos=sc.nextInt();
                System.out.println("Ingrese el precio total de la compra: ");
                Double totalCompra=sc.nextDouble();
                totalCompra-= (totalCompra*calcularDescuento(tipoCliente,cantidadArticulos));
                System.out.println("el total de su compra es de: $" +totalCompra);
                
            } else if (opcionMenu==2) {

                System.out.println("Bienvenido a piedra, papel o tijera");
                System.out.println("ingrese una opcion: piedra/papel/tijera");
                sc.nextLine();
                String opcionUsuario=sc.nextLine().toLowerCase();
                Random random=new Random();

                if (opcionUsuario.equals("piedra")||opcionUsuario.equals("papel")||opcionUsuario.equals("tijera")){
                    String[] opciones ={"piedra","papel","tijera"};
                    int opcionInt= random.nextInt(opciones.length);
                    String opcionPc=opciones[opcionInt];
                    contadorJuegos++;
                    if (opcionUsuario.equals(opcionPc)){
                        System.out.println("empate de la maquina con: "+opcionPc);
                        contadorEmpates++;
                    } else if ((opcionUsuario.equals("piedra") && opcionPc.equals("tijera")) ||
                            (opcionUsuario.equals("papel") && opcionPc.equals("piedra")) ||
                            (opcionUsuario.equals("tijera") && opcionPc.equals("papel")) ) {
                        System.out.println(" ganaste, la computadora saco: "+opcionPc);
                        contadorGanadas++;

                    }else {
                        System.out.println("la computadora gana con: "+opcionPc);
                        contadorPerdidas++;
                    }


                }else{
                    System.out.println("opcion no valida");
                }
                System.out.println("usted ha jugado: "+contadorJuegos+" veces");
                System.out.println("usted ha ganado: "+contadorGanadas+ " veces");
                System.out.println("usted ha empatado: "+contadorEmpates+ " veces");
                System.out.println("usted ha ganado: "+contadorPerdidas+ " veces");
            } else if (opcionMenu==3){
                System.out.println("hasta luego");

            } else {
                System.out.println("opcion incorrecta");
            }


        }while (opcionMenu!=3);


    }
        private static double calcularDescuento(String tipoCliente, int cantidadArticulos) {
            if (tipoCliente.equalsIgnoreCase("Regular")) {
                if (cantidadArticulos >= 1 && cantidadArticulos <= 3) {
                    return 0.05;
                } else if (cantidadArticulos >= 4 && cantidadArticulos <= 6) {
                    return 0.10;
                } else {
                    return 0.15;
                }
            } else if (tipoCliente.equalsIgnoreCase("VIP")) {
                if (cantidadArticulos >= 1 && cantidadArticulos <= 3) {
                    return 0.10;
                } else if (cantidadArticulos >= 4 && cantidadArticulos <= 6) {
                    return 0.15;
                } else {
                    return 0.20;
                }
            } else {
                // Tipo de cliente no válido, sin descuento
                return 0;
            }
        }
}