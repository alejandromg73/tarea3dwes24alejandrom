package com.alejandromg.tarea3dwes24.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alejandromg.tarea3dwes24.modelo.Persona;
import com.alejandromg.tarea3dwes24.repositorios.PersonaRepository;

@Service
public class ServiciosPersona {
	@Autowired
	PersonaRepository personaRepo;
	
	
	/**
	 * Método para ver validar una persona
	 * 
	 * 
	 * @param Un objeto de tipo persona que se quiere validar
	 * @return True si se ha validado, false si no se ha validado
	 *
	 */
	public boolean validarPersona(Persona pers) {
		if (pers == null) {
			return false;
		}
		if (pers.getNombre() == null || pers.getNombre().isEmpty()) {
			return false;
		}
		if (pers.getNombre().length() < 3 || pers.getNombre().length() > 20) {
			return false;
		}
		if (pers.getEmail() == null || pers.getEmail().isEmpty()) {
			return false;
		}
		if (pers.getEmail().length() < 5 || !pers.getEmail().matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")
				|| pers.getEmail().length() > 40) {
			return false;
		}
		if (pers.getNombre().length() < 3 || pers.getNombre().length() > 40)
			return false;

		return true;
	}
	
}