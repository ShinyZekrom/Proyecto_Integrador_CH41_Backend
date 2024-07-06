package org.generation.delhaz.service;

import org.generation.delhaz.model.TipoReaccion;
import org.generation.delhaz.repository.TipoReaccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoReaccionService {

    private final TipoReaccionRepository tipoReaccionRepository;

    @Autowired
    public TipoReaccionService(TipoReaccionRepository tipoReaccionRepository) {
        this.tipoReaccionRepository = tipoReaccionRepository;
    }

    public List<TipoReaccion> getAllTiposReaccion() {
        return tipoReaccionRepository.findAll();
    }

    public TipoReaccion getTipoReaccionById(Long id) {
        return tipoReaccionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Tipo de reacción no encontrada con ID: " + id));
    }

    public TipoReaccion saveTipoReaccion(TipoReaccion tipoReaccion) {
        return tipoReaccionRepository.save(tipoReaccion);
    }

    public void deleteTipoReaccion(Long id) {
        tipoReaccionRepository.deleteById(id);
    }
}

