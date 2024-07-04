package org.generation.delhaz.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/perfiles")
public class PerfilController {

    
    @GetMapping
    public Perfil obtenerPerfil() {
        Perfil perfil = new Perfil();
        perfil.setUsuarioId("123456");
        perfil.setBiografia("Esta es la biografía del usuario");
        return perfil;
    }

   
    @PostMapping
    public String crearPerfil(@RequestBody Perfil perfil) {
   
        return "Perfil creado exitosamente";
    }

 
    @PutMapping("/{id}")
    public String actualizarPerfil(@PathVariable String id, @RequestBody Perfil perfil) {
       
        return "Perfil con ID " + id + " actualizado exitosamente";
    }

 
    @DeleteMapping("/{id}")
    public String borrarPerfil(@PathVariable String id) {
        return "Perfil con ID " + id + " eliminado exitosamente";
    }
}