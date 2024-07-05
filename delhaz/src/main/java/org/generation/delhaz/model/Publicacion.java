package org.generation.delhaz.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "publicacion")
public class Publicacion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", unique=true, nullable=false)
	private Long id;
	@Column(nullable=false)
	private String usuario;
	private String descripcion;
	private LocalDateTime fechaPublicacion;
	private String contenido;

	
	public Publicacion(String usuario, String descripcion, LocalDateTime fechaPublicacion, String contenido) {
		this.usuario = usuario;
		this.descripcion = descripcion;
		this.fechaPublicacion = fechaPublicacion;
		this.contenido = contenido;
		
	}//cosntructor 
	
	public Publicacion() {
	
	}//constructor vacio 

	public String getUsuario() {
		return usuario;
	}//getUsuario

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}//setUsuario

	public String getDescripcion() {
		return descripcion;
	}//gestDescripcion

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}//setDescripcion

	public LocalDateTime getFechaPublicacion() {
		return fechaPublicacion;
	}//getFecha 

	public void setFechaPublicacion(LocalDateTime fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}//setfecha 

	public String getContenido() {
		return contenido;
	}//getContenidoMultimedia 

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}//setContenido Multimedia 
	

	public Long getId() {
		return id;
	}//getId

	
	@Override
	public String toString() {
		return "Publicacion [usuario=" + usuario + ", descripcion=" + descripcion + ", fechaPublicacion="
				+ fechaPublicacion + ", contenido=" + contenido + ", id=" + id + "]";
	}//toString
	
	
}//classPublicacion 
