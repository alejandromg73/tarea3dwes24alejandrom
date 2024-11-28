package com.alejandromg.tarea3dwes24.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alejandromg.tarea3dwes24.repositorios.CredencialesRepository;

@Service
public class ServiciosCredenciales {
	@Autowired
	CredencialesRepository credencialesRepo;
	
}