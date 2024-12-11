package com.alejandromg.tarea3dwes24.servicios;

import org.springframework.stereotype.Service;


//Esta clase Controlador se encarga del manejo de la sesión y de los usuarios autenticados en el programa

@Service
public class Controlador {
	//Con esta variable usuarioAutenticado, tengo almacenado en todo momento el usuario que está autenticado en el sistema
    private String usuarioAutenticado;
    private String perfil;//Ahora también se guarda el perfil del usuario que se autentica como se pide

    public void setUsuarioAutenticado(String usuario) {
        this.usuarioAutenticado = usuario;
    }

    public String getUsuarioAutenticado() {
        return usuarioAutenticado;
    }
    
    public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	/**
	 * Este método sirve para cerrar sesión, ya que pone la variable de usuario
	 * autenticado a nulo. El perfil de usuario también lo pone a nulo
	 * Esta opción la añado en el menú para que el usuario pueda cerrar su sesión
	 */
	public void cerrarSesion() {
		this.usuarioAutenticado = null;
		this.perfil = null;
	}
}
