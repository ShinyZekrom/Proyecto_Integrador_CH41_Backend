package org.generation.delhaz.service;

import java.time.LocalDateTime;
import java.util.List;

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

    public List<Reaccion> getAllReactions() {
        return reaccionRepository.findAll();
    }//getAllReactions

    public Reaccion getReaction(Long id) {
        return reaccionRepository.findById(id).orElse(null);
    }//getReaccion

    public Reaccion addReaction(Reaccion reaccion) {
        return reaccionRepository.save(reaccion);
    }

    public Reaccion deleteReaction(Long id) {
        Reaccion reaccion = reaccionRepository.findById(id).orElse(null);
        if (reaccion != null) {
            reaccionRepository.delete(reaccion);
        }
        return reaccion;
    }//deleteReaction

    public Reaccion updateReaction(Long id, Long tipoReaccionId) {
        Reaccion reaccion = reaccionRepository.findById(id).orElse(null);
        if (reaccion != null) {
            reaccion.setTipoReaccionId(tipoReaccionId);
            reaccion.setFechaReaccion(LocalDateTime.now());
            return reaccionRepository.save(reaccion);
        }
        return null;
    }//updateReaction
}//class ReaccionService