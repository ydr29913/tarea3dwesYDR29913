package com.ydr29913.tarea3dwesydr29913.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ydr29913.tarea3dwesydr29913.modelo.Planta;

import jakarta.transaction.Transactional;

@Repository
public interface PlantaRepository extends JpaRepository<Planta, Long> {
	
	default boolean existeCodigo(Planta p) {
		List<Planta> listaPlantas = findAll();
		
		for(Planta aux: listaPlantas) {
			if(p.getCodigo().equals(aux.getCodigo())) 
				return true;
		
		}
		
		return false;
	}
}
