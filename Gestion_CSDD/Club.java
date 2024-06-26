package Gestion_CSDD;

import java.util.Date;

public class Club {
    private String nombre;
    private String direccion;
    private Date fecha_Fundacion;
    private double capital;

    public Club(String nombre, String direccion, Date fecha_Fundacion, double capital) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.fecha_Fundacion = fecha_Fundacion;
        this.capital = capital;
    }

    // Getters y Setters
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFechaFundacion() {
        return fecha_Fundacion;
    }

    public void setFechaFundacion(Date fechaFundacion) {
        this.fecha_Fundacion = fechaFundacion;
    }

    public double getCapital() {
        return capital;
    }

    public void setCapital(double capital) {
        this.capital = capital;
    }

    // Métodos adicionales específicos del club, como comprar y vender el club, etc.
    public void comprar_Club(double monto) {
        this.capital += monto;
        System.out.println("Club comprado por un monto de: " + monto);
    }

    public void vender_Club(double monto) {
        if (monto <= this.capital) {
            this.capital -= monto;
            System.out.println("Club vendido por un monto de: " + monto);
        } else {
            System.out.println("No se puede vender el club por falta de fondos suficientes.");
        }
    }
}