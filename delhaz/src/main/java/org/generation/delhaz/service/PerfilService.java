package org.generation.delhaz.service;

import java.util.ArrayList;

import org.generation.delhaz.model.Perfil;
import org.springframework.beans.factory.annotation.Autowired;

public class PerfilService {
	public final ArrayList<Perfil> lista = new ArrayList<Perfil>();
	
	@Autowired
	public PerfilService() {
		lista.add(new Perfil(1, "Amante de la naturaleza y la fotografía"));
		lista.add(new Perfil(2, "Desarrollador de software y entusiasta de la tecnología"));
		lista.add(new Perfil(3, "Estudiante de medicina, apasionada por la salud"));
		lista.add(new Perfil(4, "Chef profesional, creador de sabores únicos"));
		lista.add(new Perfil(5, "Artista visual y diseñadora gráfica"));
	}
	
	public ArrayList<Perfil> getAllProfiles(){
		return lista;
	}// getAllProfiles
	
	public Perfil getProfile(int id) {
		Perfil tmpProfile=null;
		for (Perfil perfil : lista) {
			if(perfil.getId()==id) {
				tmpProfile= perfil;
			}// if
		}// foreach
		return tmpProfile;
	}//getProfile
	
	public Perfil deleteProfile(int id) {
		Perfil tmpProfile = null;
		for (Perfil perfil : lista) {
			if(perfil.getId()==id) {
				tmpProfile= lista.remove(lista.indexOf(perfil));
				break;
			}//if
		}//for each
		return tmpProfile;
	}//deleteProfile

	public Perfil updateProfile(int id, String descripcion) {
		Perfil tmpProfile = null;
		for (Perfil perfil : lista) {
			if (perfil.getId() == id) {
				if (descripcion != null)
					perfil.setDescripcion(descripcion);
				break;
			}
		}
		return tmpProfile;
	}//updateProfile
	
}//Class PerfilService
