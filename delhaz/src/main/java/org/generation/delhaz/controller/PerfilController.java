package org.generation.delhaz.controller;

import java.util.List;

import org.generation.delhaz.model.Perfil;
import org.generation.delhaz.service.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api/perfiles/")
public class PerfilController {
	private final PerfilService perfilService;
	
	@Autowired
	public PerfilController(PerfilService perfilService) {
		this.perfilService= perfilService;
	}
	
	@GetMapping //http://localhost:8080/api/perfil/
    public ResponseEntity<List<Perfil>> getAllProfiles() {
        return ResponseEntity.ok(perfilService.getAllProfiles());
    }//getAllProfile
	
	@GetMapping(path="{profileId}") //http://localhost:8080/api/perfil/1
    public ResponseEntity<Perfil> getProfile(@PathVariable("profileId") Long id) {
        return ResponseEntity.ok(perfilService.getProfile(id));
    }//getProfile
	 
	 @PutMapping(path = "{profileId}") //http://localhost:8080/api/profile/1
	 public ResponseEntity<Perfil> updatePerfil(
	            @PathVariable("profileId") Long id,
	            @RequestParam(required = false) String descripcion) {
	        return ResponseEntity.ok(perfilService.updateProfile(id, descripcion));
	    }//updateProfile
	 
	 @PostMapping("/usuario/{usuarioId}")
	    public ResponseEntity<Perfil> createProfile(
	            @PathVariable("usuarioId") Long usuarioId,
	            @RequestBody Perfil nuevoPerfil) {
	        return new ResponseEntity<>(perfilService.createProfile(usuarioId, nuevoPerfil), HttpStatus.CREATED);
	    }//createProfile
	 
	 @GetMapping("/usuario/{usuarioId}")
	    public ResponseEntity<Perfil> getProfileByUsuarioId(@PathVariable("usuarioId") Long usuarioId) {
	        return ResponseEntity.ok(perfilService.getProfileByUsuarioId(usuarioId));
	    }// getProfileByUsuarioId
	 
	
}//Class PerfilController