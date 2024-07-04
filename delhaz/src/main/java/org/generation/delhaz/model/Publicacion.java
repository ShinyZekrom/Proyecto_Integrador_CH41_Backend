package org.generation.delhaz.model;

import java.time.LocalDateTime;

public class Publicacion {
	
	private String usuario;
	private String descripcion;
	private LocalDateTime fechaPublicacion;
	private String contenido;
	private int  id; 
	private static int  total=0;
	
	public Publicacion(String usuario, String descripcion, LocalDateTime fechaPublicacion, String contenido) {
		this.usuario = usuario;
		this.descripcion = descripcion;
		this.fechaPublicacion = fechaPublicacion;
		this.contenido = contenido;
		Publicacion.total++;
		this.id=total;
	}//cosntructor 
	
	public Publicacion() {
		Publicacion.total++;
		this.id=total;
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
	

	public int getId() {
		return id;
	}//getId

	
	@Override
	public String toString() {
		return "Publicacion [usuario=" + usuario + ", descripcion=" + descripcion + ", fechaPublicacion="
				+ fechaPublicacion + ", contenido=" + contenido + ", id=" + id + "]";
	}//toString
	
	
}//classPublicacion 
