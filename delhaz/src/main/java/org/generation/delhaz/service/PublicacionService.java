package org.generation.delhaz.service;


import java.util.List;

import javax.transaction.Transactional;

import org.generation.delhaz.model.Publicacion;
import org.generation.delhaz.model.Usuario;
import org.generation.delhaz.repository.PublicacionRepository;
import org.generation.delhaz.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublicacionService {
	public final PublicacionRepository publicacionRepository;
	public final UsuarioRepository usuarioRepository;
	
	@Autowired
	public PublicacionService(PublicacionRepository publicacionRepository, UsuarioRepository usuarioRepository) {
	    this.publicacionRepository = publicacionRepository;
		this.usuarioRepository = usuarioRepository;
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


	@Transactional
		public Publicacion addPublicacion(Publicacion publicacion) {
		    System.out.println("Adding publication: " + publicacion);
		    System.out.println("Usuario: " + publicacion.getUsuario());
		if (publicacion.getUsuario() == null) {
	        throw new IllegalArgumentException("La publicación debe tener un usuario asociado");
	    }
	    // Asegúrate de que el usuario existe en la base de datos
	    Usuario usuario = usuarioRepository.findById(publicacion.getUsuario().getId())
	        .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));
	    publicacion.setUsuario(usuario);
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
