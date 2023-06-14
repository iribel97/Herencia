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
        boolean bandera = false;
        do {
            System.out.println("|--------------------------------------------------|");
            System.out.println("|             VAMOS A AGREGAR UN BARCO             |");
            System.out.println("|--------------------------------------------------|");
            System.out.println("|     1.- BARCO VELERO                             |");
            System.out.println("|     2.- BARCO MOTOR                              |");
            System.out.println("|     3.- YATE                                     |");
            System.out.println("|--------------------------------------------------|");
            System.out.print("   SELECCIONE TIPO DE BARCO A AGREGAR: ");
            opc = scaner.nextInt();
            System.out.println("|--------------------------------------------------|");
            System.out.println("|               INGRESEMOS LOS DATOS               |");
            System.out.println("|--------------------------------------------------|");
            if (opc > 3) {
                System.out.println("|--------------------------------------------------|");
                System.out.println("|   OPCION INCORRECTA, INTENTELO DE NUEVO          |");
                System.out.println("|--------------------------------------------------|");
            } else {
                do {
                    System.out.print("    MATRICULA: ");
                    matricula = scaner.next();
                    for (Barco barco : barcos) {
                        if (barco.getMatricula().equalsIgnoreCase(matricula)) {
                            bandera = true;
                            break;
                        }
                    }
                    if (bandera) {
                        System.out.println("|--------------------------------------------------|");
                        System.out.println("| YA EXISTE OTRO BARCO CON LA MISMA MATRICULA,     |");
                        System.out.println("| INTENTELO NUEVAMENTE                             |");
                        System.out.println("|--------------------------------------------------|");
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
        } while (opc > 3);

    }

    private boolean confirmarAdmin(String usuario) {
        return usuario.equalsIgnoreCase("ADMIN");
    }

    public void Mostrar() {
        int opc;
        do {
            System.out.println("|--------------------------------------------------|");
            System.out.println("|     BIENVENIDOS A EMBARCACIONES FER CHIQUITO     |");
            System.out.println("|--------------------------------------------------|");
            System.out.println("|   1.- INICIAR SESION                             |");
            System.out.println("|   2.- REGISTRARSE                                |");
            System.out.println("|--------------------------------------------------|");
            try {
                System.out.print("   SELECCIONE UNA OPCION: ");
                opc = scaner.nextInt();
                if (opc > 2) {
                    System.out.println("|--------------------------------------------------|");
                    System.out.println("| OPCION DIGITADA NO PERTENECE A LAS OPCIONES      |");
                    System.out.println("|--------------------------------------------------|");
                }
            } catch (Exception e) {
                System.out.println("|--------------------------------------------------|");
                System.out.println("| OPCION DIGITADA NO PERTENECE A LAS OPCIONES      |");
                System.out.println("|--------------------------------------------------|");
                opc = 3;
            }
        } while (opc > 2);

    }
}
