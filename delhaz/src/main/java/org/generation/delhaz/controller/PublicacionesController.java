package org.generation.delhaz.controller;

import java.time.LocalDateTime;
//import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.generation.delhaz.model.Publicacion;
import org.generation.delhaz.model.Usuario;
import org.generation.delhaz.service.PublicacionService;
import org.generation.delhaz.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins = "http://127.0.0.1:5504")
@RequestMapping(path="/api/publicaciones/")
public class PublicacionesController {
	private final PublicacionService publicacionService;
    private final UsuarioService usuarioService;

	
	@Autowired
	public PublicacionesController(PublicacionService publicacionService, UsuarioService usuarioService) {
		this.publicacionService=publicacionService;
        this.usuarioService = usuarioService;

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
	public ResponseEntity<?> addPublicacion(@RequestBody Map<String, Object> publicacionData) {
	    try {
	        // Parse usuarioId and fetch the Usuario
	        Long usuarioId = Long.parseLong(publicacionData.get("usuarioId").toString());
	        Usuario usuario = usuarioService.getUsuarioById(usuarioId);
	        if (usuario == null) {
	            return ResponseEntity.notFound().build();
	        }

	        // Create and populate the Publicacion object
	        Publicacion publicacion = new Publicacion();
	        publicacion.setUsuario(usuario);
	        publicacion.setDescripcion((String) publicacionData.get("descripcion"));
	        publicacion.setFechaPublicacion(LocalDateTime.now());
	        publicacion.setContenido((String) publicacionData.get("contenido"));

	        // Save the Publicacion
	        System.out.println("Publicacion before saving: " + publicacion);
	        Publicacion savedPublicacion = publicacionService.addPublicacion(publicacion);
	       
	        // Return the saved Publicacion
	        return ResponseEntity.status(HttpStatus.CREATED).body(savedPublicacion);
	    } catch (NumberFormatException e) {
	        return ResponseEntity.badRequest().body("Invalid usuarioId format");
	    } catch (Exception e) {
	        e.printStackTrace();
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                             .body("Error al crear la publicación: " + e.getMessage());
	    }
	}
	
	
	@PutMapping(path="{pubId}")
    public Publicacion updatePublicacion(@PathVariable("pubId") Long id,
                                         @RequestParam(required = false) String descripcion,
                                         @RequestParam(required = false) String contenido) {
        return publicacionService.updatePublicacion(id, descripcion, contenido);
    }//update

	

}//PublicacionesController 