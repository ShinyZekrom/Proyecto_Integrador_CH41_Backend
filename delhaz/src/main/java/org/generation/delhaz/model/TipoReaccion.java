package org.generation.delhaz.model;

public class TipoReaccion {
	private int id;
	private String nombre;
	private String icono;
	private static int total=0;
	
	//1.Constructor
	public TipoReaccion(String nombre, String icono) {
		super();
		this.nombre = nombre;
		this.icono = icono;
		TipoReaccion.total++;
		this.id = total;
	}// constructor
	
	//2.Constructor vacio
	public TipoReaccion() {
		TipoReaccion.total++;
		this.id = total;
	}//constructor vacio

	//3.Getters and Setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getIcono() {
		return icono;
	}

	public void setIcono(String icono) {
		this.icono = icono;
	}

	public int getId() {
		return id;
	}
	
	//4.toString
	@Override
	public String toString() {
		return "TipoReaccion [id=" + id + ", nombre=" + nombre + ", icono=" + icono + "]";
	}
	
}//class TipoReaccion
