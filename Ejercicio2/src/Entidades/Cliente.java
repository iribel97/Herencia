/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.util.ArrayList;

/**
 *
 * @author irina
 */
public class Cliente {
    private String nombre, apellido, id;
//    private ArrayList<Electrodomestico> compras = new ArrayList();

    public Cliente() {
        
    }

    public Cliente(String nombre, String apellido, String id /*, ArrayList<Electrodomestico> compras*/) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.id = id;
//        this.compras = compras;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

//    public ArrayList<Electrodomestico> getCompras() {
//        return compras;
//    }
//
//    public void setCompras(Electrodomestico electrodomestico) {
//        this.compras.add(electrodomestico);
//    }
    
    
}
