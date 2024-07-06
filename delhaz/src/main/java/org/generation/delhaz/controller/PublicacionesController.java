package org.generation.delhaz.controller;

import java.time.LocalDateTime;
//import java.time.LocalDateTime;
import java.util.ArrayList;

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
@RequestMapping(path="/api/publicaciones")
public class PublicacionesController {
	private final PublicacionService publicacionService;
	
	@Autowired
	public PublicacionesController(PublicacionService publicacionService) {
		this.publicacionService=publicacionService;
	}//constructor
	
	@GetMapping
	public ArrayList<Publicacion> getPublicaciones() {
		return publicacionService.getAllPublicaciones();
	}//getPublicaciones 
	
	@GetMapping(path="pubId")
	public Publicacion getPublicacion(@PathVariable("pubId") int id) {
		return publicacionService.getPublicacion(id);
	}//getPublicacion
	
	@DeleteMapping (path="{pubId}")
	public Publicacion deletePublicacion(@PathVariable("pubId") int id){
		return publicacionService.deletePublicacion(id);
	}//deletePublicacion
	
	@PostMapping
	public Publicacion addPublicacion(@RequestBody Publicacion publicacion) {
		return publicacionService.addPublicacion(publicacion);
	}//addPublicacion
	
	@PutMapping(path="{pubId}")
	public Publicacion updatePublicacion(@PathVariable("pubId") int id,
	           @RequestParam(required = false) String usuario,
	           @RequestParam(required = false) String descripcion,
	           @RequestParam(required = false) LocalDateTime fechaPublicacion,
	           @RequestParam(required = false) String contenido) {
	        return publicacionService.updatePublicacion(id, usuario,
	           descripcion, fechaPublicacion, contenido);
	   
		
	}//updatePublicacion
	

}//PublicacionesController 
