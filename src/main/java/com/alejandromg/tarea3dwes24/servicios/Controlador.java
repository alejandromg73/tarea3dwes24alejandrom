package com.alejandromg.tarea3dwes24.servicios;

import org.springframework.stereotype.Service;


//Esta clase Controlador se encarga del manejo de la sesión y de los usuarios autenticados en el programa

@Service
public class Controlador {

    

    private String usuarioAutenticado;

    public void setUsuarioAutenticado(String usuario) {
        this.usuarioAutenticado = usuario;
    }

    public String getUsuarioAutenticado() {
        return usuarioAutenticado;
    }
    
    /**
	 * Este método sirve para cerrar sesión, ya que pone la variable de usuario
	 * autenticado a nulo
	 */
	public void cerrarSesion() {
		this.usuarioAutenticado = null;
	}
}
