package com.ydr29913.tarea3dwesydr29913.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ydr29913.tarea3dwesydr29913.modelo.Credenciales;
import com.ydr29913.tarea3dwesydr29913.repositorios.CredencialesRepository;

@Service
public class ServiciosCredenciales {

	@Autowired
	private CredencialesRepository credencialesrepo;
	
	public Credenciales autenticarUsuario(String usuario, String password) {
		Credenciales credenciales = credencialesrepo.findByUsuario(usuario);
		
		if (credenciales != null && credenciales.getPassword().equals(password)) {
			return credenciales;
		}
		
		return null;
	}
	
	public boolean validarUsuario(String usuario) {
	    return credencialesrepo.findByUsuario(usuario) == null;
	}

    
    public void insertarCredenciales(Credenciales credenciales) {
        if (credencialesrepo.findByUsuario(credenciales.getUsuario()) == null) {
            credencialesrepo.saveAndFlush(credenciales);
        }
    }
}
