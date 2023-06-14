/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EntidadesHijas;

import EntidadesPadres.Barco;

/**
 *
 * @author irina
 */
public final class BarcoVelero extends Barco{
    
    /*
    *   • Número de mástiles para veleros.
    */
    
    private int numMastiles;

    public BarcoVelero() {
    }

    public BarcoVelero(int numMastiles, String matricula, double eslora, int anioFab) {
        super(matricula, eslora, anioFab);
        this.numMastiles = numMastiles;
    }

    public int getNumMastiles() {
        return numMastiles;
    }

    public void setNumMastiles(int numMastiles) {
        this.numMastiles = numMastiles;
    }

    @Override
    public double Modulo() {
        return (super.Modulo() + numMastiles);
    }
    
    
    
}
