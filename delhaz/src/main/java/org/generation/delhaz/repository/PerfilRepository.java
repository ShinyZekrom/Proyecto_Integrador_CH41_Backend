package org.generation.delhaz.repository;

import java.util.Optional;

import org.generation.delhaz.model.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Long> {
	Optional<Perfil>findByDescripcion(String descripcion);
}//Interface PerfilReposirory