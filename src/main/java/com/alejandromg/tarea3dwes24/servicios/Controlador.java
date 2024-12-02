package com.alejandromg.tarea3dwes24.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Controlador {

    @Autowired
    private ServiciosCredenciales servCred;

    @Autowired
    private ServiciosEjemplar servEjemplar;

    @Autowired
    private ServiciosMensaje servMensaje;

    @Autowired
    private ServiciosPersona servPersona;

    @Autowired
    private ServiciosPlanta servPlanta;

    private String usuarioAutenticado;

    public void setUsuarioAutenticado(String usuario) {
        this.usuarioAutenticado = usuario;
    }

    public String getUsuarioAutenticado() {
        return usuarioAutenticado;
    }

    public ServiciosCredenciales getServiciosCredenciales() {
        return servCred;
    }

    public ServiciosEjemplar getServiciosEjemplar() {
        return servEjemplar;
    }

    public ServiciosMensaje getServiciosMensaje() {
        return servMensaje;
    }

    public ServiciosPersona getServiciosPersona() {
        return servPersona;
    }

    public ServiciosPlanta getServiciosPlanta() {
        return servPlanta;
    }
    
    /**
	 * Este método sirve para cerrar sesión, ya que pone la variable de usuario
	 * autenticado a nulo
	 */
	public void cerrarSesion() {
		this.usuarioAutenticado = null;
	}
}
