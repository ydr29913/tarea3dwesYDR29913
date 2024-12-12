package com.ydr29913.tarea3dwesydr29913;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.ydr29913.tarea3dwesydr29913.fachada.Fachada;
import com.ydr29913.tarea3dwesydr29913.servicios.ServiciosCredenciales;
import com.ydr29913.tarea3dwesydr29913.servicios.ServiciosEjemplar;
import com.ydr29913.tarea3dwesydr29913.servicios.ServiciosMensaje;
import com.ydr29913.tarea3dwesydr29913.servicios.ServiciosPersona;
import com.ydr29913.tarea3dwesydr29913.servicios.ServiciosPlanta;

public class Principal implements CommandLineRunner{

	@Autowired
	ServiciosPlanta servplant;
	
	@Autowired
	ServiciosEjemplar servejemplar;
	
	@Autowired
	ServiciosCredenciales servcredenciales;
	
	@Autowired
	ServiciosPersona servpersona;
	
	@Autowired
	ServiciosMensaje servmensaje;
	
	
	@Override
	public void run(String... args) throws Exception {
		Fachada fachada = new Fachada(servplant, servejemplar, servcredenciales, servpersona, servmensaje);
		fachada.mostrarMenu();
	}
}