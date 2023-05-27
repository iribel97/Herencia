/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.util.Scanner;

/**
 *
 * @author irina
 */
public class Electrodomestico {

   protected Scanner scaner = new Scanner(System.in);
    /*
    *Crear una superclase llamada Electrodoméstico con los siguientes atributos: precio, color,
    *consumo energético (letras entre A y F) y peso.
     */
    protected String color;
    protected double precio, peso;
    protected char consumoE;

    /*
    *Los constructores que se deben implementar son los siguientes:
    *   • Un constructor vacío.
    *   • Un constructor con todos los atributos pasados por parámetro.
     */
    public Electrodomestico() {
        this.color = "BLANCO";
        this.precio = 1000d;
        this.peso = 1d;
        this.consumoE = 'F';
    }

    public Electrodomestico(String color, double precio, double peso, char consumoE) {
        this.color = color;
        this.precio = precio;
        this.peso = peso;
        this.consumoE = consumoE;
    }

    /*
    *   • Métodos getters y setters de todos los atributos.
     */
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public char getConsumoE() {
        return consumoE;
    }

    public void setConsumoE(char consumoE) {
        this.consumoE = consumoE;
    }

 
    

    /*
    *   • Método comprobarConsumoEnergetico(char letra): comprueba que la letra es correcta,
    *       sino es correcta usara la letra F por defecto. Este método se debe invocar al crear el
    *       objeto y no será visible.
     */
    public void comprobarConsumoEnergetico(char letra) {
        switch (letra) {
            case 'A', 'B', 'C', 'D', 'E', 'F':
                this.consumoE = letra;
                break;
            default:
                this.consumoE = 'F';
                break;
        }
    }

    /*
    *   • Método comprobarColor(String color): comprueba que el color es correcto, y si no lo es,
    *       usa el color blanco por defecto. Los colores disponibles para los electrodomésticos son
    *       blanco, negro, rojo, azul y gris. No importa si el nombre está en mayúsculas o en
    *       minúsculas. Este método se invocará al crear el objeto y no será visible.
     */
    public void comprobarColor(String color) {
        switch (color.toUpperCase()) {
            case "BLANCO", "NEGRO", "ROJO", "AZUL", "GRIS":
                this.color = color;
                break;
            default:
                this.color = "BLANCO";
                break;
        }
    }

    /*
    *   • Metodo crearElectrodomestico(): le pide la información al usuario y llena el
    *       electrodoméstico, también llama los métodos para comprobar el color y el consumo. Al
    *       precio se le da un valor base de $1000.
     */
    public void crearElectrodomestico() {
        System.out.println("--------------------------------------------------");
        System.out.println("         INGRESE LA SIGUIENTE INFORMACION         ");
        System.out.println("--------------------------------------------------");
        System.out.print("   - COLOR: ");
        comprobarColor(scaner.next());
        System.out.print("   - CONSUMO ENERGETICO: ");
        comprobarConsumoEnergetico(scaner.next().toUpperCase().charAt(0));
        System.out.print("   - PESO: ");
        this.peso = scaner.nextDouble();
        System.out.println("--------------------------------------------------");
    }

    /*
    *   • Método precioFinal(): según el consumo energético y su tamaño, aumentará el valor del
    *       precio. Esta es la lista de precios:
     */
    public void precioFinal() {
        switch (this.consumoE) {
            case 'A':
                this.precio += 1000d;
                break;
            case 'B':
                this.precio += 800d;
                break;
            case 'C':
                this.precio += 600d;
                break;
            case 'D':
                this.precio += 500d;
                break;
            case 'E':
                this.precio += 300d;
                break;
            case 'F':
                this.precio += 100d;
                break;

        }

        if (this.peso <= 19) {
            this.precio += 100d;
        } else if (this.peso > 19 && this.peso <= 49) {
            this.precio += 500d;
        } else if (this.peso > 49 && this.peso <= 79) {
            this.precio += 800d;
        } else {
            this.precio += 1000d;
        }
    }

}
