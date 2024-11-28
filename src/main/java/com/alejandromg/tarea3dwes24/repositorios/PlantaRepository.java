package com.alejandromg.tarea3dwes24.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alejandromg.tarea3dwes24.modelo.Planta;

@Repository
public interface PlantaRepository extends JpaRepository <Planta, Long>{
	
	default boolean existeCodigo(Planta p) {
		List<Planta> plantas = findAll();
		for(Planta aux: plantas) {
			if(p.getCodigo().equals(aux.getCodigo()))
				return true;
		}
		return false;
		
	}
}
