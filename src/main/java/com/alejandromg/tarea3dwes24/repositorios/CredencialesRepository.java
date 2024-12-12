package com.alejandromg.tarea3dwes24.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alejandromg.tarea3dwes24.modelo.Credenciales;
import com.alejandromg.tarea3dwes24.modelo.Persona;

@Repository
public interface CredencialesRepository extends JpaRepository<Credenciales, Long> {

	boolean existsByUsuario(String usuario);

	boolean existsByUsuarioAndPassword(String usuario, String password);

	Persona findPersonaByUsuario(String usuario);


}
