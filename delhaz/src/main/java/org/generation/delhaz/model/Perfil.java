package org.generation.delhaz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "perfiles")
public class Perfil {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", unique=true, nullable=false)
	private Long id;
    @OneToOne(mappedBy = "perfil")
	private Usuario usuario;
    @Column(columnDefinition = "TEXT")
	private String descripcion;
	
    //1.Constructor
	public Perfil(String descripcion) {
		this.descripcion = descripcion;
	}//constructor
	
	//2.Constructor vacio
	public Perfil() { }//constructor vacio

	//3.Getters and Setters
	public Usuario getUsuario() {
		return usuario;
	}//getUsuario

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}//setUsuario

	public String getDescripcion() {
		return descripcion;
	}//getDescripcion

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}//setDescripcion

	public Long getId() {
		return id;
	}//getId

	@Override
	public String toString() {
		return "Perfil [id=" + id + ", descripcion=" + descripcion + "]";
	}
	//4. toString
	

	
}//Class Perfil
