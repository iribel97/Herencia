/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EntidadesHijas;

import Entidades.Electrodomestico;

/**
 *
 * @author irina
 */
public class Televisor extends Electrodomestico {

    /*
    *resolución (en pulgadas) y sintonizador TDT (booleano),
     */

    private double tamanio;
    private boolean tdt;

    /*
    *Los constructores que se implementarán serán:
    *   • Un constructor vacío.
    *   • Un constructor con la resolución, sintonizador TDT y el resto de los atributos
    *       heredados. Recuerda que debes llamar al constructor de la clase padre.
     */

    public Televisor() {
    }

    public Televisor(double tamanio, boolean tdt, String color, double precio, double peso, char consumoE) {
        super(color, precio, peso, consumoE);
        this.tamanio = tamanio;
        this.tdt = tdt;
    }
    
    /*
    *Los métodos que se implementara serán:
    *   • Método get y set de los atributos resolución y sintonizador TDT.
    *   • Método crearTelevisor(): este método llama a crearElectrodomestico() de la clase
    *       padre, lo utilizamos para llenar los atributos heredados del padre y después llenamos
    *       los atributos del televisor.
    *   • Método precioFinal(): este método será heredado y se le sumará la siguiente
    *       funcionalidad. Si el televisor tiene una resolución mayor de 40 pulgadas, se
    *       incrementará el precio un 30% y si tiene un sintonizador TDT incorporado, aumentará
    *       $500. Recuerda que las condiciones que hemos visto en la clase Electrodomestico
    *       también deben afectar al precio.
    */

    public double getTamanio() {
        return tamanio;
    }

    public void setTamanio(double tamanio) {
        this.tamanio = tamanio;
    }

    public boolean isTdt() {
        return tdt;
    }

    public void setTdt(boolean tdt) {
        this.tdt = tdt;
    }

    @Override
    public void crearElectrodomestico() {
        super.crearElectrodomestico();
        System.out.print("   - TAMAÑO: ");
        tamanio = scaner.nextDouble();
        System.out.print("   - TIENE SINTONIZADOR TDT (Si/No): ");
        String opc = scaner.next().toUpperCase();
        System.out.println("|--------------------------------------------------|");
        tdt = opc.equalsIgnoreCase("si");
        precioFinal();
    }

    @Override
    public void precioFinal() {
        super.precioFinal();
        
        if (tamanio > 40) {
            super.precio *= 1.3;
        }
        
        if (tdt) {
            super.precio += 500;
        }
    }
    
    
    
}
