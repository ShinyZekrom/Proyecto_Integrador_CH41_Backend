package org.generation.delhaz.repository;

import java.util.Optional;

import org.generation.delhaz.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	Optional<Usuario> findByEmail(String email);

	Optional<Usuario> findByUsername(String username);

}// interface UsuarioRepository
