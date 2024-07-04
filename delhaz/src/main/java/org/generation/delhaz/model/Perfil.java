package org.generation.delhaz.model;

public class Perfil {
	private int id;
	private int usuario_id;
	private String descripcion;
	private static int total=0;
	
	public Perfil(int usuario_id, String descripcion) {
		this.usuario_id = usuario_id;
		this.descripcion = descripcion;
		Perfil.total++;
		this.id = total;
	}//constructor
	
	public Perfil() {
		Perfil.total++;
		this.id = total;
	}//constructor vacio

	public int getUsuario_id() {
		return usuario_id;
	}//getUsuario_id


	public String getDescripcion() {
		return descripcion;
	}//getDescripcion

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}//setDescripcion

	public int getId() {
		return id;
	}//getId

	@Override
	public String toString() {
		return "Perfil [id=" + id + ", usuario_id=" + usuario_id + ", descripcion=" + descripcion + "]";
	}//toString
	
	
}//Class Perfil
