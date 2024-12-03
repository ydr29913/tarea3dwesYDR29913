package com.ydr29913.tarea3dwesydr29913.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ydr29913.tarea3dwesydr29913.modelo.Ejemplar;
import com.ydr29913.tarea3dwesydr29913.modelo.Planta;
import com.ydr29913.tarea3dwesydr29913.repositorios.EjemplarRepository;

@Service
public class ServiciosEjemplar {

	@Autowired
	private EjemplarRepository ejemplarrepo;
	
	public List<Ejemplar> findEjemplaresByNombre(String nombre) {
		return ejemplarrepo.findEjemplaresByNombre(nombre);
	}
	
	public int actualizarNombreEjemplar(Long id, String nombre) {
		return ejemplarrepo.actualizarNombreEjemplar(id, nombre);
	}
	
	public Long ultimoIdEjemplarByPlanta(Planta p) {
		if (p != null)
			return ejemplarrepo.ultimoIdEjemplarByPlanta(p);
		else
			return null;
	}
	
	public void actualizar(Ejemplar e) {
		ejemplarrepo.saveAndFlush(e);
	}
}
