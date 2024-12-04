package com.alejandromg.tarea3dwes24.servicios;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alejandromg.tarea3dwes24.modelo.Ejemplar;
import com.alejandromg.tarea3dwes24.repositorios.EjemplarRepository;

@Service
public class ServiciosEjemplar {

    @Autowired
    private EjemplarRepository ejemplarRepo;

    public void insertar(Ejemplar e) {
    	ejemplarRepo.save(e);
    }

    public Collection<Ejemplar> verTodos() {
        return ejemplarRepo.findAll();
    }

    public Ejemplar buscarPorID(long id) {
        Optional<Ejemplar> ejemplares = ejemplarRepo.findById(id);
        return ejemplares.orElse(null);
    }
    
    @Transactional
    public boolean cambiarNombre(long idEjemplar, String nuevoNombre) {
        int filas = ejemplarRepo.cambiarNombre(idEjemplar, nuevoNombre);
        return filas > 0;
    }

    public int contarEjemplares() {
        return ejemplarRepo.contarEjemplares();
    }

    public ArrayList<Ejemplar> ejemplaresPorTipoPlanta(String codigo) {
        List<Ejemplar> ejemplares = ejemplarRepo.ejemplaresPorTipoPlanta(codigo);
        return new ArrayList<>(ejemplares);
    }

    public boolean validarEjemplar(Ejemplar e) {
        if (e.getPlanta() == null || e.getPlanta().getCodigo() == null || e.getPlanta().getCodigo().isEmpty()) {
            return false;
        }
        if (e.getPlanta().getCodigo().length() < 3 || e.getPlanta().getCodigo().length() > 20) {
            return false;
        }
        if (e.getNombre() == null || e.getNombre().isEmpty() || e.getNombre().length() < 3) {
            return false;
        }
        return true;
    }
    
    public boolean borrarEjemplar(Long id) {
        try {
            if (ejemplarRepo.existsById(id)) {
                ejemplarRepo.deleteById(id);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar el ejemplar: " + e.getMessage());
            return false;
        }
    }
}


