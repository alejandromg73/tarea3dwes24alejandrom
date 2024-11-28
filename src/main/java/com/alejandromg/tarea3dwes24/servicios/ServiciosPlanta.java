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
	
	public Planta insertarPlanta(Planta p) {
		return plantaRepo.save(p);
	}
}
