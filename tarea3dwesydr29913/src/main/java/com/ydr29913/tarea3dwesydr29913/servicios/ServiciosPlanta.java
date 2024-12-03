package com.ydr29913.tarea3dwesydr29913.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ydr29913.tarea3dwesydr29913.modelo.Planta;
import com.ydr29913.tarea3dwesydr29913.repositorios.EjemplarRepository;
import com.ydr29913.tarea3dwesydr29913.repositorios.PlantaRepository;

@Service
public class ServiciosPlanta {
	
	@Autowired
	private PlantaRepository plantarepo;
	
	@Autowired
	ServiciosEjemplar servejemplar;
	
	
	public void insertarPlanta(Planta p) {
		plantarepo.saveAndFlush(p);
	}
	
	public boolean validarPlanta(Planta p) {
		
		if (plantarepo.existeCodigo(p)) {
			return false;
		}
		return true;
	}
	

}
