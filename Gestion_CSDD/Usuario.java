package Gestion_CSDD;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class Usuario extends Persona {
    private int id_Usuario;
    private String contraseña;
    private String tipo_Usuario;

    public Usuario(int usuario_id, String nombre, String apellido, String direccion, String telefono, String email, String contraseña, String rol) {
        super(nombre, apellido, direccion, telefono, email);
        this.id_Usuario = usuario_id;
        this.contraseña = contraseña;
        this.tipo_Usuario = rol;
    }

    public boolean autenticar_Usuario(String correo, String password) {
    	
    	return this.email.equals(correo) && this.contraseña.equals(password);
    }

    public void cambiar_Contrasena(String nueva_Contraseña) {
        this.contraseña = nueva_Contraseña;
    }

    public void solicitarAyuda() {
    	
        String mensajeAyuda = "Solicitud de ayuda del usuario: " + this.nombre + " " + this.apellido + ", Email: " + this.email;
        System.out.println(mensajeAyuda);

        // Registro la solicitud de ayuda en un archivo de texto
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("solicitudes_ayuda.txt", true))) {
            writer.write(mensajeAyuda);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error al registrar la solicitud de ayuda: " + e.getMessage());
        }
    }    
    
    public int getId_Usuario() {
        return id_Usuario;
    }

    public void setId_Usuario(int identificador) {
        this.id_Usuario = identificador;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String pass) {
        this.contraseña = pass;
    }
    public String getRol() {
        return tipo_Usuario;
    }

    public void setRol(String rol) {
        this.tipo_Usuario = rol;
    }
}

