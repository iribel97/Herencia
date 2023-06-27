/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicio;

/**
 *
 * @author irina
 */
public class Imprimibles {

    public void Bienvenida() {
        System.out.println("|--------------------------------------------------|");
        System.out.println("|     BIENVENIDOS A EMBARCACIONES FER CHIQUITO     |");
        System.out.println("|--------------------------------------------------|");
        System.out.println("|   1.- INICIAR SESION                             |");
        System.out.println("|   2.- REGISTRARSE                                |");
        System.out.println("|--------------------------------------------------|");
    }

    public void menuB() {
        System.out.println("|--------------------------------------------------|");
        System.out.println("|             VAMOS A AGREGAR UN BARCO             |");
        System.out.println("|--------------------------------------------------|");
        System.out.println("|     1.- BARCO VELERO                             |");
        System.out.println("|     2.- BARCO MOTOR                              |");
        System.out.println("|     3.- YATE                                     |");
        System.out.println("|--------------------------------------------------|");
    }
    
    public void menuAdmin(){
        System.out.println("|--------------------------------------------------|");
        System.out.println("| MUCHO GUSTO TERNERTE DE NUEVO CON NOSOTROS IRINA |");
        System.out.println("|--------------------------------------------------|");
        System.out.println("|    1.- AÑADIR EMBARCACION                        |");
        System.out.println("|    2.- VER EMBARCACIONES ARRENDADAS              |");
        System.out.println("|    3.- VER EMBARCACIONES NO ARRENDADAS           |");
        System.out.println("|    4.- VER EMBARCACIONES                         |");
        System.out.println("|    5.- SALIR                                     |");
        System.out.println("|--------------------------------------------------|");
    }
  
// ERRORES ---------------------------------------------------------------------------
    public void mensajeE1() {
        System.out.println("|--------------------------------------------------|");
        System.out.println("| OPCION DIGITADA NO PERTENECE A LAS OPCIONES      |");
        System.out.println("|--------------------------------------------------|");
    }

    public void mensajeE2() {
        System.out.println("|--------------------------------------------------|");
        System.out.println("| YA EXISTE OTRO BARCO CON LA MISMA MATRICULA,     |");
        System.out.println("| INTENTELO NUEVAMENTE                             |");
        System.out.println("|--------------------------------------------------|");
    }
    
    public void mensajeE3() {
        System.out.println("|--------------------------------------------------|");
        System.out.println("| NO SE ENCUENTRA REGISTRADO/A EN NUESTRA          |");
        System.out.println("| BASE DE DATOS                                    |");
        System.out.println("|--------------------------------------------------|");
    }
    
// CASILLAS TABLA --------------------------------------------------------------------
    public void imprimirCasilla(String nombre, String variable) {
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
