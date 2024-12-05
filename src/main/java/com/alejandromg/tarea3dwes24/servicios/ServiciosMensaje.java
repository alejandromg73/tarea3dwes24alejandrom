package com.alejandromg.tarea3dwes24.servicios;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alejandromg.tarea3dwes24.modelo.Mensaje;
import com.alejandromg.tarea3dwes24.repositorios.MensajeRepository;

@Service
public class ServiciosMensaje {

    @Autowired
    private MensajeRepository mensajeRepo;

    public void insertar(Mensaje m) {
        mensajeRepo.saveAndFlush(m);
    }

    public ArrayList<Mensaje> verMensajesRangoFechas(LocalDateTime primeraFecha, LocalDateTime segundaFecha) {
        List<Mensaje> mensajes = mensajeRepo.findMensajesBetweenFechas(primeraFecha, segundaFecha);
        return new ArrayList<>(mensajes);
    }

    public Collection<Mensaje> verTodos() {
        return mensajeRepo.findAll();
    }

    public ArrayList<Mensaje> verMensajesPorPersona(long idPersona) {
        List<Mensaje> mensajes = mensajeRepo.findMensajesByPersonaId(idPersona);
        return new ArrayList<>(mensajes);
    }

    public ArrayList<Mensaje> verMensajesPorCodigoPlanta(String codigoPlanta) {
        List<Mensaje> mensajes = mensajeRepo.findMensajesByCodigoPlanta(codigoPlanta);
        return new ArrayList<>(mensajes);
    }

    public ArrayList<Mensaje> verMensajesPorEjemplar(long idEjemplar) {
        List<Mensaje> mensajes = mensajeRepo.findMensajesByEjemplarId(idEjemplar);
        return new ArrayList<>(mensajes);
    }

    public boolean validarMensaje(String mensaje) {
        if (mensaje == null || mensaje.trim().isEmpty()) {
            return false;
        }
        if (mensaje.length() > 500) {
            return false;
        }
        return true;
    }
}
