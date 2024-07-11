package org.generation.delhaz.service;


import java.util.List;
import java.util.Optional;

import org.generation.delhaz.model.Publicacion;
import org.generation.delhaz.repository.PublicacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublicacionService {
	public final PublicacionRepository publicacionRepository;
	
	@Autowired
	public PublicacionService(PublicacionRepository publicacionRepository) {
	    this.publicacionRepository = publicacionRepository;
	}//cosntructor PublciacionService constructor 
	
	
	public List<Publicacion>getAllPublicaciones(){
		return publicacionRepository.findAll();
	}//getAllPublicaciones

	public Publicacion getPublicacion(Long id) {
		return publicacionRepository.findById(id).orElseThrow(
	            () -> new IllegalArgumentException("La publicación con el id [" + id + "] no existe")
	        );
	}//getPublicacion

	public Publicacion deletePublicacion(Long id) {
		Publicacion tmpPub = null;
        if (publicacionRepository.existsById(id)) {
            tmpPub = publicacionRepository.findById(id).get();
            publicacionRepository.deleteById(id);
        }//if
        return tmpPub;
	}//deletePublicacion

	public Publicacion addPublicacion(Publicacion publicacion) {
		return publicacionRepository.save(publicacion);
	}//addPublicacion

    //Solo permite el update la descripción y el contenido de la publicación
	public Publicacion updatePublicacion(Long id, String descripcion, String contenido) {
		Publicacion tmpPub = null;
		if (publicacionRepository.existsById(id)) {
			Publicacion publicacion = publicacionRepository.findById(id).orElse(null);
			if (descripcion != null)
				publicacion.setDescripcion(descripcion);
			if (contenido != null)
				publicacion.setContenido(contenido);
			publicacionRepository.save(publicacion);
			tmpPub = publicacion;
		} // if
		return tmpPub;

	}// updatePublicacion

	
	
	
}//class PublicacionService 
