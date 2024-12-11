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
		//Revisar todos los métodos con el perfil de personal
		//Meter el archivo sql definitivo Y cambiar el puerto de sql
		//Meter datos pa la base de datos
		//Pasar mirando todo por el programa y probando una última vez para descartar errores tontos
		//Revisar el documento a fondo TAREA3
		//Registrar nuevo ejemplar: No se muestran los codigos de las plantas para seleccionar el ejemplar, sino que hay que saber su código.
		//Ver mensajes para un ejemplar: No se muestran los ids de los ejemplares para seleccionar, sino que hay que saber su valor. Luego el programa indica el rango de enteros, pero sigue sin mostrar lso ejemplares apra seleccionar)
		//Gestión de mensajes: No se muestran los ids de las personas para seleccionar, por lo que debe hacerse a ciegas.
		
		//ARREGLADO------------Filtrar ejemplares por tipo planta FALLA
		//ARREGLADO------------El programa permite intoducir un nombre de usuario con espacios en blanco.
		//ARREGLADO------------No se está estableciendo adecuadamente el sistema de sesión, sino que tan solo se guarda el nobmre del usuario autenticado, no su perfil CU3.

    }
}



