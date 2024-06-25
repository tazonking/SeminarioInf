package Gestion_CSDD;

import java.util.*;

public class Club {
    private String nombre;
    private String direccion;
    private Date fundacion;
    private int cant_socios;
    private double valor_Club;

    
    public Club(String nombre, String direccion, Date fundacion, double valor_Club) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.fundacion = fundacion;
        this.valor_Club = valor_Club;
    }

    // Métodos para gestionar el club
    public void comprarClub(double monto) {
        this.valor_Club += monto;
        System.out.println("Club comprado por: " + monto);
    }

    public void venderClub(double monto) {
        if (this.valor_Club >= monto) {
            this.valor_Club -= monto;
            System.out.println("Club vendido por: " + monto);
        } else {
            System.out.println("Monto de venta excede el valor del club.");
        }
    }
    
    // GETTER Y SETTER
    
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

    public Date getFundacion() {
        return fundacion;
    }

    public void setFundacion(Date fundacion) {
        this.fundacion = fundacion;
    }

    public int getCant_socios() {
        return cant_socios;
    }

    public void setCant_socios(int cant_socios) {
        this.cant_socios = cant_socios;
    }

    public double getValor_Club() {
        return valor_Club;
    }

    public void setValor_Club(double valor_Club) {
        this.valor_Club = valor_Club;
    }
}
