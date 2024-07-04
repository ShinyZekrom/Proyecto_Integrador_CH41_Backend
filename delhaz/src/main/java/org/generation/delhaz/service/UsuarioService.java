package org.generation.delhaz.service;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.generation.delhaz.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
	public final ArrayList<Usuario> lista = new ArrayList<Usuario>();
	
	@Autowired
	public UsuarioService() {
		lista.add(new Usuario("Karen Garcia", "karen_garcia", "karen123@hotmail.com", "Dk_170195", LocalDateTime.now(), 
				"https://res.cloudinary.com/dtlbnmahy/image/upload/v1719518028/WhatsApp_Image_2024-06-20_at_11.30.09_tl2flj.jpg"));
		lista.add(new Usuario("Luis Maldonado", "luis_mald", "luis456@hotmail.com", "Luis0123#", LocalDateTime.now(),
				"https://res.cloudinary.com/dtlbnmahy/image/upload/v1719518755/98_t149wy.jpg"));
		lista.add(new Usuario("Carol Hernandez", "carol_hrdz", "carol789@hotmail.com", "Hrdz?4567", LocalDateTime.now(),
				"https://res.cloudinary.com/dtlbnmahy/image/upload/v1719523146/conoce-5-lenguajes-de-programacion-basicos_s4lbwy.jpg"));
		lista.add(new Usuario("Alan Trejo", "alan_trejo", "alan123@hotmail.com","Trejo.890", LocalDateTime.now(),
				"https://res.cloudinary.com/dtlbnmahy/image/upload/v1719523691/images_1_bovq12.jpg"));
		lista.add(new Usuario("Gibran Diaz", "gibran_12di", "gibran456@hotmail.com", "Di234569?", LocalDateTime.now(),
				"https://res.cloudinary.com/dtlbnmahy/image/upload/v1719523749/images_tlbyg9.jpg"));

	}// constructor
	
	public ArrayList<Usuario> getAllUsers(){
		return lista;
	}// getAllUsers
	
	public Usuario getUser(int id) {
		Usuario tmpUser=null;
		for (Usuario usuario : lista) {
			if(usuario.getId()==id) {
				tmpUser= usuario;
			}// if
		}// foreach
		return tmpUser;
	}//getUser
	
	public Usuario deleteUser(int id) {
		Usuario tmpUser = null;
		for (Usuario usuario : lista) {
			if(usuario.getId()==id) {
				tmpUser= lista.remove(lista.indexOf(usuario));
				break;
			}//if
		}//for each
		return tmpUser;
	}//deleteUser

	public Usuario addUser(Usuario usuario) {
		Usuario tmpUser=null;
		boolean existe=false;
		for (Usuario user : lista) {
			if(user.getNombre().equals(usuario.getNombre())) {
				existe = true;
				break;
			}// if
		}//foreach
		if(! existe) {
			lista.add(usuario);
			tmpUser=usuario;
		}// if ! existe
		return tmpUser;
	}//addUser

	public Usuario updateUser(int id, String nombre, String username, String email, String contraseña,
			LocalDateTime fechaRegistro, String fotoPerfil) {
		Usuario tmpUser = null;
		for (Usuario usuario : lista) {
			if (usuario.getId() == id) {
				if (nombre != null)
					usuario.setNombre(nombre);
				if (username != null)
					usuario.setUsername(username);
				if (email != null)
					usuario.setEmail(email);
				if (contraseña != null)
					usuario.setContraseña(contraseña);
				if (fechaRegistro!= null)
					usuario.setFechaRegistro(fechaRegistro);
				if (fotoPerfil != null)
					usuario.setFotoPerfil(fotoPerfil);
				tmpUser = usuario;
				break;
			}
		}
		return tmpUser;
	}//updateUser

}//class UsuarioService
