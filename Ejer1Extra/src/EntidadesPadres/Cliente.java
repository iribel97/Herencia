/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EntidadesPadres;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author irina
 */
public class Cliente {
    /*
    *Para cada Alquiler se guarda: el
    *nombre, documento del cliente, la fecha de alquiler, fecha de devolución, la posición del
    *amarre y el barco que lo ocupará.
    */
    
    private String nombreCli, IdCli;
    private LocalDate fechaAlqu, fechaDev;
    private int posicionAm;
    Barco boat;

    public Cliente() {
    }

    public Cliente(String nombreCli, String IdCli) {
        this.nombreCli = nombreCli;
        this.IdCli = IdCli;
        this.fechaAlqu = LocalDate.of(2000, 1, 1);
        this.fechaDev = LocalDate.of(2000, 1, 8);
        this.posicionAm = 0;
        this.boat = new Barco();
    }

    public Cliente(String nombreCli, String IdCli, LocalDate fechaAlqu, LocalDate fechaDev, int posicionAm, Barco boat) {
        this.nombreCli = nombreCli;
        this.IdCli = IdCli;
        this.fechaAlqu = fechaAlqu;
        this.fechaDev = fechaDev;
        this.posicionAm = posicionAm;
        this.boat = boat;
    }

    public String getNombreCli() {
        return nombreCli;
    }

    public void setNombreCli(String nombreCli) {
        this.nombreCli = nombreCli;
    }

    public String getIdCli() {
        return IdCli;
    }

    public void setIdCli(String IdCli) {
        this.IdCli = IdCli;
    }

    public LocalDate getFechaAlqu() {
        return fechaAlqu;
    }

    public void setFechaAlqu(LocalDate fechaAlqu) {
        this.fechaAlqu = fechaAlqu;
    }

    public LocalDate getFechaDev() {
        return fechaDev;
    }

    public void setFechaDev(LocalDate fechaDev) {
        this.fechaDev = fechaDev;
    }

    public int getPosicionAm() {
        return posicionAm;
    }

    public void setPosicionAm(int posicionAm) {
        this.posicionAm = posicionAm;
    }

    public Barco getBoat() {
        return boat;
    }

    public void setBoat(Barco boat) {
        this.boat = boat;
    }
    
    public double totalPag(){
        return ((ChronoUnit.DAYS.between(fechaAlqu, fechaDev)) * boat.Modulo());
    }
    
}
