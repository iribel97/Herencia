/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EntidadesHijas;

/**
 *
 * @author irina
 */
public final class BarcoYate extends BarcoMotor{
    
    /*
    *   • Potencia en CV y número de camarotes para yates de lujo.
    ---> Como BarcoMotor ya tiene como atributo la potencia, es mejor heredarla a esta clase
    */
    
    private int numCamarotes;

    public BarcoYate() {
    }

    public BarcoYate(int numCamarotes, int potenciaCV, String matricula, double eslora, int anioFab) {
        super(potenciaCV, matricula, eslora, anioFab);
        this.numCamarotes = numCamarotes;
    }

    public int getNumCamarotes() {
        return numCamarotes;
    }

    public void setNumCamarotes(int numCamarotes) {
        this.numCamarotes = numCamarotes;
    }

    @Override
    public double Modulo() {
        return (super.Modulo() + numCamarotes); 
    }

    
    
    
}
