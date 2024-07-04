package org.generation.delhaz.controller;

public class Perfil {
	private String usuarioId;
    private String biografia;

    
    public Perfil() {
    }

    public Perfil(String usuarioId, String biografia) {
        this.usuarioId = usuarioId;
        this.biografia = biografia;
    }


    public String getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }
}


