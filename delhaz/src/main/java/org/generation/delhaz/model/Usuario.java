package org.generation.delhaz.model;

import java.time.LocalDateTime;

public class Usuario {
	
	private int id;
	private String nombre;
	private String username;
	private String email;
	private String password;
	private LocalDateTime fechaRegistro;
	private String fotoPerfil;
	private static int total=0;
	
	//1. Constructor
	public Usuario(String nombre, String username, String email, String password,
			LocalDateTime fechaRegistro, String fotoPerfil) {
		super();
		this.nombre = nombre;
		this.username = username;
		this.email = email;
		this.password = password;
		this.fechaRegistro = LocalDateTime.now();
		this.fotoPerfil = fotoPerfil;
		Usuario.total++;
		this.id = total;
		
	}//Constructor
	
	//2. constructor vacio
	public Usuario() {
		Usuario.total++;
		this.id = total;
	}// constructor vacio

	
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

	public int getId() {
		return id;
	}//getId

	
	//4. toString
	
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", username=" + username + ", email=" + email
				+ ", contraseña=" + password + ", fecha_registro=" + fechaRegistro + ", foto_perfil=" + fotoPerfil
				+ "]";
	}//toString
	
	
	
	
	
	
}
