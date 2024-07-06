package org.generation.delhaz.repository;

import java.util.Optional;

import org.generation.delhaz.model.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerfilRepository extends JpaRepository<Perfil, Long>{
	
	Optional<Perfil> findByUsuarioId(Long usuarioId);
}// interface PerfilRepository
