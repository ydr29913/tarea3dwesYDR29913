package com.ydr29913.tarea3dwesydr29913.repositorios;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ydr29913.tarea3dwesydr29913.modelo.Mensaje;

@Repository
public interface MensajeRepository extends JpaRepository<Mensaje, Long>{

	List<Mensaje> findByPersona_Id(Long personaId);

    List<Mensaje> findByEjemplar_Id(Long ejemplarId);

    List<Mensaje> findByFechaHoraBetween(Date startDate, Date endDate);

    List<Mensaje> findByEjemplar_Planta_Id(Long plantaId);
}