/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicio;

import Entidades.Circulo;
import Entidades.Rectangulo;
import java.util.Scanner;

/**
 *
 * @author irina
 */
public class ServFormas {

    Circulo circle = new Circulo();
    Rectangulo rectangle = new Rectangulo();

    Scanner scaner = new Scanner(System.in);

    public void pedirFormas() {
        int opcUsu;
        do {
            System.out.println("|-------------------------------------------------|");
            System.out.println("|              CALCULEMOS LAS FORMAS              |");
            System.out.println("|-------------------------------------------------|");
            System.out.println("|    1.- CIRCULO                                  |");
            System.out.println("|    2.- RECTANGULO                               |");
            System.out.println("|-------------------------------------------------|");
            System.out.print("   SELECCIONE UNA FIGURA O 3 PARA SALIR: ");
            opcUsu = scaner.nextInt();
            switch (opcUsu) {
                case 1:
                    opc1();
                    break;
                case 2:
                    opc2();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("|-------------------------------------------------|");
                    System.out.println("|      OPCION INCORRECTA, INTENTELO DE NUEVO      |");
                    System.out.println("|-------------------------------------------------|");
            }
        } while (opcUsu != 3);

    }
    
    
    private void opc1(){
        System.out.println("|-------------------------------------------------|");
        System.out.println("|       POR FAVOR, INGRESE EL SIGUIENTE DATO      |");
        System.out.println("|-------------------------------------------------|");
        System.out.print("    > RADIO: ");
        circle.setRadio(scaner.nextDouble());
        System.out.println("|-------------------------------------------------|");
        System.out.printf("|      EL PERIMETRO ES: %.2f                     | \n", circle.Perimetro());
        System.out.println("|-------------------------------------------------|");
        System.out.printf("|      EL AREA ES: %.2f                          | \n", circle.Area());
        System.out.println("|-------------------------------------------------|");
        
    }
    
    private void opc2(){
        System.out.println("|-------------------------------------------------|");
        System.out.println("|       POR FAVOR, INGRESE EL SIGUIENTE DATO      |");
        System.out.println("|-------------------------------------------------|");
        System.out.print("    > BASE: ");
        rectangle.setBase(scaner.nextDouble());
        System.out.print("    > ALTURA: ");
        rectangle.setHigh(scaner.nextDouble());
        System.out.println("|-------------------------------------------------|");
        System.out.printf("|      EL PERIMETRO ES: %.2f                       | \n", rectangle.Perimetro());
        System.out.println("|-------------------------------------------------|");
        System.out.printf("|      EL AREA ES: %.2f                       | \n", rectangle.Area());
        System.out.println("|-------------------------------------------------|");
    }
}
