/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Ejercicio1;

import Entidades.Animal;
import Entidades.Caballo;
import Entidades.Gato;
import Entidades.Perro;

/**
 *
 * @author irina
 */
public class Ejercicio1Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Animal perro1 = new Perro("Stich", "Carnivoro", "Doberman", 15);
        Animal perro2 = new Perro("Teddy", "Croquetas", "Chihuahua", 10);
        Animal gato = new Gato("Pelusa", "Galletas", "Siames",15);
        Animal caballo = new Caballo("Spark", "Pasto", "Fino", 25);
        
        perro1.alimentarse();
        perro2.alimentarse();
        gato.alimentarse();
        caballo.alimentarse();
        
        
    }
    
}
