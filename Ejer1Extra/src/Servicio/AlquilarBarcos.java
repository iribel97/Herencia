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
                            barcos.add(new BarcoVelero(scaner.nextInt(), matricula, eslora, anio));

                        case 2:
                            System.out.print("    POTENCIA CV: ");
                            barcos.add(new BarcoMotor(scaner.nextInt(), matricula, eslora, anio));
                        default:
                            System.out.print("    POTENCIA CV: ");
                            int potencia = scaner.nextInt();
                            System.out.print("    NUMERO DE CAMAROTES: ");
                            int numCam = scaner.nextInt();
                            barcos.add(new BarcoYate(numCam, potencia, matricula, eslora, anio));
                    }
                }
            } catch (Exception e) {
                imp.mensajeE1();
                opc = 4;
            }

        } while (opc > 3);

    }

    private boolean confirmarAdmin(String contUsuario, String nombreUsu) {
        return contUsuario.equalsIgnoreCase("07Admin")
                && nombreUsu.equalsIgnoreCase("Admin");
    }

    public void Mostrar() {
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
                        System.out.print("    Usuario: ");
                        nombre = scaner.next();
                        System.out.print("    Contraseña(ID): ");
                        contra = scaner.next();
                        if (confirmarAdmin(contra, nombre)) {
                            opcAdmin();
                        }else{
                            if(clientes.isEmpty() || 
                                    !verificarCliente(nombre, contra)){
                                imp.mensajeE3();
                            }else if(verificarCliente(nombre, contra)) {
                                
                            }
                        }
                        break;
                    case 2:

                        break;
                    default:
                        imp.mensajeE1();
                }
            } catch (Exception e) {
                imp.mensajeE1();
                opc = 3;
            }
        } while (opc > 2);

    }

    private void opcAdmin() {
        int opc;
        imp.menuAdmin();
        System.out.println("     SELECCIONE UNA OPCION: ");

    }
    
    private boolean verificarCliente(String usu, String cont){
        for(Cliente aux : clientes){
            if (aux.getNombreCli().equalsIgnoreCase(usu) &&
                    aux.getIdCli().equalsIgnoreCase(cont)) {
                return true;
            }
        }
        return false;
    }
    
    private void crearUsu(){
        
    }
}
