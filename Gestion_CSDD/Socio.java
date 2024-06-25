package Gestion_CSDD;

import java.util.*;

public class Socio extends Persona {
    private int id_Socio;
    private boolean cuota_Pagada;
    private String tipo_Socio;
    private static List<Socio> lista_Socios = new ArrayList<>();

    public Socio(int id_Socio, String nombre, String apellido, String direccion, String telefono, String email, boolean cuota_Pagada, String tipo_Socio) {
    	super(nombre, apellido, direccion, telefono, email);
        this.id_Socio = id_Socio;
        this.cuota_Pagada = cuota_Pagada;
        this.tipo_Socio = tipo_Socio;
        lista_Socios.add(this);
    }

    	
	public static Socio crear_Socio(int id_Socio, String nombre, String apellido, String direccion, String telefono, String email, 
			                        boolean cuota_Pagada, String tipo_socio) {
        Socio nuevo_Socio = new Socio(id_Socio, nombre, apellido, direccion, telefono, email, cuota_Pagada, tipo_socio);
        return nuevo_Socio;
	}

	public static Socio modificar_Socio(int socio_id, String nombre, String apellido, String direccion, String telefono, String email, 
                                        String tipo_socio) {
        for (Socio socio : lista_Socios) {
            if (socio.getId_Socio() == socio_id) {
                socio.setNombre(nombre);
                socio.setApellido(apellido);
                socio.setDireccion(direccion);
                socio.setTelefono(telefono);
                socio.setEmail(email);                
                socio.setTipo_Socio(tipo_socio);
                return socio;
            }            
        }  
        return null; // Retornar null si no se encuentra el socio
	}
	
	public static Socio consultar_Socio(int socio_id) {
        for (Socio socio : lista_Socios) {
            if (socio.getId_Socio() == socio_id) {
                return socio;
            }
        }
        return null; // Retornar null si no se encuentra el socio
	}

	public static boolean eliminar_Socio(int socio_id) {
        Iterator<Socio> iterator = lista_Socios.iterator();
        while (iterator.hasNext()) {
            Socio socio = iterator.next();
            if (socio.getId_Socio() == socio_id) {
                iterator.remove();
                return true; // Retornar true si se elimina el socio
            }
        }
        return false; // Retornar false si no se encuentra el socio
    }

	public double obtener_Descuento() {
        switch (this.tipo_Socio) {
            case "full":
                return 0.20; // 20% de descuento
            case "protector":
                return 0.10; // 10% de descuento
            case "vitalicio":
            default:
                return 0.0; // Sin descuento
        }
    }

	 public void pagar_Cuota(double monto) {
	        if (monto >= calcular_Cuota()) {
	            this.cuota_Pagada = true;
	            registrar_Transaccion(monto);
	            System.out.println("Cuota pagada exitosamente.");
	        } else {
	            System.out.println("Monto insuficiente para pagar la cuota.");
	            }
	 }
	 private double calcular_Cuota() {
	      // Supongamos que la cuota base es de 7000.00
	      return 7000.00;
	 }

	 private void registrar_Transaccion(double monto) {
	      // Aquí se implementaría registrar_transacción de la Clase Transacciones
	      // Por ejemplo, guardar en una lista de transacciones o en una base de datos
	      System.out.println("Transacción registrada por el monto: " + monto);
	 }

    
    //GETTER Y SETTER
    
    public int getId_Socio() {
        return id_Socio;
    }

    public void setId_Socio(int id_Socio) {
        this.id_Socio = id_Socio;
    }
    public boolean isCuotaPagada() {
        return cuota_Pagada;
    }
    
    public void setCuota_Pagada(boolean cuota_Pagada) {
        this.cuota_Pagada = cuota_Pagada;
    }
    public String getTipo_Socio() {
        return tipo_Socio;
    }
    
    public void setTipo_Socio(String tipo_Socio) {
        this.tipo_Socio = tipo_Socio;
    }
    
    
}
   