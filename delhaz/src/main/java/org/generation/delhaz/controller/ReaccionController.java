package org.generation.delhaz.controller;

import java.util.ArrayList;
import org.generation.delhaz.model.Reaccion;
import org.generation.delhaz.service.ReaccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api/reacciones/")
public class ReaccionController {

    private final ReaccionService reaccionService;

    @Autowired
    public ReaccionController(ReaccionService reaccionService) {
        this.reaccionService = reaccionService;
    }

    @GetMapping //http://localhost:8080/api/reacciones/
    public ArrayList<Reaccion> getAllReactions() {
        return reaccionService.getAllReactions();
    }

    @GetMapping(path="{reaccionId}") //http://localhost:8080/api/reacciones/1
    public Reaccion getReaction(@PathVariable("reaccionId") int id) {
        return reaccionService.getReaction(id);
    }

    //no se añade una nueva reacción debido a que se maneja en la tabla de TipoReaccion
    
    @DeleteMapping(path="{reaccionId}")
    public Reaccion deleteReaction(@PathVariable("reaccionId") int id) {
        return reaccionService.deleteReaction(id);
    }

    @PutMapping(path = "{reaccionId}") //http://localhost:8080/api/reacciones/1
    public Reaccion updateReaction(@PathVariable("reaccionId") int id,
                                   @RequestParam int tipoReaccionId) {
        return reaccionService.updateReaction(id, tipoReaccionId, tipoReaccionId, tipoReaccionId, null);
    }

}