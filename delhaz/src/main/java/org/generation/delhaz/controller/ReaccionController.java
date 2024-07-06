package org.generation.delhaz.controller;

import java.util.ArrayList;
import java.util.List;

import org.generation.delhaz.model.Reaccion;
import org.generation.delhaz.service.ReaccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public List<Reaccion> getAllReactions() {
        return reaccionService.getAllReactions();
    }

    @GetMapping(path="{reaccionId}") //http://localhost:8080/api/reacciones/1
    public Reaccion getReaction(@PathVariable("reaccionId") Long id) {
        return reaccionService.getReaction(id);
    }

    @PostMapping
    public Reaccion addReaccion(@RequestBody Reaccion reaccion) {
        return reaccionService.addReaction(reaccion);
    }
    
    @DeleteMapping(path="{reaccionId}")
    public Reaccion deleteReaction(@PathVariable("reaccionId") Long id) {
        return reaccionService.deleteReaction(id);
    }

    @PutMapping(path = "{reaccionId}") //http://localhost:8080/api/reacciones/1
    public Reaccion updateReaction(@PathVariable("reaccionId") Long id,
                                   @RequestParam Long tipoReaccionId) {
        return reaccionService.updateReaction(id, tipoReaccionId);
    }

}//ReaccionService