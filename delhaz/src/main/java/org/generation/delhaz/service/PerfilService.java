package org.generation.delhaz.service;

import java.util.List;

import javax.transaction.Transactional;

import org.generation.delhaz.model.Perfil;
import org.generation.delhaz.repository.PerfilRepository;
import org.generation.delhaz.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PerfilService {
	public final PerfilRepository perfilRepository;
	public final UsuarioRepository usuarioRepository;
	
	@Autowired
    public PerfilService(PerfilRepository perfilRepository, UsuarioRepository usuarioRepository) {
        this.perfilRepository = perfilRepository;
        this.usuarioRepository = usuarioRepository;
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

	  @Transactional
	    public Perfil createProfile(Long usuarioId, Perfil nuevoPerfil) {
	        return usuarioRepository.findById(usuarioId)
	                .map(usuario -> {
	                    if (usuario.getPerfil() != null) {
	                        throw new IllegalStateException("El usuario ya tiene un perfil asociado");
	                    }
	                    nuevoPerfil.setUsuario(usuario);
	                    usuario.setPerfil(nuevoPerfil);
	                    return perfilRepository.save(nuevoPerfil);
	                })
	                .orElseThrow(() -> new IllegalArgumentException("El usuario con el id [" + usuarioId + "] no existe"));
	    }//createProfile
	  
	    public Perfil getProfileByUsuarioId(Long usuarioId) {
	        return perfilRepository.findByUsuarioId(usuarioId)
	                .orElseThrow(() -> new IllegalArgumentException("No se encontró perfil para el usuario con id [" + usuarioId + "]"));
	    }//getProfileByUsuarioId
	
}//Class PerfilService