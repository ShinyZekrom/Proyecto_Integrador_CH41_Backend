package org.generation.delhaz.dto;

import java.time.LocalDateTime;

public class PublicacionDTO {
	private Long id;
    private String descripcion;
    private LocalDateTime fechaPublicacion;
    private String contenido;
    private String usuarioUsername;
    private String usuarioFotoPerfil;
    
    
	public PublicacionDTO(Long id, String descripcion, LocalDateTime fechaPublicacion, String contenido,
			String usuarioUsername, String usuarioFotoPerfil) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.fechaPublicacion = fechaPublicacion;
		this.contenido = contenido;
		this.usuarioUsername = usuarioUsername;
		this.usuarioFotoPerfil = usuarioFotoPerfil;
	}
	
	public PublicacionDTO() {
		
	}//constructor vacio
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public LocalDateTime getFechaPublicacion() {
		return fechaPublicacion;
	}
	public void setFechaPublicacion(LocalDateTime fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}
	public String getContenido() {
		return contenido;
	}
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	public String getUsuarioUsername() {
	    return usuarioUsername;
	}

	public void setUsuarioUsername(String usuarioUsername) {
	    this.usuarioUsername = usuarioUsername;
	}

	public String getUsuarioFotoPerfil() {
		return usuarioFotoPerfil;
	}
	public void setUsuarioFotoPerfil(String usuarioFotoPerfil) {
		this.usuarioFotoPerfil = usuarioFotoPerfil;
	}

	
	@Override
	public String toString() {
		return "PublicacionDTO [id=" + id + ", descripcion=" + descripcion + ", fechaPublicacion=" + fechaPublicacion
				+ ", contenido=" + contenido + ", usuarioUsername=" + usuarioUsername + ", usuarioFotoPerfil="
				+ usuarioFotoPerfil + "]";
	}
	
}
