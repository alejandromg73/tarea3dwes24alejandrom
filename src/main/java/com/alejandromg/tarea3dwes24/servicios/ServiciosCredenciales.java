package com.alejandromg.tarea3dwes24.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alejandromg.tarea3dwes24.repositorios.CredencialesRepository;

@Service
public class ServiciosCredenciales {
	@Autowired
	CredencialesRepository credencialesRepo;
	
	
	
	public boolean validarContraseña(String contraseña) {
		if (contraseña.matches("^(?=.*[.,])[A-Za-z0-9.,]{8,}$")) {
			return true;
		}
		return false;
	}
}