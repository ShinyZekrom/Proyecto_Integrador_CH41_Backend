package org.generation.delhaz.model;

import java.time.LocalDateTime;

public class Reaccion {
    private int id;
    private int usuarioId;
    private int publicacionId;
    private int tipoReaccionId;
    private LocalDateTime fechaReaccion;
    private static int total=0;
	
    //1. constructor
    public Reaccion(int usuarioId, int publicacionId, int tipoReaccionId, LocalDateTime fechaReaccion) {
		super();
		this.usuarioId = usuarioId;
		this.publicacionId = publicacionId;
		this.tipoReaccionId = tipoReaccionId;
		this.fechaReaccion = fechaReaccion;
		Reaccion.total++;
		this.id = total;
	}// Contructor
    
    //2. Constructor vacio
    public Reaccion() { 
		Reaccion.total++;
		this.id = total;
    }//constructor vacio

    //3. Getters and Setters
	public int getUsuarioId() {
		return usuarioId;
	}//getUsuario

	public int getPublicacionId() {
		return publicacionId;
	}//getPublicacion

	public void setTipoReaccion(int tipoReaccion) {
		this.tipoReaccionId = tipoReaccion;
	}//setTipoReaccion

	public LocalDateTime getFechaReaccion() {
		return fechaReaccion;
	}//getFechaReaccion

	public void setFechaReaccion(LocalDateTime fechaReaccion) {
		this.fechaReaccion = fechaReaccion;
	}//setFechaReaccion

	public int getId() {
		return id;
	}//getId
	
	
	public int getTipoReaccionId() {
		return tipoReaccionId;
	}

	public void setTipoReaccionId(int tipoReaccionId) {
		this.tipoReaccionId = tipoReaccionId;
	}

	//4. Tostring
	@Override
	public String toString() {
		return "Reacciones [id=" + id + ", usuarioId=" + usuarioId + ", publicacionId=" + publicacionId
				+ ", tipoReaccion=" + tipoReaccionId + ", fechaReaccion=" + fechaReaccion + "]";
	}//Tostring
}
