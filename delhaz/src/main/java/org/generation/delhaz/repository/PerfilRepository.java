package org.generation.delhaz.repository;

import org.generation.delhaz.model.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerfilRepository extends JpaRepository<Perfil, Long>{

	Object findByUsuarioId(Long usuarioId);

}// interface PerfilRepository
