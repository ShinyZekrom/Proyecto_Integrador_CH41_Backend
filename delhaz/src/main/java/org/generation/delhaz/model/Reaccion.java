package org.generation.delhaz.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "reacciones") // Nombre de la tabla en la base de datos
public class Reaccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "usuario_id")
    private Long usuarioId;

    @Column(name = "publicacion_id")
    private Long publicacionId;

    @ManyToOne
    @JoinColumn(name = "tipo_reaccion_id")
    private TipoReaccion tipoReaccion;

    @Column(name = "fecha_reaccion")
    private LocalDateTime fechaReaccion;

    // Constructor con todos los campos
    public Reaccion(Long usuarioId, Long publicacionId, TipoReaccion tipoReaccion, LocalDateTime fechaReaccion) {
        this.usuarioId = usuarioId;
        this.publicacionId = publicacionId;
        this.tipoReaccion = tipoReaccion;
        this.fechaReaccion = fechaReaccion;
    }

    // Constructor vacío
    public Reaccion() {
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public TipoReaccion getTipoReaccion() {
        return tipoReaccion;
    }

    public void setTipoReaccion(TipoReaccion tipoReaccion) {
        this.tipoReaccion = tipoReaccion;
    }

    public LocalDateTime getFechaReaccion() {
        return fechaReaccion;
    }

    public void setFechaReaccion(LocalDateTime fechaReaccion) {
        this.fechaReaccion = fechaReaccion;
    }

    // ToString
    @Override
    public String toString() {
        return "Reaccion{" +
                "id=" + id +
                ", usuarioId=" + usuarioId +
                ", publicacionId=" + publicacionId +
                ", tipoReaccion=" + tipoReaccion +
                ", fechaReaccion=" + fechaReaccion +
                '}';
    }
}



