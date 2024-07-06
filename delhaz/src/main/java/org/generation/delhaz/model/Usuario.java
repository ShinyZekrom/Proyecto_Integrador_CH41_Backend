package org.generation.delhaz.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="usuarios")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", unique=true, nullable=false)
	private Long id;
	@Column(nullable=false)
	private String nombre;
	@Column(nullable=false)
	private String username;
	@Column(nullable=false)
	private String email;
	@Column(nullable=false)
	private String password;
	@Column(nullable=false)
	private LocalDateTime fechaRegistro;
	@Column(nullable=false)
	private String fotoPerfil;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "perfil_id", referencedColumnName = "id")
    private Perfil perfil;
	
	//1. Constructor
	public Usuario(Long id, String nombre, String username, String email, String password, LocalDateTime fechaRegistro,
			String fotoPerfil) {
		this.id = id;
		this.nombre = nombre;
		this.username = username;
		this.email = email;
		this.password = password;
		this.fechaRegistro = fechaRegistro;
		this.fotoPerfil = fotoPerfil;
	}//Constructor

	//2. constructor vacio
	public Usuario() {}// constructor vacio

	//3. Getters and Setters
	public String getNombre() {
		return nombre;
	}//getNombre

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}//setNombre

	public String getUsername() {
		return username;
	}//getUsername

	public void setUsername(String username) {
		this.username = username;
	}//setUsername

	public String getEmail() {
		return email;
	}//getEmail

	public void setEmail(String email) {
		this.email = email;
	}//setEmail

	public String getPassword() {
		return password;
	}//getContraseña

	public void setPassword(String password) {
		this.password = password;
	}//setContraseña

	public LocalDateTime getFechaRegistro() {
		return fechaRegistro;
	}//getFechaRegistro

	public void setFechaRegistro(LocalDateTime fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}//setFechaRegistro

	public String getFotoPerfil() {
		return fotoPerfil;
	}//getFotoPerfil

	public void setFotoPerfil(String fotoPerfil) {
		this.fotoPerfil = fotoPerfil;
	}//setFotoPerfil

	public Long getId() {
		return id;
	}//getId

	public Perfil getPerfil() {
	    return perfil;
	}//getPerfil

	public void setPerfil(Perfil perfil) {
	    this.perfil = perfil;
	}//setPerfil
	
	//4. toString
	
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", username=" + username + ", email=" + email
				+ ", password=" + password + ", fechaRegistro=" + fechaRegistro + ", fotoPerfil=" + fotoPerfil
				+ "]";
	}//toString
	
}//class Usuario
