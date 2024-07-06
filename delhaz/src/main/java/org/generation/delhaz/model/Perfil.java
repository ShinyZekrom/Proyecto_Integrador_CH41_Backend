package org.generation.delhaz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="perfiles")
public class Perfil {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id",unique=true, nullable = false)
	private Long id;
	@Column(nullable = false)
	private Long usuario_id;
	private String descripcion;
	
	
	public Perfil(Long usuario_id, String descripcion) {
		this.usuario_id = usuario_id;
		this.descripcion = descripcion;
	}//constructor
	
	public Perfil() {}//constructor vacio
	
	public Long getUsuario_id() {
		return usuario_id;
	}

	public void setUsuario_id(Long usuario_id) {
		this.usuario_id = usuario_id;
	}

	public String getDescripcion() {
		return descripcion;
	}//getDescripcion

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}//setDescripcion

	public Long getId() {
		return id;
	}//getId

	@Override
	public String toString() {
		return "Perfil [id=" + id + ", usuario_id=" + usuario_id + ", descripcion=" + descripcion + "]";
	}//toString
	
	
}//Class Perfil