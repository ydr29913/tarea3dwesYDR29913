package com.ydr29913.tarea3dwesydr29913.fachada;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ydr29913.tarea3dwesydr29913.modelo.Credenciales;
import com.ydr29913.tarea3dwesydr29913.modelo.Ejemplar;
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
  				System.out.println("\n\n\n\t\t\tGESTION DE VIVERO (INVITADO)\n");
  				System.out.println("\t\t\t\t1 - LOGIN");
  				System.out.println("\t\t\t\t2 - VER PLANTAS");
  				System.out.println("\n\t\t\t\t9 - SALIR");

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
  			System.out.println("Id: " + planta.getId() + "\tCódigo: " + planta.getCodigo() + "\t\tNombre Común: " + planta.getNombreComun() + "\t\tNombre Científico: " + planta.getNombreCientifico());
  		}
  	}
  	
  	
	//Menu para logearse
	public void menuLogin() {
		Scanner sc = new Scanner(System.in);

		int opcion = 0;

		do {
			try {
				System.out.println("\n\n\t\t\tLOGIN\n");
				System.out.println("\t\t\t\t1 - PERSONAL");
				System.out.println("\t\t\t\t2 - ADMINISTRADOR GENERAL");
				System.out.println("\n\t\t\t\t9 - SALIR");

				opcion = sc.nextInt();
				switch (opcion) {
				case 1:
					autenticarse();
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
            
            if ("admin".equals(usuario) && "admin".equals(contrasena)) {
            	System.out.println("Autenticación exitosa. Bienvenido, " + usuario + "!");
                menuAdmin();
            } else if (credenciales != null) {
            	usuarioAutenticado = credenciales;
            	System.out.println("Autenticación exitosa. Bienvenido, " + usuario + "!");
                menuPersonal();
            }
        } else {
            System.out.println("Usuario o contraseña incorrectos.");
        }
    }
    
    /*
    public void autenticarse2() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce tu nombre de usuario: ");
        String usuario = sc.nextLine();
        System.out.print("Introduce tu contraseña: ");
        String contrasena = sc.nextLine();

        Credenciales credenciales = servcredenciales.autenticarUsuario(usuario, contrasena);
        if (credenciales != null) {
            usuarioAutenticado = credenciales;
            System.out.println("Autenticación exitosa. Bienvenido, " + usuario + "!");
            menuPersonal();
        } else {
            System.out.println("Usuario o contraseña incorrectos.");
        }
    }
    */
    

    //Menu para Administradores
    public void menuAdmin() {
        Scanner sc = new Scanner(System.in);

        int opcion = 0;

        do {
            try {
                System.out.println("\n\n\t\t\tGESTION DE VIVERO (ADMIN)\n");
                System.out.println("\t\t\t\t1 - VER PLANTAS");
                System.out.println("\t\t\t\t2 - REGISTRAR UNA PERSONA");
                System.out.println("\t\t\t\t3 - INSERTAR NUEVA PLANTA");
                System.out.println("\t\t\t\t4 - MODIFICAR PLANTA");
                System.out.println("\n\t\t\t\t5 - MENU GESTION DE EJEMPLARES");
                System.out.println("\t\t\t\t6 - MENU GESTION DE MENSAJES");
                System.out.println("\n\t\t\t\t9 - SALIR");

                opcion = sc.nextInt();
                switch (opcion) {
                    case 1:
                        verPlantas();
                        break;
                    case 2:
                    	registrarNuevaPersona();
                    	break;
                    case 3:
                    	insertarNuevaPlanta();
                    	break;
                    case 4:
                    	modificarPlanta();
                    	break;
                    case 5:
                    	menuGestionEjemplares(null);
                    	break;
                    case 6:
                    	//menuGestionMensajes();
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
            System.out.println("ERROR: El email ya está registrado o esta introducido incorrectamente.");
            return;
        }

        System.out.println("Introduzca el nombre de usuario:");
        String usuario = sc.nextLine();
        
        if (!servcredenciales.validarUsuario(usuario)) {
            System.out.println("ERROR: El nombre de usuario no está disponible o esta introducido incorrectamente.");
            return;
        }

        System.out.println("Introduzca la contraseña:");
        String password = sc.nextLine();

        if (!servcredenciales.validarPassword(password)) {
            System.out.println("ERROR: La contraseña no está disponible o esta introducida incorrectamente.");
            return;
        }
        
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
	
	
	//Menu para Personal
    public void menuPersonal() {
        Scanner sc = new Scanner(System.in);

        int opcion = 0;

        do {
            try {
                System.out.println("\n\n\t\t\tGESTION DE VIVERO (PERSONAL)\n");
                System.out.println("\t\t\t\t1 - VER PLANTAS");
                System.out.println("\n\t\t\t\t2 - MENU GESTION DE EJEMPLARES");
                System.out.println("\t\t\t\t3 - MENU GESTION DE MENSAJES");
                System.out.println("\n\t\t\t\t9 - SALIR");

                opcion = sc.nextInt();
                switch (opcion) {
                    case 1:
                        verPlantas();
                        break;
                    case 2:
                    	menuGestionEjemplares(null);
                    	break;
                    case 3:
                    	//menuGestionMensajes();
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
	
	
	//Menu para la Gestion de Ejemplares
	public void menuGestionEjemplares(String usuario) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
        	System.out.println("\n\n\t\t\tGESTION DE EJEMPLARES\n");
            System.out.println("\t\t\t\t1 - REGISTRAR NUEVO EJEMPLAR");
            System.out.println("\t\t\t\t2 - FILTRAR POR TIPO DE PLANTA");
            System.out.println("\t\t\t\t3 - VER MENSAJES DE SEGUIMIENTO");
            System.out.println("\n\t\t\t\t9 - SALIR");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    //registrarNuevoEjemplar(usuario);
                    break;
                case 2:
                    filtrarEjemplaresPorPlanta();
                    break;
                case 3:
                    //verMensajesDeEjemplar();
                    break;
                case 9:
                    break;
            }
        } while (opcion != 9);
    }
	
	/*
	private void registrarNuevoEjemplar(String nombreUsuario) {
	     Scanner sc = new Scanner(System.in);
	     
	     System.out.println("Selecciona una planta de las siguientes:");
	     List<Planta> plantas = servplant.obtenerPlantasOrdenadasAlfabeticamente();
	     for (int i = 0; i < plantas.size(); i++) {
	         System.out.println((i + 1) + ". " + plantas.get(i).getNombreComun());
	     }

	     int opcionPlanta = sc.nextInt();
	     Planta plantaSeleccionada = plantas.get(opcionPlanta - 1);
	     sc.nextLine();

	     System.out.println("Introduce el nombre del ejemplar:");
	     String nombreEjemplar = sc.nextLine();

	     System.out.println("Introduce un mensaje inicial para este ejemplar:");
	     String mensajeInicial = sc.nextLine();

	     Persona persona = servpersona.obtenerPersonaPorNombre(nombreUsuario);

	     servejemplar.registrarNuevoEjemplar(plantaSeleccionada, nombreEjemplar, mensajeInicial, persona);

	     System.out.println("¡Ejemplar registrado con éxito!");
	}
	*/
	
	private void filtrarEjemplaresPorPlanta() {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Selecciona una planta para filtrar los ejemplares:");
        List<Planta> plantas = servplant.obtenerPlantasOrdenadasAlfabeticamente();
        for (int i = 0; i < plantas.size(); i++) {
            System.out.println((i + 1) + ". " + plantas.get(i).getNombreComun());
        }

        int opcionPlanta = sc.nextInt();
        Planta plantaSeleccionada = plantas.get(opcionPlanta - 1);

        List<Ejemplar> ejemplares = servejemplar.obtenerEjemplaresPorPlanta(plantaSeleccionada);
        if (ejemplares.isEmpty()) {
            System.out.println("No hay ejemplares registrados para esta planta.");
        } else {
            System.out.println("Ejemplares para la planta " + plantaSeleccionada.getNombreComun() + ":");
            for (Ejemplar ejemplar : ejemplares) {
                System.out.println("ID: " + ejemplar.getId() + "\tNombre: " + ejemplar.getNombre());
            }
        }
    }
	
}
