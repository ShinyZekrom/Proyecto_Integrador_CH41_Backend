package org.generation.delhaz.controller;

public class Perfil {
    private int id;
    private String usuarioId;
    private String biografia;

    public Perfil() {
    }

    public Perfil(int id, String usuarioId, String biografia) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.biografia = biografia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

