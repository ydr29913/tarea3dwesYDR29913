package com.ydr29913.tarea3dwesydr29913.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ydr29913.tarea3dwesydr29913.modelo.Persona;
import com.ydr29913.tarea3dwesydr29913.repositorios.PersonaRepository;

@Service
public class ServiciosPersona {

	@Autowired
	private PersonaRepository personarepo;
	
	public boolean validarEmail(String email) {
		return personarepo.findByEmail(email).isEmpty();
	}
	
	public void insertarPersona(Persona persona) {
		personarepo.saveAndFlush(persona);
	}
}
