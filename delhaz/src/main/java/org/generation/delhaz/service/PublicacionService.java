package org.generation.delhaz.service;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.generation.delhaz.model.Publicacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublicacionService {
	public final ArrayList<Publicacion> lista =new ArrayList<Publicacion>();
	
	@Autowired
	public PublicacionService() {
		lista.add(new Publicacion(
						"karen_garcia", 
						"Lorem ipsum dolor sit amet, consectetur adipiscing elit.", 
						LocalDateTime.now(), 
						"https://res.cloudinary.com/dtlbnmahy/image/upload/v1719523118/photo-1718114885158-a3157f5fc443_nup4mp.jpg"));
		lista.add(new Publicacion(
				"luis_mald", 
				"Phasellus vehicula justo eget diam posuere sollicitudin.",
				LocalDateTime.now(),				
				"https://res.cloudinary.com/dtlbnmahy/image/upload/v1719518755/98_t149wy.jpg"));
		lista.add(new Publicacion(
                "carol_hrdz",
                 "Integer vitae justo eget magna fermentum iaculis eu non diam.",
                 LocalDateTime.now(),
                 "https://res.cloudinary.com/dtlbnmahy/image/upload/v1719523146/conoce-5-lenguajes-de-programacion-basicos_s4lbwy.jpg"));
		lista.add(new Publicacion(
				"alan_trejo", 
				"Sed do eiusmod tempor.",
				LocalDateTime.now(),
				"https://res.cloudinary.com/dtlbnmahy/image/upload/v1719523691/images_1_bovq12.jpg"));
		lista.add(new Publicacion(
				"gibran_12di", 
				"Curabitur pretium tincidunt lacus. Nulla gravida orci.",
				LocalDateTime.now(),
				"https://res.cloudinary.com/dtlbnmahy/image/upload/v1719523749/images_tlbyg9.jpg"));
	}//PublciacionService constructor 
	
	public ArrayList<Publicacion>getAllPublicaciones(){
		return lista;
	}//getAllPublicaciones

	public Publicacion getPublicacion(int id) {
		Publicacion tmpPub=null;
		for (Publicacion publicacion : lista) {
			if(publicacion.getId()==id) {
				tmpPub=publicacion;
				break;
			}//if
		}//foreach
		return tmpPub;
	}//getPublicacion

	public Publicacion deletePublicacion(int id) {
		Publicacion tmpPub=null;
		for (Publicacion publicacion : lista) {
			if(publicacion.getId()==id) {
				tmpPub=publicacion;
				lista.remove(lista.indexOf(publicacion));
				break;
			}//if
		}//foreach	
		return tmpPub;
	}//deletePublicacion

	public Publicacion addPublicacion(Publicacion publicacion) {
		lista.add(publicacion);
		return publicacion;
	}//addProducto

	public Publicacion updatePublicacion(int id, String usuario, String descripcion, LocalDateTime fechaPublicacion,
			String contenido) {
		Publicacion tmpPub=null;
		for (Publicacion publicacion : lista) {
			if (publicacion.getId() == id) {
				if (usuario != null)publicacion.setUsuario(usuario);
				if (descripcion != null)publicacion.setDescripcion(descripcion);
				if (descripcion != null)publicacion.setDescripcion(descripcion);
				if (fechaPublicacion!= null)publicacion.setFechaPublicacion(fechaPublicacion);
				if (contenido!= null)publicacion.setContenido(contenido);
				tmpPub = publicacion;
				break;	
			}//if			
		}//foreach			
		return tmpPub;
	}//update
	
	
}//class PublicacionService 
