/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import Interfaces.CalculosDeFormas;

/**
 *
 * @author irina
 */
public class Circulo implements CalculosDeFormas {

    private double radio;

    public Circulo() {
    }

    public Circulo(double radio) {
        this.radio = radio;
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    @Override
    public double Area() {
        double calculoA;
        calculoA = Pi * Math.pow(radio, 2);
        return calculoA;
    }

    @Override
    public double Perimetro() {
        double calculoP;
        calculoP = Pi * 2 * radio;
        return calculoP;
    }

}
