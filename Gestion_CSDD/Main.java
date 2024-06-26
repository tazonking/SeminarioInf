package Gestion_CSDD;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Club club = new Club("Club Social y Deportivo Dolavon", "Av. Principal 123", new Date(), 1000000.0);

        while (true) {
            System.out.println("\n----- Menú Principal -----");
            System.out.println("1. Gestionar Socios");
            //System.out.println("2. Gestionar Administradores");
            System.out.println("3. Comprar Club");
            System.out.println("4. Vender Club");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir nueva línea

            switch (opcion) {
                case 1:
                    gestionar_Socios(club, scanner);
                    break;
                /*case 2:
                    gestionar_Administradores(club, scanner);
                    break;*/
                case 4:
                    System.out.print("Ingrese el monto para comprar el club: ");
                    double compra_Monto = scanner.nextDouble();
                    club.comprar_Club(compra_Monto);
                    break;
                case 5:
                    System.out.print("Ingrese el monto para vender el club: ");
                    double venta_Monto = scanner.nextDouble();
                    club.vender_Club(venta_Monto);
                    break;
                case 6:
                    System.out.println("Saliendo del sistema...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }

    public static void gestionar_Socios(Club club, Scanner scanner) {
        while (true) {
            System.out.println("\n--- Menú Socios ---");
            System.out.println("1. Agregar Socio");
            System.out.println("2. Modificar Datos de un Socio");            
            System.out.println("3. Consultar por Socio");
            System.out.println("4. Eliminar Socio");
            System.out.println("5. Pagar Cuota");
            System.out.println("6. Volver al Menú Principal");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir nueva línea

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese ID del Socio: ");
                    String id_socstr = scanner.nextLine();
                    int Id_socio = Integer.parseInt(id_socstr); 
                    scanner.nextLine(); // Consumir nueva línea
                    System.out.print("Ingrese Nombre del Socio: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese Apellido del Socio: ");
                    String apellido = scanner.nextLine();
                    System.out.print("Ingrese Dirección del Socio: ");
                    String direccion = scanner.nextLine();
                    System.out.print("Ingrese Teléfono del Socio: ");
                    String telefono = scanner.nextLine();
                    System.out.print("Ingrese Email del Socio: ");
                    String email = scanner.nextLine();
                    System.out.print("Ingrese Tipo de Socio: ");
                    String tipo_socio = scanner.nextLine();
                    Socio.crear_Socio(Id_socio, nombre, apellido, direccion, telefono, email, false, tipo_socio);
                    break;
                case 2:
                	 System.out.print("Ingrese ID del Socio a modificar: ");
                	 String id_socmodif = scanner.nextLine();
                     int id_sociomod = Integer.parseInt(id_socmodif);
                     System.out.print("Ingrese Nombre del Socio: ");
                     String nuevo_nombre = scanner.nextLine();
                     System.out.print("Ingrese Apellido del Socio: ");
                     String nuevo_apellido = scanner.nextLine();
                     System.out.print("Ingrese Dirección del Socio: ");
                     String nueva_direccion = scanner.nextLine();
                     System.out.print("Ingrese Teléfono del Socio: ");
                     String nueva_telefono = scanner.nextLine();
                     System.out.print("Ingrese Email del Socio: ");
                     String nuevo_email = scanner.nextLine();
                     System.out.print("Ingrese Tipo de Socio: ");
                     String nuevo_tipo_socio = scanner.nextLine();
                     Socio.modificar_Socio(id_sociomod, nuevo_nombre, nuevo_apellido, nueva_direccion, nueva_telefono, nuevo_email, nuevo_tipo_socio);
                     break;
                case 3:
                	System.out.print("Ingrese ID del Socio a consultar: ");
                	String id_soccon = scanner.nextLine();
                    int id_socioconsul = Integer.parseInt(id_soccon);
                    Socio socio_Consultado = Socio.consultar_Socio(id_socioconsul);
                    if (socio_Consultado != null) {
                        System.out.println("ID: " + socio_Consultado.getId_Socio());
                        System.out.println("Nombre: " + socio_Consultado.getNombre());
                        System.out.println("Apellido: " + socio_Consultado.getApellido());
                        System.out.println("Dirección: " + socio_Consultado.getDireccion());
                        System.out.println("Teléfono: " + socio_Consultado.getTelefono());
                        System.out.println("Email: " + socio_Consultado.getEmail());
                        System.out.println("Cuota Pagada: " + socio_Consultado.isCuotaPagada());
                        System.out.println("Tipo de Socio: " + socio_Consultado.getTipo_Socio());
                        
                    } else {
                        System.out.println("Socio no encontrado.");
                    }
                    break;
                case 4:
                	System.out.print("Ingrese ID del Socio a eliminar: ");
                	String id_socelim = scanner.nextLine();
                    int id_socioelimin = Integer.parseInt(id_socelim);
                    if (Socio.eliminar_Socio(id_socioelimin)) {
                        System.out.println("Socio eliminado exitosamente.");
                    } else {
                        System.out.println("Socio no encontrado.");
                    }
                    break;
                case 5:
                	System.out.print("Ingrese ID del Socio que paga cuota: ");
                	String id_socpaga = scanner.nextLine();
                    int id_sociopaga = Integer.parseInt(id_socpaga);
                    Socio socioPaga = Socio.consultar_Socio(id_sociopaga);
                    if (socioPaga != null) {
                        socioPaga.pagar_Cuota(id_sociopaga);
                        System.out.println("Cuota pagada exitosamente para el socio ID: " + id_sociopaga);
                    } else {
                        System.out.println("Socio no encontrado.");
                    }
                    break;
                case 6:                	
                    return;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }
}

   
    /*public static void gestionar_Administradores(Club club, Scanner scanner) {
    	
    	
        while (true) {
            System.out.println("\n--- Menú Administradores ---");
            System.out.println("1. Crear Usuario");
            System.out.println("2. Asignar Permisos");
            System.out.println("3. Modificar rol del Usuario");
            System.out.println("4. Eliminar Usuario");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir nueva línea

            switch (opcion) {
                case 1:
                	System.out.print("Ingrese el ID del Administrador: ");                	
                    String id_str = scanner.nextLine();
                    int Id_Admin = Integer.parseInt(id_str);               
                    System.out.print("Ingrese Nombre del Usuario: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese Apellido del Usuario: ");
                    String apellido = scanner.nextLine();
                    System.out.print("Ingrese Dirección del Usuario: ");
                    String direccion = scanner.nextLine();
                    System.out.print("Ingrese Teléfono del Usuario: ");
                    String telefono = scanner.nextLine();
                    System.out.print("Ingrese Email del Usuario: ");
                    String email = scanner.nextLine();
                    System.out.print("Ingrese Contraseña del Usuario: ");
                    String contraseña = scanner.nextLine();
                    System.out.print("indicar si es Usuario o Administrador: ");
                    String tipo_us = scanner.nextLine();                    
                    Administrador nuevoAdmin = new Administrador(Id_Admin, nombre, apellido, direccion, telefono, email, contraseña, tipo_us);                    
                    nuevoAdmin.crear_Usuario(Id_Admin, nombre, apellido, direccion, telefono, email, contraseña, tipo_us);
                    break;
                case 2:
                	 if (nuevoAdmin.getLista_Usuarios().isEmpty()) {
                         System.out.println("No hay usuarios creados para asignar permisos.");
                         break;
                     }

                     System.out.print("Ingrese el ID del Usuario a modificar el Rol: ");
                     int admin_id = scanner.nextInt();
                     scanner.nextLine();  // Consumir nueva línea
                     System.out.print("Ingrese Nuevo Rol del Usuario: ");
                     String nuevoRol = scanner.nextLine();
                     
                     if (nuevoAdmin.asignar_Permisos(admin_id, nuevoRol)) {
                         System.out.println("Rol del usuario modificado exitosamente.");
                     } else {
                         System.out.println("Usuario no encontrado.");
                     }
                     break;
                case 3:
                	
                	
                case 4:
                	System.out.print("Ingrese ID del Administrador a eliminar: ");
                	String id_User1 = scanner.nextLine();
                    int id_userElim = Integer.parseInt(id_User1);
                    if (nuevoAdmin.eliminar_Usuario(id_userElim)) {
                        System.out.println("Socio eliminado exitosamente.");
                    } else {
                        System.out.println("Socio no encontrado.");
                    }
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }
}*/


