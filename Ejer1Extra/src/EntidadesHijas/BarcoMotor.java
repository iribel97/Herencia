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
public class BarcoMotor extends Barco{
    
    /*
    *   • Potencia en CV para barcos a motor.
    */
    
    protected int potenciaCV;

    public BarcoMotor() {
    }

    public BarcoMotor(int potenciaCV, String matricula, double eslora, int anioFab) {
        super(matricula, eslora, anioFab);
        this.potenciaCV = potenciaCV;
    }

    public int getPotenciaCV() {
        return potenciaCV;
    }

    public void setPotenciaCV(int potenciaCV) {
        this.potenciaCV = potenciaCV;
    }

    @Override
    public double Modulo() {
        return (super.Modulo() + potenciaCV);
    }
    
    
    
}
