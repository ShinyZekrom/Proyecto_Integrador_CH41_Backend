package org.generation.delhaz.controller;

import java.util.List;

import org.generation.delhaz.model.Perfil;
import org.generation.delhaz.service.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Perfil> getAllProfiles() {
        return perfilService.getAllProfiles();
    }//getAllProfile
	
	@GetMapping(path="{profileId}") //http://localhost:8080/api/perfil/1
    public Perfil getProfile(@PathVariable("profileId") Long id) {
        return perfilService.getProfile(id);
    }//getProfile
	 
	 @PutMapping(path = "{profileId}") //http://localhost:8080/api/profile/1
	    public Perfil updatePerfil(@PathVariable("profileId") Long id,
	           @RequestParam(required = false) String descripcion) {
	        return perfilService.updateProfile(id, descripcion);
	    }//updateProfile
	
	 @PostMapping //http://localhost:8080/api/perfiles/
		public Perfil addPerfil(@RequestBody Perfil perfil) {
			return perfilService.addProfile(perfil);
		}//addPerfil
	 
}//Class PerfilController