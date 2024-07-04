package org.generation.delhaz.model;

public class ReaccionRequest {
    private Long usuarioId;
    private Long publicacionId;
    private Long tipoReaccionId;
    
    // Constructor
    public ReaccionRequest(Long usuarioId, Long publicacionId, Long tipoReaccionId) {
		super();
		this.usuarioId = usuarioId;
		this.publicacionId = publicacionId;
		this.tipoReaccionId = tipoReaccionId;
	}
    
    // Constructor vacio
    public ReaccionRequest() {
    	} 
    
    // Getters y Setters
    public Long getUsuarioId() {
        return usuarioId;
    }

	public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Long getPublicacionId() {
        return publicacionId;
    }

    public void setPublicacionId(Long publicacionId) {
        this.publicacionId = publicacionId;
    }

    public Long getTipoReaccionId() {
        return tipoReaccionId;
    }

    public void setTipoReaccionId(Long tipoReaccionId) {
        this.tipoReaccionId = tipoReaccionId;
    }

    //toString
	@Override
	public String toString() {
		return "ReaccionRequest [usuarioId=" + usuarioId + ", publicacionId=" + publicacionId + ", tipoReaccionId="
				+ tipoReaccionId + "]";
	}   //toString
    
}//class ReaccionRequest
