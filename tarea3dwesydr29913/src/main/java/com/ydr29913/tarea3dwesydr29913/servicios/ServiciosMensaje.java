package com.ydr29913.tarea3dwesydr29913.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ydr29913.tarea3dwesydr29913.repositorios.MensajeRepository;

@Service
public class ServiciosMensaje {

	@Autowired
	private MensajeRepository mensajerepo;
}
