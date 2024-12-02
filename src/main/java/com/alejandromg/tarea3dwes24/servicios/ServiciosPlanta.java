package com.alejandromg.tarea3dwes24.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alejandromg.tarea3dwes24.modelo.Planta;
import com.alejandromg.tarea3dwes24.repositorios.EjemplarRepository;
import com.alejandromg.tarea3dwes24.repositorios.PlantaRepository;

@Service
public class ServiciosPlanta {
	@Autowired
	PlantaRepository plantaRepo;
	@Autowired
	EjemplarRepository ejemplarRepo;
	
	public void insertarPlanta(Planta p) {
		plantaRepo.saveAndFlush(p);
	}
	public boolean existeCodigo(Planta p) {
		return plantaRepo.existeCodigo(p);
	}
	
	/**
	 * Método para ver validar una planta
	 * 
	 * 
	 * @param Un objeto de tipo planta que se quiere validar
	 * @return True si se ha validado, false si no se ha validado
	 *
	 */
	public boolean validarPlanta(Planta p) {
		if (p.getCodigo().isEmpty())
			return false;
		if (p.getCodigo().length() < 3 || p.getCodigo().length() > 50)
			return false;
		if (p.getNombreCientifico().isEmpty() || p.getNombreComun().isEmpty())
			return false;
		if (!p.getCodigo().matches("^[A-Za-z0-9]+$"))
			return false;
		if (p.getNombreCientifico().length() < 3 || p.getNombreCientifico().length() > 100)
			return false;

		if (p.getNombreComun().length() < 3 || p.getNombreComun().length() > 100)
			return false;
		if (!p.getNombreCientifico().matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$")
				|| !p.getNombreComun().matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$"))
			return false;
		return true;
	}

	/**
	 * Método para ver validar el código de una planta
	 * 
	 * 
	 * @param Un codigo que se quiere validar
	 * @return True si se ha validado, false si no se ha validado
	 *
	 */
	public boolean validarCodigo(String codigo) {
		if (codigo == null || codigo.isEmpty()) {
			return false;
		}
		if (!codigo.matches("^[A-Za-z0-9]+$")) {
			return false;
		}
		if (codigo.length() < 3 || codigo.length() > 50)
			return false;
		return true;
	}
}
