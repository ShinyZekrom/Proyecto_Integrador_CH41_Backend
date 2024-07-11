package org.generation.delhaz.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "publicacion")
public class Publicacion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", unique=true, nullable=false)
	private Long id;
	//@Column(nullable=false)
	//private String username;
	@Column(nullable=false)
	private String descripcion;
	@Column(nullable=false)
	private LocalDateTime fechaPublicacion;
	@Column(nullable=false)
	private String contenido;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "usuario_id", nullable = false)
	@JsonBackReference
	private Usuario usuario;
	

	public Publicacion(Usuario usuario, String descripcion, LocalDateTime fechaPublicacion, String contenido) {
		this.usuario = usuario;
		this.descripcion = descripcion;
		this.fechaPublicacion = fechaPublicacion;
		this.contenido = contenido;
		
	}//cosntructor 
	
	public Publicacion() {
	
	}//constructor vacio 

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
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

	public String getUsername() {
        return usuario != null ? usuario.getUsername() : null;
    }

    public String getFotoPerfil() {
        return usuario != null ? usuario.getFotoPerfil() : null;
    }
	
	@Override
	public String toString() {
		return "Publicacion [usuario=" + usuario + ", descripcion=" + descripcion + ", fechaPublicacion="
				+ fechaPublicacion + ", contenido=" + contenido + ", id=" + id + "]";
	}//toString
	
	
}//classPublicacion 
