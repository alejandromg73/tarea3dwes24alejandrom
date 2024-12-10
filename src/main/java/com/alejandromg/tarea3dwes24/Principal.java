package com.alejandromg.tarea3dwes24;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.alejandromg.tarea3dwes24.vista.FachadaInvitado;

public class Principal implements CommandLineRunner {
	
	 @Autowired
	 private FachadaInvitado fachadaInvitado;

	@Override
	public void run(String... args) throws Exception {
		fachadaInvitado.menuInvitado();
		//OJO, revisar caso de uso de Personal de mensajes por ejemplar, ajustar la validación
		//Pegarle un repaso a los repositories
		//Meter el archivo sql definitivo
		//Mejoras en la presentación de los datos como en nuevoMensaje o mensajes ejemplar
		//Meter datos pa la base de datos
		//Pasar mirando todo un poco por todo el programa
    }
}



