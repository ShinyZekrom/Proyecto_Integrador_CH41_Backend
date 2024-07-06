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

    
    @GetMapping
    public List<Reaccion> getReacciones() {
        return reaccionService.getAllReacciones();
    }//getReaccion

    
    @GetMapping(path="{reaccionid}") // http://localhost:3306/api/reacciones
    public Reaccion getReaccion(@PathVariable int id) {
        return reaccionService.getReaccion(id);
    }//getReaccion
    
    
    @DeleteMapping(path="{reaccionid}")// http://localhost:3306/api/reacciones/1
    public Reaccion deleteReaccion(@PathVariable("reacionId") int id) {
        return reaccionService.deleteReaccion(id);
    }//deleteReaccion

    
    @PostMapping //localhost:3306/api/reacciones
    public Reaccion addReaccion(@RequestBody ReaccionRequest reaccionRequest) {
        return reaccionService.addReaccion(reaccionRequest);
    }//addReaccion
        
}//ReaccionController

