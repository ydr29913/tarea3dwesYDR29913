package com.ydr29913.tarea3dwesydr29913.fachada;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;

import com.ydr29913.tarea3dwesydr29913.modelo.Planta;
import com.ydr29913.tarea3dwesydr29913.servicios.ServiciosPlanta;

public class Fachada {

	/*
	@Autowired
	private ServiciosPlanta servplant = new ServiciosPlanta();
	*/
	
	private ServiciosPlanta servplant;

    public Fachada(ServiciosPlanta servplant) {
        this.servplant = servplant;
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
                        //logearse();
                        break;
                    case 2:
                        //logearse();
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
}
