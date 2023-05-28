/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicio;

import Entidades.Cliente;
import Entidades.Electrodomestico;
import EntidadesHijas.Lavadora;
import EntidadesHijas.Televisor;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author irina
 */
public class menuElectrodomestico {

    Scanner scaner = new Scanner(System.in);
    //PARA PONERLE DATOS AL USUARIO
    private Cliente cliente = new Cliente();
    ArrayList<Electrodomestico> carritoCompra = new ArrayList();

    //Total a pagar
    private double precioF;

    public void menu() {
        int opcUsu;

        pedirDatos();
        System.out.print("\n".repeat(5));

        do {
            imprimirMenu();
            opcUsu = scaner.nextInt();
            switch (opcUsu) {
                case 1:
                    opc1();
                    break;
                case 2:
                    opc2();
                    break;
                case 3:
                    opc3();
                    break;
                default:
                    System.out.println("OPCION NO ENCONTRADA, INTENTELO DE NUEVO");
            }
        } while (opcUsu != 3);

    }

    private void pedirDatos() {
        System.out.println("|" + "-".repeat(50) + "|");
        System.out.printf("| %-48s |\n",
                "INGRESE SUS DATOS");

        System.out.println("|" + "-".repeat(50) + "|");
        System.out.print("   - NOMBRE: ");
        cliente.setNombre(scaner.next());
        System.out.print("   - APELLIDO: ");
        cliente.setApellido(scaner.next());
        System.out.print("   - DNI: ");
        cliente.setId(scaner.next());
        System.out.println("|" + "-".repeat(50) + "|");
    }

    private void opc1() {
        int selecElec;
        System.out.println("|--------------------------------------------------|");
        System.out.println("|           ELECTRODOMESTICOS DISPONIBLES          |");
        System.out.println("|--------------------------------------------------|");
        System.out.println("|    1.- LAVADORA                                  |");
        System.out.println("|    2.- TELEVISOR                                 |");
        System.out.println("|--------------------------------------------------|");
        System.out.print("    SELECCIONE UNA OPCION: ");
        selecElec = scaner.nextInt();
        switch (selecElec) {
            case 1:
                Lavadora lavadora = new Lavadora();
                lavadora.crearElectrodomestico();

                carritoCompra.add(new Lavadora(lavadora.getCarga(), lavadora.getColor(),
                        lavadora.getPrecio(), lavadora.getPeso(), lavadora.getConsumoE()));

                break;
            case 2:
                Televisor tv = new Televisor();
                tv.crearElectrodomestico();

                carritoCompra.add(new Televisor(tv.getTamanio(), tv.isTdt(),
                        tv.getColor(), tv.getPrecio(), tv.getPeso(), tv.getConsumoE()));

                break;
            default:
                System.out.println("|--------------------------------------------------|");
                System.out.println("  OPCION NO ENCONTRADA, INTENTELO DE NUEVO");
                System.out.println("|--------------------------------------------------|");
        }
    }
    //

    private void opc2() {

        String vDescripcion = "______DESCRIPCION_____", vColor = "__COLOR___",
                vPeso = "____PESO____", vCE = "__C.E.__", vTDT = "__TDT_",
                vTamanio = "___TAMAÑO___", vCarga = "____GARGA___",
                vTotal = "____TOTAL___";

        System.out.println("|------------------------------------------------------------------------------|----------------------|");
        System.out.println("|                    ELECTRODOMESTICOS FER CHIQUITO CLTA.                      |                      |");
        System.out.println("|                    DIR: MARCELANIADO ENTRE TARQUI Y COLON                    |   SERIE: 001 - 001   |");
        System.out.println("|                                                                              |    FACTURA: 00256    |");
        System.out.println("|            TELF: 0998608496  -   CORREO: irinaochoa32@gmail.com              |                      |");
        System.out.println("|------------------------------------------------------------------------------|----------------------|");
        System.out.printf("| NOMBRE CLIENTE: %-61s| DNI: %-16s|\n", cliente.getNombre().toUpperCase() + " " + cliente.getApellido().toUpperCase(), cliente.getId());
        System.out.println("|-----------------------------------------------------------------------------------------------------|");
        System.out.println("|" + vDescripcion + "|" + vColor + "|" + vPeso + "|" + vCE + "|" + vTDT + "|" + vTamanio + "|" + vCarga + "|" + vTotal + "|");
        precioF = 0;
        for (Electrodomestico canasta : carritoCompra) {

            precioF += canasta.getPrecio();
            if (canasta instanceof Televisor) {

                imprimirCasilla("Televisor", vDescripcion);
                imprimirCasilla(canasta.getColor(), vColor);
                imprimirCasilla(String.valueOf(canasta.getPeso()) + " KG", vPeso);
                imprimirCasilla(String.valueOf(canasta.getConsumoE()), vCE);
                if (((Televisor) canasta).isTdt()) {
                    imprimirCasilla("X", vTDT);
                } else {
                    imprimirCasilla(" ", vTDT);
                }

                imprimirCasilla(String.valueOf(((Televisor) canasta).getTamanio()) + "''", vTamanio);
                imprimirCasilla(" ", vCarga);
                imprimirCasilla(String.valueOf(canasta.getPrecio()), vTotal);

            } else if (canasta instanceof Lavadora) {
                imprimirCasilla("Lavadora", vDescripcion);
                imprimirCasilla(canasta.getColor(), vColor);
                imprimirCasilla(String.valueOf(canasta.getPeso()) + " KG", vPeso);
                imprimirCasilla(String.valueOf(canasta.getConsumoE()), vCE);
                imprimirCasilla(" ", vTDT);
                imprimirCasilla(" ", vTamanio);
                imprimirCasilla(String.valueOf(((Lavadora) canasta).getCarga()) + " KG", vCarga);
                imprimirCasilla(String.valueOf(canasta.getPrecio()), vTotal);

            }
            System.out.println("|");
        }

        System.out.println("|______________________|__________|____________|________|______|____________|____________|____________|");

        System.out.println("|----------------------------------------------------------------------------------------|------------|");
        System.out.printf("|                                                                        TOTAL A PAGAR   | $ %.2f  |\n", precioF);
        System.out.println("|----------------------------------------------------------------------------------------|------------|");
    }

    private void opc3() {
        int opcUsu;
        System.out.println("|--------------------------------------------------|");
        System.out.printf("| ESTIMADO/A %-38s|\n", cliente.getNombre());
        System.out.println("|--------------------------------------------------|");
        System.out.println("|   1.- PAGAR Y SALIR                              |");
        System.out.println("|   2.- SALIR SIN PAGAR                            |");
        System.out.println("|--------------------------------------------------|");
        System.out.print("  ->");
        opcUsu = scaner.nextInt();
        switch (opcUsu) {
            case 1:
                metodopago();
                break;
            case 2:
                System.out.println("|--------------------------------------------------|");
                System.out.println("  DEVOLVIENDO TODO ... LAMENTAMOS QUE NO LE HAYAN ");
                System.out.println("  AGRADADO NUESTROS PRODUCTOS");
                System.out.println("|--------------------------------------------------|");
                break;
            default:
                System.out.println("|--------------------------------------------------|");
                System.out.println("  OPCION NO ENCONTRADA, INTENTELO DE NUEVO");
                System.out.println("|--------------------------------------------------|");
        }
    }

    private void metodopago() {
        int opcUsu;
        double cashUsu;
        System.out.println("|--------------------------------------------------|");
        System.out.println("   TOTAL A PAGAR : " + precioF);
        System.out.println("|--------------------------------------------------|");
        System.out.println("| SELECCIONE FORMA DE PAGO                         |");
        System.out.println("|   1.- EFECTIVO                                   |");
        System.out.println("|   2.- CREDITO                                    |");
        System.out.println("|--------------------------------------------------|");
        System.out.print("    -> ");
        opcUsu = scaner.nextInt();
        switch (opcUsu) {
            case 1:
                System.out.println("|--------------------------------------------------|");
                do {
                    System.out.print("  INGRESE EFECTIVO : ");
                    cashUsu = scaner.nextDouble();
                    if (cashUsu < precioF) {
                        System.out.println(" CANTIDAD MENOR A CANTIDAD A PAGAR");
                    }
                } while (cashUsu < precioF);

                System.out.printf(" SU VUELTO ES DE: %.2f , MUCHAS GRACIAS POR SU COMPRA", (cashUsu - precioF));
                System.out.println("|--------------------------------------------------|");
                break;
            case 2:
                System.out.println("|--------------------------------------------------|");
                System.out.println("  LISTO, YA MISMO LE LLEGARA AL CORREO CONFIRMADO \n EL PAGO, GRACIAS POR SU COMPRA");
                System.out.println("|--------------------------------------------------|");
                break;
            default:
                System.out.println("|--------------------------------------------------|");
                System.out.println("  OPCION NO ENCONTRADA, INTENTELO DE NUEVO");
                System.out.println("|--------------------------------------------------|");
        }
    }

    //-------------------------------------------------------------------------- 
    private void imprimirMenu() {
        System.out.println("|" + "-".repeat(50) + "|");

        System.out.printf("| %-48s | \n",
                "BIENVENIDO/A " + cliente.getNombre() + " " + cliente.getApellido());

        System.out.println("|" + "-".repeat(50) + "|");

        System.out.printf("|   %-46s | \n",
                "1. COMPRAR ELECTRODOMESTICO");

        System.out.printf("|   %-46s | \n",
                "2. VER FACTURA");

        System.out.printf("|   %-46s | \n",
                "3. SALIR");

        System.out.println("|" + "-".repeat(50) + "|");

        System.out.print("   SELECCIONE UNA OPCION: ");
    }

    private void imprimirCasilla(String nombre, String variable) {
        int tamanio;
        String vAux;
        System.out.print("|");

        vAux = nombre;
        tamanio = vAux.length();

        if (tamanio % 2 == 0) {
            for (int i = 0; i < (variable.length() - tamanio) / 2; i++) {
                System.out.print(" ");
            }
            System.out.print(vAux);
            for (int i = 0; i < (variable.length() - tamanio) / 2; i++) {
                System.out.print(" ");
            }
        } else {
            tamanio--;
            for (int i = 0; i < (variable.length() - tamanio) / 2; i++) {
                System.out.print(" ");
            }
            System.out.print(vAux);
            for (int i = 0; i < (variable.length() - tamanio - 2) / 2; i++) {
                System.out.print(" ");
            }
        }
    }

}
