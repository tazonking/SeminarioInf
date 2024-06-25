package Gestion_CSDD;

import java.util.*;

public class Administrador extends Usuario {
	
	private List<Usuario> lista_Usuarios;

    public Administrador(int id_Usuario, String nombre, String apellido, String direccion, String telefono, String email, String contraseña, String rol) {
        super(id_Usuario, nombre, apellido, direccion, telefono, email, contraseña, rol);
        this.lista_Usuarios = new ArrayList<>();
        
    }
    
    public Usuario crear_Usuario(int id_Usuario, String nombre, String apellido, Date fecha_nac, String direccion, String telefono, String email, String contraseña, String rol) {
        Usuario nuevo_Usuario = new Usuario(id_Usuario, nombre, apellido, direccion, telefono, email, contraseña, rol);
        lista_Usuarios.add(nuevo_Usuario);
        return nuevo_Usuario;
    }
        
    public boolean asignar_Permisos(int id_usuario, String nuevo_Rol) {
         for (Usuario usuario : lista_Usuarios) {
             if (usuario.getId_Usuario() == id_usuario) {
                  usuario.setRol(nuevo_Rol);
                  return true;
             }         
         }
         return false; // Retorna false si el usuario con el id especificado no se encontró    
    }

    public boolean modificar_Rol(int id_Usuario, String rol) {
        for (Usuario usuario : lista_Usuarios) {
            if (usuario.getId_Usuario() == id_Usuario) {
                usuario.setRol(rol);
                return true;
            }
        }
        return false; // Retorna false si el usuario con el id especificado no se encontró
    }
    

    public boolean eliminar_Usuario(int id_usuario) {
        for (Usuario usuario : lista_Usuarios) {
            if (usuario.getId_Usuario() == id_usuario) {
                lista_Usuarios.remove(usuario);
                return true;
            }
        }
        return false; // Retorna false si el usuario con el id especificado no se encontró
    }
}

