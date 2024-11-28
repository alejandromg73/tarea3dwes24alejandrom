package com.alejandromg.tarea3dwes24;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.alejandromg.tarea3dwes24.servicios.ServiciosCredenciales;
import com.alejandromg.tarea3dwes24.servicios.ServiciosEjemplar;
import com.alejandromg.tarea3dwes24.servicios.ServiciosPersona;
import com.alejandromg.tarea3dwes24.servicios.ServiciosPlanta;

public class Principal implements CommandLineRunner {
	
	@Autowired
	ServiciosPlanta servPlanta;
	
	@Autowired
	ServiciosEjemplar servEjemplar;
	
	@Autowired
	ServiciosCredenciales servCred;
	
	@Autowired
	ServiciosPersona servPersona;

	


	@Override
	public void run(String... args) throws Exception {
		System.out.println("INI");
		System.out.println("FINNNNN");

}
}
