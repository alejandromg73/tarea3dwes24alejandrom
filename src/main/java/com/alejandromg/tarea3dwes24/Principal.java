package com.alejandromg.tarea3dwes24;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.alejandromg.tarea3dwes24.servicios.*;
import com.alejandromg.tarea3dwes24.modelo.*;

public class Principal implements CommandLineRunner {
	
	@Autowired
	ServiciosPlanta servPlanta;
	
	@Autowired
	ServiciosEjemplar servEjemplar;
	
	@Autowired
	ServiciosPersona servPersona;
	
	@Autowired
	ServiciosMensaje servMensaje;
	
	@Autowired
	ServiciosCredenciales servCredenciales;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("INI");
		
		
		System.out.println("----------------------");
		
		
		System.out.println("FIN");
	}

}
