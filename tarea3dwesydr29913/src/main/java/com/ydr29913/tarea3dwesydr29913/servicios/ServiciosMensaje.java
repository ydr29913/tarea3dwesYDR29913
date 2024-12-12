package com.ydr29913.tarea3dwesydr29913.servicios;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ydr29913.tarea3dwesydr29913.modelo.Mensaje;
import com.ydr29913.tarea3dwesydr29913.repositorios.MensajeRepository;

@Service
public class ServiciosMensaje {

	@Autowired
	private MensajeRepository mensajerepo;
	
	
	public List<Mensaje> obtenerMensajesPorPersona(Long personaId) {
        return mensajerepo.findByPersona_Id(personaId);
    }

    public List<Mensaje> obtenerMensajesPorEjemplar(Long ejemplarId) {
        return mensajerepo.findByEjemplar_Id(ejemplarId);
    }

    public List<Mensaje> obtenerMensajesPorFecha(Date startDate, Date endDate) {
        return mensajerepo.findByFechaHoraBetween(startDate, endDate);
    }

    public List<Mensaje> obtenerMensajesPorPlanta(Long plantaId) {
        return mensajerepo.findByEjemplar_Planta_Id(plantaId);
    }
	
	public void registrarMensaje(Mensaje mensaje) {
        mensaje.setFechaHora(new Date());
        mensajerepo.save(mensaje);
    }
}