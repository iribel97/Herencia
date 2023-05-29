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
public class Rectangulo implements CalculosDeFormas {

    private double base, high;

    public Rectangulo() {
    }

    public Rectangulo(double base, double high) {
        this.base = base;
        this.high = high;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    @Override
    public double Area() {
        double calcularA;
        calcularA = base * high;
        return calcularA;
    }

    @Override
    public double Perimetro() {
        double calcularP;
        calcularP = (base + high) * 2;

        return calcularP;
    }

}
