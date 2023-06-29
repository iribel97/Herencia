/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicio;

import EntidadesPadres.*;
import EntidadesHijas.*;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author irina
 */
public class AlquilarBarcos {

    private Scanner scaner = new Scanner(System.in);
    private ArrayList<Cliente> clientes = new ArrayList();
    private ArrayList<Barco> barcos = new ArrayList();
    private ArrayList<Barco> barcosA = new ArrayList();
    private Imprimibles imp = new Imprimibles();

    private void crearMuelle() {
        //public BarcoVelero(int numMastiles, String matricula, double eslora, int anioFab)
        barcos.add(new BarcoVelero(3, "ABD-001", 12.5, 2015));
        barcos.add(new BarcoVelero(4, "ABD-002", 15, 2015));
        barcos.add(new BarcoVelero(2, "ABD-003", 20, 2018));
        //public BarcoMotor(int potenciaCV, String matricula, double eslora, int anioFab)
        barcos.add(new BarcoMotor(15, "IRI-001", 25, 2019));
        barcos.add(new BarcoMotor(12, "IRI-002", 17, 2017));
        barcos.add(new BarcoMotor(15, "IRI-003", 10, 2018));
        // public BarcoYate(int numCamarotes, int potenciaCV, String matricula, double eslora, int anioFab)
        barcos.add(new BarcoYate(8, 1000, "TAE-001", 27, 2020));
        barcos.add(new BarcoYate(5, 8000, "TAE-002", 30, 2020));
        barcos.add(new BarcoYate(10, 9000, "TAE-003", 45, 2020));
    }

    private void crearBarco() {
        int opc, anio;
        String matricula;
        double eslora;
        boolean bandera;
        do {
            imp.menuB();
            try {
                System.out.print("   SELECCIONE TIPO DE BARCO A AGREGAR: ");
                opc = scaner.nextInt();
                if (opc > 3) {
                    imp.mensajeE1();
                } else {
                    System.out.println("|--------------------------------------------------|");
                    System.out.println("|               INGRESEMOS LOS DATOS               |");
                    System.out.println("|--------------------------------------------------|");
                    do {
                        bandera = false;
                        System.out.print("    MATRICULA: ");
                        matricula = scaner.next();
                        for (Barco barco : barcos) {
                            if (barco.getMatricula().equalsIgnoreCase(matricula)) {
                                bandera = true;
                                break;
                            }
                        }
                        if (bandera) {
                            imp.mensajeE2();
                        }
                    } while (bandera);
                    System.out.print("    ESLORA: ");
                    eslora = scaner.nextDouble();
                    System.out.print("    AÑO DE FABRICACIÓN: ");
                    anio = scaner.nextInt();
                    switch (opc) {
                        case 1:
                            System.out.print("    NUMERO DE MASTILES: ");
                            barcos.add(new BarcoVelero(scaner.nextInt(), matricula.toUpperCase(), eslora, anio));
                            break;
                        case 2:
                            System.out.print("    POTENCIA CV: ");
                            barcos.add(new BarcoMotor(scaner.nextInt(), matricula.toUpperCase(), eslora, anio));
                            break;
                        default:
                            System.out.print("    POTENCIA CV: ");
                            int potencia = scaner.nextInt();
                            System.out.print("    NUMERO DE CAMAROTES: ");
                            int numCam = scaner.nextInt();
                            barcos.add(new BarcoYate(numCam, potencia, matricula.toUpperCase(), eslora, anio));
                    }
                }
            } catch (Exception e) {
                imp.mensajeE1();
                opc = 4;
            }

        } while (opc > 3);

    }

    private Cliente crearUsu() {
        String nombre, ID;

        System.out.println("|--------------------------------------------------|");
        System.out.println("|               VAMOS A REGISTRARNOS               |");
        System.out.println("|--------------------------------------------------|");
        scaner.nextLine();
        System.out.print("    - Nombre: ");
        nombre = scaner.nextLine();
        System.out.print("    - ID: ");
        ID = scaner.next();

        return new Cliente(nombre, ID);
    }

    private boolean confirmarAdmin(String contUsuario, String nombreUsu) {
        return contUsuario.equalsIgnoreCase("07Admin")
                && nombreUsu.equalsIgnoreCase("Admin");
    }

    private boolean verificarCliente(String usu, String cont) {
        for (Cliente aux : clientes) {
            if (aux.getNombreCli().equalsIgnoreCase(usu)
                    && aux.getIdCli().equalsIgnoreCase(cont)) {
                return true;
            }
        }
        return false;
    }

    public void Mostrar() {
        boolean bandera;
        crearMuelle();
        int opc, opc2;
        String nombre, contra;
        do {
            imp.Bienvenida();
            try {
                System.out.print("   SELECCIONE UNA OPCION: ");
                opc = scaner.nextInt();
                switch (opc) {
                    case 1:
                        System.out.println("|--------------------------------------------------|");
                        System.out.print("    Nombre: ");
                        nombre = scaner.next();
                        System.out.print("    ID: ");
                        contra = scaner.next();
                        System.out.println("|--------------------------------------------------|");
                        //Primero confirma si es el admin que estra tratando de ingresar
                        if (confirmarAdmin(contra, nombre)) {
                            //que se repita el menu mientras que el admin no digite 5
                            do {
                                //bandera guarda el valor que retorna e metodo
                                bandera = opcAdmin();
                            } while (bandera);

                        } else {
                            //si el arraylist clientes esta vacio o si el nombre no existe
                            if (clientes.isEmpty() || !verificarCliente(nombre, contra)) {
                                //mostrar mensaje
                                imp.mensajeE3();
                            } else{
                                for (Cliente aux : clientes) {
                                    if (aux.getIdCli().equalsIgnoreCase(contra)) {
                                        opcCliente(aux);
                                    }
                                }
                            }
                        }
                        break;
                    case 2:
                        clientes.add(crearUsu());
                        break;
                    case 3:

                        break;
                    default:
                        imp.mensajeE1();
                }
            } catch (Exception e) {
                opc = 4;
            }
        } while (opc != 3);

    }

    private boolean opcAdmin() {
        int opc;
        do {

            //Menu de opciones para el usuario admin
            imp.menuAdmin();
            try {

                System.out.print("     SELECCIONE UNA OPCION: ");
                opc = scaner.nextInt();

                if (opc > 5) {
                    imp.mensajeE1();
                }

            } catch (Exception e) {
                opc = 6;
                imp.mensajeE1();
            }
        } while (opc > 5);

        switch (opc) {
            case 1:
                //admin agg mas barcos
                crearBarco();
                break;
            case 2:
                //admin revise cuales estan arrendados
                if(barcosA.isEmpty()){
                    imp.mensajeE4();
                }else{
                    inventarioA();
                }
                
                break;
            case 3:
                //admin revise que barcos no se han arrendado
                inventarioDisponible();
                break;
            case 4:
                //admin revise todas las embarcaciones
                break;
            case 5:
                break;
        }
        return opc != 5;

    }

    private void opcCliente(Cliente cli) {
        String matri, fechaI, fechaF;
        boolean bandera = false;
        int opc;
        do {
            try {
                imp.menuCli(cli.getNombreCli());
                System.out.print("   SELECCIONE UNA OPCION: ");
                opc = scaner.nextInt();
                if (opc > 2) {
                    imp.mensajeE1();
                }
            } catch (Exception e) {
                imp.mensajeE1();
                opc = 3;
            }
        } while (opc > 2);

        switch (opc) {
            case 1:
                do {
                    inventarioDisponible();
                    System.out.print("   - INGRESE LA MATRICULA DE LA EMBARCACION A ARRENTAR: ");
                    matri = scaner.next();
                    for (Barco embarcacion : barcos) {
                        if (embarcacion.getMatricula().equalsIgnoreCase(matri)) {
                            bandera = true;
                            cli.setBoat(embarcacion);
                            System.out.println("|--------------------------------------------------|");
                            System.out.print(" - Fecha de hoy (yyyy-mm-dd): ");
                            fechaI = scaner.next();
                            cli.setFechaAlqu(LocalDate.parse(fechaI));
                            System.out.print(" - Fecha de devolucion (yyyy-mm-dd): ");
                            fechaF = scaner.next();
                            cli.setFechaDev(LocalDate.parse(fechaF));
                            System.out.println("|--------------------------------------------------|");
                            cli.setPosicionAm((int)(Math.random()*20));
                            System.out.println("  Su embarcacion se encuentra en la posicion " + cli.getPosicionAm());
                            System.out.println(" y debe de pagar $" + cli.totalPag());
                            barcosA.add(embarcacion);
                            barcos.remove(embarcacion);
                        }
                    }
                } while (!bandera);
                break;
            case 2:
                break;
        }
    }

    private void inventarioDisponible() {
        String vMatricula = "--- MATRICULA --", vEslora = "-- ESLORA --",
                vAnioFab = "-- AÑO DE FABRICACION --", vMastiles = "-- MASTILES --",
                vCV = "-- CV --", vCamarotes = "-- CAMAROTES -", vTipoBarco = "-- TIPO EMBARCACION --";

        System.out.println("|" + "-".repeat(116) + "|");
        System.out.println("|" + " ".repeat(40) + "EMBARCACIONES DISPONIBLES FER CHIKIS" + " ".repeat(40) + "|");
        System.out.println("|" + "-".repeat(116) + "|");
        System.out.println("|" + vTipoBarco + "|" + vMatricula + "|" + vEslora + "|" + vAnioFab + "|" + vMastiles + "|"
                + vCV + "|" + vCamarotes + "|");
        for (Barco aux : barcos) {

            if (aux instanceof BarcoVelero) {
                imp.imprimirCasilla("VELERO", vTipoBarco);
                imp.imprimirCasilla(aux.getMatricula(), vMatricula);
                imp.imprimirCasilla(String.valueOf(aux.getEslora()), vEslora);
                imp.imprimirCasilla(String.valueOf(aux.getAnioFab()), vAnioFab);
                imp.imprimirCasilla(String.valueOf(((BarcoVelero) aux).getNumMastiles()), vMastiles);
                imp.imprimirCasilla("   --   ", vCV);
                imp.imprimirCasilla("    --   ", vCamarotes);
            } else if (aux instanceof BarcoYate) {
                imp.imprimirCasilla("YATE", vTipoBarco);
                imp.imprimirCasilla(aux.getMatricula(), vMatricula);
                imp.imprimirCasilla(String.valueOf(aux.getEslora()), vEslora);
                imp.imprimirCasilla(String.valueOf(aux.getAnioFab()), vAnioFab);
                imp.imprimirCasilla("   --   ", vMastiles);
                imp.imprimirCasilla(String.valueOf(((BarcoYate) aux).getPotenciaCV()), vCV);
                imp.imprimirCasilla(String.valueOf(((BarcoYate) aux).getNumCamarotes()), vCamarotes);
            } else if (aux instanceof BarcoMotor) {
                imp.imprimirCasilla("MOTOR", vTipoBarco);
                imp.imprimirCasilla(aux.getMatricula(), vMatricula);
                imp.imprimirCasilla(String.valueOf(aux.getEslora()), vEslora);
                imp.imprimirCasilla(String.valueOf(aux.getAnioFab()), vAnioFab);
                imp.imprimirCasilla("   --   ", vMastiles);
                imp.imprimirCasilla(String.valueOf(((BarcoMotor) aux).getPotenciaCV()), vCV);
                imp.imprimirCasilla("    --   ", vCamarotes);
            }
            System.out.println("|");
        }
        System.out.println("|" + "-".repeat(116) + "|");
    }
    
    private void inventarioA() {
        String vMatricula = "--- MATRICULA --", vEslora = "-- ESLORA --",
                vAnioFab = "-- AÑO DE FABRICACION --", vMastiles = "-- MASTILES --",
                vCV = "-- CV --", vCamarotes = "-- CAMAROTES -", vTipoBarco = "-- TIPO EMBARCACION --";

        System.out.println("|" + "-".repeat(116) + "|");
        System.out.println("|" + " ".repeat(40) + "EMBARCACIONES DISPONIBLES FER CHIKIS" + " ".repeat(40) + "|");
        System.out.println("|" + "-".repeat(116) + "|");
        System.out.println("|" + vTipoBarco + "|" + vMatricula + "|" + vEslora + "|" + vAnioFab + "|" + vMastiles + "|"
                + vCV + "|" + vCamarotes + "|");
        for (Barco aux : barcosA) {

            if (aux instanceof BarcoVelero) {
                imp.imprimirCasilla("VELERO", vTipoBarco);
                imp.imprimirCasilla(aux.getMatricula(), vMatricula);
                imp.imprimirCasilla(String.valueOf(aux.getEslora()), vEslora);
                imp.imprimirCasilla(String.valueOf(aux.getAnioFab()), vAnioFab);
                imp.imprimirCasilla(String.valueOf(((BarcoVelero) aux).getNumMastiles()), vMastiles);
                imp.imprimirCasilla("   --   ", vCV);
                imp.imprimirCasilla("    --   ", vCamarotes);
            } else if (aux instanceof BarcoYate) {
                imp.imprimirCasilla("YATE", vTipoBarco);
                imp.imprimirCasilla(aux.getMatricula(), vMatricula);
                imp.imprimirCasilla(String.valueOf(aux.getEslora()), vEslora);
                imp.imprimirCasilla(String.valueOf(aux.getAnioFab()), vAnioFab);
                imp.imprimirCasilla("   --   ", vMastiles);
                imp.imprimirCasilla(String.valueOf(((BarcoYate) aux).getPotenciaCV()), vCV);
                imp.imprimirCasilla(String.valueOf(((BarcoYate) aux).getNumCamarotes()), vCamarotes);
            } else if (aux instanceof BarcoMotor) {
                imp.imprimirCasilla("MOTOR", vTipoBarco);
                imp.imprimirCasilla(aux.getMatricula(), vMatricula);
                imp.imprimirCasilla(String.valueOf(aux.getEslora()), vEslora);
                imp.imprimirCasilla(String.valueOf(aux.getAnioFab()), vAnioFab);
                imp.imprimirCasilla("   --   ", vMastiles);
                imp.imprimirCasilla(String.valueOf(((BarcoMotor) aux).getPotenciaCV()), vCV);
                imp.imprimirCasilla("    --   ", vCamarotes);
            }
            System.out.println("|");
        }
        System.out.println("|" + "-".repeat(116) + "|");
    }
}
