package org.generation.delhaz.controller;

import java.util.ArrayList;

import org.generation.delhaz.model.Perfil;
import org.generation.delhaz.service.PerfilService;
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
@RequestMapping(path="/api/perfil/")
public class PerfilController {
	private final PerfilService perfilService;
	
	@Autowired
	public PerfilController(PerfilService perfilService) {
		this.perfilService= perfilService;
	}
	
	@GetMapping //http://localhost:8080/api/perfil/
    public ArrayList<Perfil> getAllProfiles() {
        return perfilService.getAllProfiles();
    }//getAllProfile
	
	@GetMapping(path="{profileId}") //http://localhost:8080/api/perfil/1
    public Perfil getProfileById(@PathVariable("profileId") int id) {
        return perfilService.getProfile(id);
    }//getProfile
	
	 @DeleteMapping(path="{profileId}")
	    public Perfil deleteProfile(@PathVariable("profileId") int id) {
	        return perfilService.deleteProfile(id);
	    }//deleteProfile
	 
	 @PostMapping
	 public Perfil addPerfil(@RequestBody Perfil perfil) {
		 return perfilService.addProfile(perfil);
	 }//addProfile
	 
	 @PutMapping(path = "{profileId}") //http://localhost:8080/api/profile/1
	    public Perfil updatePerfil(@PathVariable("profileId") int id,
	           @RequestParam(required = false) int usuario_id,
	           @RequestParam(required = false) String descripcion) {
	        return perfilService.updateProfile(id, descripcion);
	    }//updateProfile
	
}//Class PerfilController
