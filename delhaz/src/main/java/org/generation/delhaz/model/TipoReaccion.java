package org.generation.delhaz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TiposReacciones")
public class TipoReaccion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", unique=true, nullable=false)
	private Long id;
	@Column(nullable=false)
	private String nombre;
	private String icono;
	
	//1.Constructor
	public TipoReaccion(String nombre, String icono, Long id) {
		this.nombre = nombre;
		this.icono = icono;
		this.id = id;
	}// constructor
	
	//2.Constructor vacio
	public TipoReaccion() {

	}//constructor vacio

	//3.Getters and Setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getIcono() {
		return icono;
	}

	public void setIcono(String icono) {
		this.icono = icono;
	}

	public long getId() {
		return id;
	}
	
	//4.toString
	@Override
	public String toString() {
		return "TipoReaccion [id=" + id + ", nombre=" + nombre + ", icono=" + icono + "]";
	}
	
}//class TipoReaccion
