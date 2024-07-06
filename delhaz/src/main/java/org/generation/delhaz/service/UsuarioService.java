package org.generation.delhaz.service;

import java.util.List;
import java.util.Optional;

import org.generation.delhaz.dto.ChangePassword;
import org.generation.delhaz.model.Usuario;
import org.generation.delhaz.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class UsuarioService {
	public final UsuarioRepository usuarioRepository;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}// constructor
	
	public List<Usuario> getAllUsers(){
		return usuarioRepository.findAll();
	}// getAllUsers
	
	public Usuario getUser(Long id) {
		   return usuarioRepository.findById(id).orElseThrow(
				   ()-> new IllegalArgumentException("El usuario con el id ["+ 
		   id +"] no existe"));
	}//getUser
	
	public Usuario deleteUser(Long id) {
		Usuario tmpUser = null;
		if (usuarioRepository.existsById(id)) {
			tmpUser=usuarioRepository.findById(id).get();
			usuarioRepository.deleteById(id);
		}//if
		return tmpUser;
	}//deleteUser

	public Usuario addUser(Usuario usuario) {
	    Optional<Usuario> emailUser = usuarioRepository.findByEmail(usuario.getEmail());
	    Optional<Usuario> usernameUser = usuarioRepository.findByUsername(usuario.getUsername());

	    if (emailUser.isEmpty() && usernameUser.isEmpty()) {
	        usuario.setPassword(encoder.encode(usuario.getPassword()));
	        return usuarioRepository.save(usuario);
	    } else {
	        String errorMessage = "";
	        if (!emailUser.isEmpty()) {
	            errorMessage += "El usuario con el correo [" + usuario.getEmail() + "] ya existe. ";
	        }
	        if (!usernameUser.isEmpty()) {
	            errorMessage += "El usuario con el nombre de usuario [" + usuario.getUsername() + "] ya existe. ";
	        }
	        System.out.println(errorMessage);
	        return null;
	    }
	}//addUser

	public Usuario updateUser(Long id, ChangePassword changePassword) {
		Usuario tmpUser = null;
		if(usuarioRepository.existsById(id)) {
			tmpUser = usuarioRepository.findById(id).get();
			if(encoder.matches(changePassword.getPassword(), tmpUser.getPassword())) {	
			tmpUser.setPassword(encoder.encode(changePassword.getNewpassword()));
			usuarioRepository.save(tmpUser);
			}else {
				System.out.println("updateUser - El password del usuario [" + id + "] no coincide");
				tmpUser=null;
			}//if equals
		}//if existsById
		return tmpUser;
	}//updateUser

	public boolean validateUser(Usuario usuario) {
		Optional <Usuario> userByEmail =
						usuarioRepository.findByEmail(usuario.getEmail());
		if(userByEmail.isPresent()) {
			Usuario tmpUser =userByEmail.get();
			if(encoder.matches(usuario.getPassword(), tmpUser.getPassword())) {
				return true;
			}//if encoder.matches
		}//if isPresent()
		return false;
	}//validateUser

}//class UsuarioService
