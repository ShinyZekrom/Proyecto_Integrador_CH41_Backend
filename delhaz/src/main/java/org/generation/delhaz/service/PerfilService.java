package org.generation.delhaz.service;

import java.util.List;

import org.generation.delhaz.model.Perfil;
import org.generation.delhaz.repository.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PerfilService {
	public PerfilRepository perfilRepository;
	
	@Autowired
	public PerfilService(PerfilRepository perfilRepository) {
		this.perfilRepository = perfilRepository;
	}//constructor
	
	public List<Perfil> getAllProfiles(){
		return perfilRepository.findAll();
	}// getAllProfiles
	
	public Perfil getProfile(Long id) {
		return perfilRepository.findById(id).orElseThrow(
				()-> new IllegalArgumentException("El perfil con el id [" + id + "] no existe"));
	}//getProfile
	

	public Perfil updateProfile(Long id, String descripcion) {
		Perfil tmpProfile = null;
			if (perfilRepository.existsById(id)) {
				Perfil perfil=perfilRepository.findById(id).get();
				if (descripcion != null) perfil.setDescripcion(descripcion);
				perfilRepository.save(perfil);
				tmpProfile=perfil;
		}
		return tmpProfile;
	}//updateProfile

	
}//Class PerfilService
