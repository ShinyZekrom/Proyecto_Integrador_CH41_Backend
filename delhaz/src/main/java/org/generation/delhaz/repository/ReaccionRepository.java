package org.generation.delhaz.repository;

import org.generation.delhaz.model.Reaccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReaccionRepository extends JpaRepository<Reaccion, Long> {
    // Métodos CRUD 
}
