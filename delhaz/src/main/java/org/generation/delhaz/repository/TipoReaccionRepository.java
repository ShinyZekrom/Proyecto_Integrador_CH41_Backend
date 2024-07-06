package org.generation.delhaz.repository;

import java.util.Optional;

import org.generation.delhaz.model.TipoReaccion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoReaccionRepository extends JpaRepository<TipoReaccion, Long>{

	Optional<TipoReaccion> findByNombre(String nombre);
}
