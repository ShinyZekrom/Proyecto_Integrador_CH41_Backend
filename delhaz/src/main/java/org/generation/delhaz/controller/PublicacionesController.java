package org.generation.delhaz.controller;

import java.time.LocalDateTime;
//import java.time.LocalDateTime;
import java.util.List;

import org.generation.delhaz.model.Publicacion;
import org.generation.delhaz.service.PublicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api/publicaciones/")
public class PublicacionesController {
	private final PublicacionService publicacionService;
	
	@Autowired
	public PublicacionesController(PublicacionService publicacionService) {
		this.publicacionService=publicacionService;
	}//constructor
	
	@GetMapping
	public List<Publicacion> getPublicaciones() {
		return publicacionService.getAllPublicaciones();
	}//getPublicaciones 
	
	@GetMapping(path="{pubId}")//http://localhost:8080/api/publicaciones/1
	public Publicacion getPublicacion(@PathVariable("pubId") Long id) {
		return publicacionService.getPublicacion(id);
	}//getPublicacion
	
	@DeleteMapping (path="{pubId}")//http://localhost:8080/api/publicaciones/1
	public Publicacion deletePublicacion(@PathVariable("pubId") Long id){
		return publicacionService.deletePublicacion(id);
	}//deletePublicacion
	
	@PostMapping
	public Publicacion addPublicacion(@RequestBody Publicacion publicacion) {
		return publicacionService.addPublicacion(publicacion);
	}//addPublicacion
	
	
	@PutMapping(path="{pubId}")
<<<<<<< HEAD
	public Publicacion updatePublicacion(@PathVariable("pubId") int id,
	           @RequestParam(required = false) String usuario,
	           @RequestParam(required = false) String descripcion,
	           @RequestParam(required = false) LocalDateTime fechaPublicacion,
	           @RequestParam(required = false) String contenido) {
	        return publicacionService.updatePublicacion(id, usuario,
	           descripcion, fechaPublicacion, contenido);
	   
		
	}//updatePublicacion
=======
    public Publicacion updatePublicacion(@PathVariable("pubId") Long id,
                                         @RequestParam(required = false) String descripcion,
                                         @RequestParam(required = false) String contenido) {
        return publicacionService.updatePublicacion(id, descripcion, contenido);
    }//update

>>>>>>> d732f6ecc410adce5acedfa14a1623be0102be85
	

}//PublicacionesController 
