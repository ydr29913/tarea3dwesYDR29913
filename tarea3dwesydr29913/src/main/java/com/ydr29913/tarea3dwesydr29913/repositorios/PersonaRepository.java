package com.ydr29913.tarea3dwesydr29913.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ydr29913.tarea3dwesydr29913.modelo.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long>{

	Optional<Persona> findByEmail(String email);
}
