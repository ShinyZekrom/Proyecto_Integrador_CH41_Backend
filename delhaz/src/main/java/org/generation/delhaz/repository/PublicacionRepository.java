package org.generation.delhaz.repository;

import java.util.Optional;

import org.generation.delhaz.model.Publicacion;
import org.generation.delhaz.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicacionRepository extends JpaRepository<Publicacion, Long>{
	
	     Optional<Publicacion> findByUsuario(Usuario usuario);

}//PublicacionRepository Interface 
