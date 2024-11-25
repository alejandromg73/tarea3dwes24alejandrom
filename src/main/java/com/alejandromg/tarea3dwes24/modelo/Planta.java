package com.alejandromg.tarea3dwes24.modelo;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="plantas")
public class Planta {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String codigo;
	
	
	private String nombreComun;
	
	
	private String nombreCientifico;
	
	
	public Planta() {
	}

	public Planta(String codigo, String nombreComun, String nombrecientifico) {
		this.codigo = codigo;
		this.nombreComun = nombreComun;
		this.nombreCientifico = nombrecientifico;
	}
	

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombreComun() {
		return nombreComun;
	}

	public void setNombreComun(String nombreComun) {
		this.nombreComun = nombreComun;
	}

	public String getNombreCientifico() {
		return nombreCientifico;
	}

	public void setNombrecientifico(String nombrecientifico) {
		this.nombreCientifico = nombrecientifico;
	}
	
	

	@Override
	public int hashCode() {
		return Objects.hash(codigo, nombreCientifico, nombreComun);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Planta other = (Planta) obj;
		return Objects.equals(codigo, other.codigo) && Objects.equals(nombreCientifico, other.nombreCientifico)
				&& Objects.equals(nombreComun, other.nombreComun);
	}

	@Override
	public String toString() {
		return "Planta [codigo=" + codigo + ", nombreComun=" + nombreComun + ", nombrecientifico=" + nombreCientifico
				+ "]";
	}
	
	
	
	
	
	

}