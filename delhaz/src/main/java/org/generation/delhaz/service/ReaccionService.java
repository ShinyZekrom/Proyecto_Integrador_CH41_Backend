package org.generation.delhaz.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import org.generation.delhaz.model.Reaccion;
import org.generation.delhaz.repository.ReaccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReaccionService {
    
    private final ReaccionRepository reaccionRepository;

    @Autowired
    public ReaccionService(ReaccionRepository reaccionRepository) {
        this.reaccionRepository = reaccionRepository;
    }

    public ArrayList<Reaccion> getAllReactions() {
        return new ArrayList<>(reaccionRepository.findAll());
    }

    public Reaccion getReaction(long id) {
        return reaccionRepository.findById(id).orElse(null);
    }

    public Reaccion addReaction(Reaccion reaccion) {
        return reaccionRepository.save(reaccion);
    }

    public Reaccion deleteReaction(long id) {
        Reaccion reaccion = reaccionRepository.findById(id).orElse(null);
        if (reaccion != null) {
            reaccionRepository.delete(reaccion);
        }
        return reaccion;
    }

    public Reaccion updateReaction(long id, long tipoReaccionId) {
        Reaccion reaccion = reaccionRepository.findById(id).orElse(null);
        if (reaccion != null) {
            reaccion.setTipoReaccionId(tipoReaccionId);
            reaccion.setFechaReaccion(LocalDateTime.now());
            return reaccionRepository.save(reaccion);
        }
        return null;
    }
}