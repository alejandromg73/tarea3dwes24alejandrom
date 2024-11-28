package com.alejandromg.tarea3dwes24.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alejandromg.tarea3dwes24.repositorios.MensajeRepository;

	@Service
	public class ServiciosMensaje {
		@Autowired
		MensajeRepository mensajeRepo;
		
}
