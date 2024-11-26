package com.alejandromg.tarea3dwes24.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alejandromg.tarea3dwes24.repositorios.EjemplarRepository;
import com.alejandromg.tarea3dwes24.repositorios.PlantaRepository;

@Service
public class ServiciosEjemplar {
	@Autowired
	PlantaRepository plantaRepo;
	@Autowired 
	EjemplarRepository ejemplarRepo;
}
