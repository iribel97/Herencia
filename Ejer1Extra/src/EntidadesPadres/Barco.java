/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EntidadesPadres;

/**
 *
 * @author irina
 */
public class Barco {
    /*
    *Un Barco se caracteriza por: su matrícula, su eslora en metros y año de fabricación.
    */
    
    protected String matricula;
    protected double eslora;
    protected int anioFab;

    public Barco() {
    }

    public Barco(String matricula, double eslora, int anioFab) {
        this.matricula = matricula;
        this.eslora = eslora;
        this.anioFab = anioFab;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public double getEslora() {
        return eslora;
    }

    public void setEslora(double eslora) {
        this.eslora = eslora;
    }

    public int getAnioFab() {
        return anioFab;
    }

    public void setAnioFab(int anioFab) {
        this.anioFab = anioFab;
    }
    
    public double Modulo(){
        return (eslora*10);
    }
}
