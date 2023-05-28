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
public class Lavadora extends Electrodomestico {

    /*
    *con el atributo carga,
    *además de los atributos heredados.
     */
    private double carga;

    /*
    *   • Un constructor vacío.
    *   • Un constructor con la carga y el resto de los atributos heredados. Recuerda que debes
    *       llamar al constructor de la clase padre.
     */
    public Lavadora() {
    }

    public Lavadora(double carga, String color, double precio, double peso, char consumoE) {
        super(color, precio, peso, consumoE);
        this.carga = carga;
    }

    /*
    *   • Método get y set del atributo carga.
     */

    public double getCarga() {
        return carga;
    }

    public void setCarga(double carga) {
        this.carga = carga;
    }

    /*
    *   • Método crearLavadora (): este método llama a crearElectrodomestico() de la clase
    *       padre, lo utilizamos para llenar los atributos heredados del padre y después llenamos
    *       el atributo propio de la lavadora.
    */

    @Override
    public void crearElectrodomestico() {
        super.crearElectrodomestico();
        System.out.print("   - CARGA DE LA LAVADORA: ");
        this.carga = scaner.nextDouble();
        System.out.println("|--------------------------------------------------|");
        precioFinal();
    }
    
    /*
    *   • Método precioFinal(): este método será heredado y se le sumará la siguiente
    *       funcionalidad. Si tiene una carga mayor de 30 kg, aumentará el precio en $500, si la
    *       carga es menor o igual, no se incrementará el precio. Este método debe llamar al
    *       método padre y añadir el código necesario. Recuerda que las condiciones que hemos
    *       visto en la clase Electrodoméstico también deben afectar al precio.
    */

    @Override
    public void precioFinal() {
        super.precioFinal();
        
        if (this.carga > 30) {
            super.precio += 500d;
        }
    }
    
    
    
}
