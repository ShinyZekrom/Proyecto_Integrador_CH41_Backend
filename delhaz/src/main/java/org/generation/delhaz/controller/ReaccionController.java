package org.generation.delhaz.controller;


import org.generation.delhaz.model.Reaccion;
import org.generation.delhaz.model.ReaccionRequest;
import org.generation.delhaz.service.ReaccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/reacciones/")
public class ReaccionController {
	
	//CRUD - Create - Read - Update - Delete
	//HTTP - POST - GET - PUT - DELETE

    private final ReaccionService reaccionService;
    @Autowired
    public ReaccionController(ReaccionService reaccionService) {
        this.reaccionService = reaccionService;
    }//constructor

    
    @GetMapping // http://localhost:8080/api/reacciones/
    public List<Reaccion> getReacciones() {
        return reaccionService.getAllReacciones();
    }//getReaccion

    
    @GetMapping(path="{reaccionid}") // http://localhost:8080/api/reacciones/1
    public Reaccion getReaccion(@PathVariable Long id) {
        return reaccionService.getReaccion(id);
    }//getReaccion
    
    
    @DeleteMapping(path="{reaccionid}")// http://localhost:8080/api/reacciones/1
    public ReaccionRequest deleteReaccion(@PathVariable("reacionId") Long id) {
        return reaccionService.deleteReaccion(id);
    }//deleteReaccion

    
    @PostMapping //localhost:8080/api/reacciones/
    public ReaccionRequest addReaccion(@RequestBody ReaccionRequest reaccionRequest) {
        return reaccionService.addReaccion(reaccionRequest);
    }//addReaccion
    
    @PutMapping(path="{reaccionid}")// http://localhost:8080/api/reacciones/1
    	public Reaccion updateReaccion(@PathVariable("usuarioId") Long id,
	           @RequestParam(required = false) int usuario_id,
	           @RequestParam(required = false) String reaccion) {
	        return reaccionService.updateReaccion(id, reaccion);
    }//updateReaccion 
}//ReaccionController

