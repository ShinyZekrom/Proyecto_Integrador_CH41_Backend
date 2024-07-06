package org.generation.delhaz.model;

import org.generation.delhaz.model.Reaccion;
import org.generation.delhaz.model.ReaccionRequest;
import org.generation.delhaz.service.ReaccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reacciones")
public class TipoReaccion {

    private final ReaccionService reaccionService;

    @Autowired
    public TipoReaccion(ReaccionService reaccionService) {
        this.reaccionService = reaccionService;
    }

    // Endpoint para obtener todas las reacciones
    @GetMapping
    public List<Reaccion> obtenerTodasLasReacciones() {
        return reaccionService.obtenerTodasLasReacciones();
    }

    // Endpoint para obtener una reaccion por su ID
    @GetMapping("/{id}")
    public Reaccion obtenerReaccionPorId(@PathVariable Long id) {
        return reaccionService.obtenerReaccionPorId(id);
    }

    // Endpoint para crear una nueva reaccion
    @PostMapping
    public Reaccion crearReaccion(@RequestBody ReaccionRequest reaccionRequest) {
        return reaccionService.crearReaccion(reaccionRequest);
    }

    // Endpoint para eliminar una reaccion por su ID
    @DeleteMapping("/{id}")
    public void eliminarReaccion(@PathVariable Long id) {
        reaccionService.eliminarReaccion(id);
    }
}



