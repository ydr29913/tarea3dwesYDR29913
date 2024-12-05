package com.ydr29913.tarea3dwesydr29913.repositorios;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ydr29913.tarea3dwesydr29913.modelo.Ejemplar;
import com.ydr29913.tarea3dwesydr29913.modelo.Planta;


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
	
	default List<Planta> todasPlantasDescendiente() {
		return findAll(Sort.by(Sort.Direction.DESC, "id"));
	}
	
	List<Planta> findAllByOrderByNombreComunAsc();
}
