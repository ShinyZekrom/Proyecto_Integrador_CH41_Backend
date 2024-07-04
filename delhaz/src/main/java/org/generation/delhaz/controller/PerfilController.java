package org.generation.delhaz.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

