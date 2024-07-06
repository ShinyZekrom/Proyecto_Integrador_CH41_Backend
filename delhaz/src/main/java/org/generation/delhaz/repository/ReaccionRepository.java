package org.generation.delhaz.repository;

import org.generation.delhaz.model.Reaccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface ReaccionRepository extends JpaRepository<Reaccion, Long> {

    @Transactional
    void deleteByUsuarioIdAndPublicacionId(Long usuarioId, Long publicacionId);
}

