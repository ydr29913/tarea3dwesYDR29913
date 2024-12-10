package com.ydr29913.tarea3dwesydr29913.fachada;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ydr29913.tarea3dwesydr29913.modelo.Credenciales;
import com.ydr29913.tarea3dwesydr29913.modelo.Persona;
import com.ydr29913.tarea3dwesydr29913.modelo.Planta;
import com.ydr29913.tarea3dwesydr29913.servicios.ServiciosCredenciales;
import com.ydr29913.tarea3dwesydr29913.servicios.ServiciosEjemplar;
import com.ydr29913.tarea3dwesydr29913.servicios.ServiciosMensaje;
import com.ydr29913.tarea3dwesydr29913.servicios.ServiciosPersona;
import com.ydr29913.tarea3dwesydr29913.servicios.ServiciosPlanta;


public class Fachada {

	private ServiciosPlanta servplant;
	private ServiciosEjemplar servejemplar;
	private ServiciosPersona servpersona;
	private ServiciosCredenciales servcredenciales;
	private ServiciosMensaje servmensaje;
    private Credenciales usuarioAutenticado;
    
    
    @Autowired
    public Fachada(ServiciosPlanta servplant, ServiciosEjemplar servejemplar, ServiciosCredenciales servcredenciales, ServiciosPersona servpersona, ServiciosMensaje servmensaje) {
    	this.servplant = servplant;
    	this.servejemplar = servejemplar;
    	this.servcredenciales = servcredenciales;
    	this.servpersona = servpersona;
    	this.servmensaje = servmensaje;
    }
    
    
	//Menu principal
	public void mostrarMenu() {
        Scanner sc = new Scanner(System.in);

        int opcion = 0;

        do {
            try {
                System.out.println("\n\n\n\t\t\tGESTION DE VIVERO\n");
                System.out.println("\t\t\t\t1 - LOGIN");
                System.out.println("\t\t\t\t2 - VER PLANTAS");
                System.out.println("\t\t\t\t3 - ..............");
                System.out.println("\t\t\t\t4 - ..............");
                System.out.println("\t\t\t\t5 - ..............");
                System.out.println("\t\t\t\t9 - SALIR");

                opcion = sc.nextInt();
                switch (opcion) {
                    case 1:
                        menuLogin();
                        break;
                    case 2:
                        verPlantas();
                        break;
                    case 9:
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes introducir un número entero");
                sc.nextLine();
            }
        } while (opcion != 9);
    }
	
	//Metodo para ver las plantas
	public void verPlantas() {
        List<Planta> plantas = servplant.obtenerPlantasOrdenadasAlfabeticamente();
        System.out.println("\n\tLISTA DE PLANTAS:\n");
        for (Planta planta : plantas) {
            System.out.println("\t\tNombre Común: " + planta.getNombreComun() + "\t\t | Nombre Científico: " + planta.getNombreCientifico());
        }
    }
    
	
	//Menu para logearse
	public void menuLogin() {
		Scanner sc = new Scanner(System.in);

		int opcion = 0;

		do {
			try {
				System.out.println("\n\n\n\t\t\tLOGIN\n");
				System.out.println("\t\t\t\t1 - PERSONAL");
				System.out.println("\t\t\t\t2 - ADMINISTRADOR GENERAL");
				System.out.println("\t\t\t\t9 - SALIR");

				opcion = sc.nextInt();
				switch (opcion) {
				case 1:
					// logearse();
					break;
				case 2:
					autenticarse();
					break;
				case 9:
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("Debes introducir un número entero");
				sc.nextLine();
			}
		} while (opcion != 9);
	}
	

	//Metodo para autentificarse
    public void autenticarse() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce tu nombre de usuario: ");
        String usuario = sc.nextLine();
        System.out.print("Introduce tu contraseña: ");
        String contrasena = sc.nextLine();

        Credenciales credenciales = servcredenciales.autenticarUsuario(usuario, contrasena);
        if (credenciales != null) {
            usuarioAutenticado = credenciales;
            System.out.println("Autenticación exitosa. Bienvenido, " + usuario + "!");
            menuAdmin();
        } else {
            System.out.println("Usuario o contraseña incorrectos.");
        }
    }
    

    //Menu para Administradores
    public void menuAdmin() {
        Scanner sc = new Scanner(System.in);

        int opcion = 0;

        do {
            try {
                System.out.println("\n\n\n\t\t\tGESTION DE VIVERO (ADMIN)\n");
                System.out.println("\t\t\t\t1 - LOGIN");
                System.out.println("\t\t\t\t2 - VER PLANTAS");
                System.out.println("\t\t\t\t3 - REGISTRAR UNA PERSONA");
                System.out.println("\t\t\t\t4 - INSERTAR NUEVA PLANTA");
                System.out.println("\t\t\t\t5 - MODIFICAR PLANTA");
                System.out.println("\t\t\t\t6 - MENU GESTION DE EJEMPLARES");
                System.out.println("\t\t\t\t9 - SALIR");

                opcion = sc.nextInt();
                switch (opcion) {
                    case 1:
                        menuLogin();
                        break;
                    case 2:
                        verPlantas();
                        break;
                    case 3:
                    	registrarNuevaPersona();
                    	break;
                    case 4:
                    	insertarNuevaPlanta();
                    	break;
                    case 5:
                    	modificarPlanta();
                    	break;
                    case 6:
                    	//menuGestionEjemplares(null);
                    	break;
                    case 9:
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes introducir un número entero");
                sc.nextLine();
            }
        } while (opcion != 9);
    }
	
	//Metodo para registrar a una persona (modo admin)
	public void registrarNuevaPersona() {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Introduzca el nombre completo de la persona:");
        String nombre = sc.nextLine();
        
        System.out.println("Introduzca el email de la persona:");
        String email = sc.nextLine();
        
        if (!servpersona.validarEmail(email)) {
            System.out.println("ERROR: El email ya está registrado.");
            return;
        }

        System.out.println("Introduzca el nombre de usuario:");
        String usuario = sc.nextLine();
        
        if (!servcredenciales.validarUsuario(usuario)) {
            System.out.println("ERROR: El nombre de usuario no está disponible.");
            return;
        }

        System.out.println("Introduzca la contraseña:");
        String password = sc.nextLine();

        Persona persona = new Persona();
        persona.setNombre(nombre);
        persona.setEmail(email);
        
        Credenciales credenciales = new Credenciales();
        credenciales.setUsuario(usuario);
        credenciales.setPassword(password);
        
        servpersona.insertarPersona(persona);
        servcredenciales.insertarCredenciales(credenciales);
        
        System.out.println("¡Persona registrada correctamente!");
    }
	
	public void insertarNuevaPlanta() {
	    Scanner sc = new Scanner(System.in);

	    System.out.println("Introduce el código de la planta:");
	    String codigoPlanta = sc.nextLine();

	    if (servplant.existePlantaPorCodigo(codigoPlanta)) {
	        System.out.println("ERROR: Ya existe una planta con este código.");
	        return;
	    }

	    System.out.println("Introduce el nombre común de la planta:");
	    String nombreComun = sc.nextLine();

	    System.out.println("Introduce el nombre científico de la planta:");
	    String nombreCientifico = sc.nextLine();

	    Planta nuevaPlanta = new Planta();
	    nuevaPlanta.setCodigo(codigoPlanta);
	    nuevaPlanta.setNombreComun(nombreComun);
	    nuevaPlanta.setNombreCientifico(nombreCientifico);

	    servplant.insertarPlanta(nuevaPlanta);

	    System.out.println("¡Planta insertada correctamente!");
	}
	
	public void modificarPlanta() {
	    Scanner sc = new Scanner(System.in);

	    System.out.println("Introduce el código de la planta que deseas modificar:");
	    String codigoPlanta = sc.nextLine();

	    Planta plantaExistente = servplant.obtenerPlantaPorCodigo(codigoPlanta);
	    if (plantaExistente == null) {
	        System.out.println("ERROR: No se ha encontrado una planta con este código.");
	        return;
	    }

	    System.out.println("Introduce el nuevo nombre común de la planta (deja en blanco para no modificar):");
	    String nuevoNombreComun = sc.nextLine();
	    if (!nuevoNombreComun.isEmpty()) {
	        plantaExistente.setNombreComun(nuevoNombreComun);
	    }

	    System.out.println("Introduce el nuevo nombre científico de la planta (deja en blanco para no modificar):");
	    String nuevoNombreCientifico = sc.nextLine();
	    if (!nuevoNombreCientifico.isEmpty()) {
	        plantaExistente.setNombreCientifico(nuevoNombreCientifico);
	    }

	    servplant.modificarPlanta(plantaExistente);

	    System.out.println("¡Planta modificada correctamente!");
	}
	
}
