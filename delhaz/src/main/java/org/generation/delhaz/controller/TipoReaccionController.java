package org.generation.delhaz.controller;

import java.util.ArrayList;

import org.generation.delhaz.model.TipoReaccion;
import org.generation.delhaz.service.TipoReaccionService;
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
@RequestMapping(path="/api/tiporeacciones/")
public class TipoReaccionController {
	
	private final TipoReaccionService tipoReaccionService;
	
	@Autowired
    public TipoReaccionController(TipoReaccionService tipoReaccionService) {
        this.tipoReaccionService = tipoReaccionService;
    }//constructor
	
	@GetMapping //http://localhost:8080/api/tiporeacciones/
    public ArrayList<TipoReaccion> getAllReactionstype() {
        return tipoReaccionService.getAllReactionstype();
    }//getAllReactiontypes
	
    @GetMapping(path="{reactiontypeId}") //http://localhost:8080/api/tiporeacciones/1
    public TipoReaccion getReactiontype(@PathVariable("reactiontypeId") int id) {
        return tipoReaccionService.getReactiontype(id);
    }//getReaction

    @PostMapping
    public TipoReaccion addReactiontype(@RequestBody TipoReaccion tipoReaccion) {
        return tipoReaccionService.addReactiontype(tipoReaccion);
    }//addReaction

    @DeleteMapping(path="{reactiontypeId}")
    public TipoReaccion deleteReactiontype(@PathVariable("reactiontypeId") int id) {
        return tipoReaccionService.deleteReactiontype(id);
    }//deleteUser

    @PutMapping(path = "{reactiontypeId}") //http://localhost:8080/api/usuarios/1
    public TipoReaccion updateReactiontype(@PathVariable("reactiontypeId") int id,
           @RequestParam(required = false) String nombre,
           @RequestParam(required = false) String icono) {
        return tipoReaccionService.updateReactiontype(id, nombre, icono);
    }//updateUser
	
}//class TipoReaccionController
