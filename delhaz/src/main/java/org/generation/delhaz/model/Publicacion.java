package org.generation.delhaz.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "publicacion")
public class Publicacion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", unique=true, nullable=false)
	private Long id;
	@Column(nullable=false)
	private String username;
	@Column(nullable=false)
	private String descripcion;
	@Column(nullable=false)
	private LocalDateTime fechaPublicacion;
	@Column(nullable=false)
	private String contenido;
	@ManyToOne
	@JoinColumn(name= "usuario_id", nullable = false)
	private Usuario usuario;

	
	public Publicacion(String username, String descripcion, LocalDateTime fechaPublicacion, String contenido, Usuario usuario) {
		this.username = username;
		this.descripcion = descripcion;
		this.fechaPublicacion = fechaPublicacion;
		this.contenido = contenido;
		this.usuario = usuario;
		
	}//cosntructor 
	
	public Publicacion() {
	
	}//constructor vacio 

	public String getUsername() {
		return username;
	}//getUsuario

	public void setUsuario(String username) {
		this.username = username;
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
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Publicacion [id=" + id + ", username=" + username + ", descripcion=" + descripcion
				+ ", fechaPublicacion=" + fechaPublicacion + ", contenido=" + contenido + ", usuario=" + usuario + "]";
	}//toString
	
	
}//classPublicacion 
