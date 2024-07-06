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
    }

    public Reaccion getReaction(Long id) {
        return reaccionRepository.findById(id).orElse(null);
    }

    public Reaccion deleteReaction(Long id) {
        Reaccion reaccion = reaccionRepository.findById(id).orElse(null);
        if (reaccion != null) {
            reaccionRepository.deleteById(id);
        }
        return reaccion;
    }

    public Reaccion addReaction(Reaccion reaccion) {
        return reaccionRepository.save(reaccion);
    }

    public Reaccion updateReaction(Long id, Long tipoReaccionId) {
        Reaccion reaccion = reaccionRepository.findById(id).orElse(null);
        if (reaccion != null) {
            if (tipoReaccionId != 0) {
                reaccion.setTipoReaccionId(tipoReaccionId);
            }
            reaccion = reaccionRepository.save(reaccion);
        }
        return reaccion;
    }//updateReaction
}//classReaccionService 
