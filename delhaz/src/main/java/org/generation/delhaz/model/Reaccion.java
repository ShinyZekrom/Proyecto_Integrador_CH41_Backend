package org.generation.delhaz.model;

import java.time.LocalDateTime;

public class Reaccion {
    private int id;
    private int usuarioId;
    private int publicacionId;
    private Long tipoReaccionId;
    private LocalDateTime fechaReaccion;
    private static int total=0;
	
    //1. constructor
    public Reaccion(int usuarioId, int publicacionId, int tipoReaccionId, LocalDateTime fechaReaccion) {
		super();
		this.usuarioId = usuarioId;
		this.publicacionId = publicacionId;
		this.tipoReaccionId = (long) tipoReaccionId;
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
    }

    public int getPublicacionId() {
        return publicacionId;
    }

    public Long getTipoReaccionId() {
        return tipoReaccionId;
    }

    public void setTipoReaccionId(Long tipoReaccionId) {
        this.tipoReaccionId = tipoReaccionId;
    }

    public LocalDateTime getFechaReaccion() {
        return fechaReaccion;
    }

    public void setFechaReaccion(LocalDateTime fechaReaccion) {
        this.fechaReaccion = fechaReaccion;
    }

    public int getId() {
        return id;
    }

	//4. Tostring
	@Override
	public String toString() {
		return "Reacciones [id=" + id + ", usuarioId=" + usuarioId + ", publicacionId=" + publicacionId
				+ ", tipoReaccion=" + tipoReaccionId + ", fechaReaccion=" + fechaReaccion + "]";
	}//Tostring
}//classReaccion
