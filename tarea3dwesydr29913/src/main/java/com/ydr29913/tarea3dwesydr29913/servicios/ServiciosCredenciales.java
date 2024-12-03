package com.ydr29913.tarea3dwesydr29913.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ydr29913.tarea3dwesydr29913.repositorios.CredencialesRepository;

@Service
public class ServiciosCredenciales {

	@Autowired
	private CredencialesRepository credencialesrepo;
}
