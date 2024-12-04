package com.ydr29913.tarea3dwesydr29913;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.ydr29913.tarea3dwesydr29913.fachada.Fachada;
import com.ydr29913.tarea3dwesydr29913.modelo.Planta;
import com.ydr29913.tarea3dwesydr29913.servicios.ServiciosEjemplar;
import com.ydr29913.tarea3dwesydr29913.servicios.ServiciosPlanta;

public class Principal implements CommandLineRunner{

	@Autowired
	ServiciosPlanta servplant;
	
	@Autowired
	ServiciosEjemplar servejemplar;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("INI");
		
		Fachada f = new Fachada(servplant);
		f.mostrarMenu();
		
		
		Planta p = new Planta();
		/*
		servplant.validarPlanta(p);
		
		servplant.insertarPlanta(p);
		*/
		
	}

}
