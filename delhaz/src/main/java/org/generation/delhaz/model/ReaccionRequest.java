package org.generation.delhaz.model;

import java.time.LocalDateTime;

public class ReaccionRequest {
    private Long usuarioId;
    private Long publicacionId;
    private TipoReaccion tipoReaccion;
    private LocalDateTime fechaReaccion;


	public ReaccionRequest(long usuarioId, long publicacionId, TipoReaccion tipoReaccion) {
		this.usuarioId = usuarioId;
        this.publicacionId = publicacionId;
        this.tipoReaccion = tipoReaccion;
        this.fechaReaccion = LocalDateTime.now();
	}//constructor

	// Getters y Setters
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

    public TipoReaccion getTipoReaccion() {
        return tipoReaccion;
    }//getTipoReaccion

    public void setTipoReaccion(TipoReaccion tipoReaccion) {
        this.tipoReaccion = tipoReaccion;
    }//setTipoReaccion

    public LocalDateTime getFechaReaccion() {
        return fechaReaccion;
    }//getFechaReaccion

    public void setFechaReaccion(LocalDateTime fechaReaccion) {
        this.fechaReaccion = fechaReaccion;
    }//setFechaReaccion

	@Override
	public String toString() {
		return "ReaccionRequest [usuarioId=" + usuarioId + ", publicacionId=" + publicacionId + ", tipoReaccion="
				+ tipoReaccion + ", fechaReaccion=" + fechaReaccion + "]";
	}//toString

   
}


