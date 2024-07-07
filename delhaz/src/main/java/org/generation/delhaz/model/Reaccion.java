package org.generation.delhaz.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="reacciones")
public class Reaccion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", unique=true, nullable=false)
    private Long id;
	@Column(nullable=false)
    private Long usuarioId;
	@Column(nullable=false)
    private Long publicacionId;
	@Column(nullable=false)
    private Long tipoReaccionId;
	@Column(nullable=false)
    private LocalDateTime fechaReaccion;
	
    //1. constructor
	
    public Reaccion(Long id, Long usuarioId, Long publicacionId, Long tipoReaccionId, LocalDateTime fechaReaccion) {
		super();
		this.id = id;
		this.usuarioId = usuarioId;
		this.publicacionId = publicacionId;
		this.tipoReaccionId = tipoReaccionId;
		this.fechaReaccion = fechaReaccion;
	}// Contructor
    
    //2. Constructor vacio
    public Reaccion() { }//constructor vacio

	//3. Getters and Setters
    public Long getUsuarioId() {
		return usuarioId;
	}//getUsuarioId

	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}//setUsuarioId

	public Long getPublicacionId() {
		return publicacionId;
	}//getPublicacionId

	public void setPublicacionId(Long publicacionId) {
		this.publicacionId = publicacionId;
	}//setPublicacionId

	public Long getTipoReaccionId() {
		return tipoReaccionId;
	}//getTipoReaccionId

	public void setTipoReaccionId(Long tipoReaccionId) {
		this.tipoReaccionId = tipoReaccionId;
	}//setTipoReaccionId

	public LocalDateTime getFechaReaccion() {
		return fechaReaccion;
	}

	public void setFechaReaccion(LocalDateTime fechaReaccion) {
		this.fechaReaccion = fechaReaccion;
	}

	public Long getId() {
		return id;
	}//getId
    
    
	//4. Tostring
	@Override
	public String toString() {
		return "Reacciones [id=" + id + ", usuarioId=" + usuarioId + ", publicacionId=" + publicacionId
				+ ", tipoReaccion=" + tipoReaccionId + ", fechaReaccion=" + fechaReaccion + "]";
	}//Tostring

	
}
