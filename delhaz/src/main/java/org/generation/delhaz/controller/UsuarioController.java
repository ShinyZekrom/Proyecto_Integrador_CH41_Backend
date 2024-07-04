package org.generation.delhaz.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.generation.delhaz.model.Usuario;
import org.generation.delhaz.service.UsuarioService;
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
@RequestMapping(path="/api/usuarios/")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }//constructor

    @GetMapping //http://localhost:8080/api/usuarios/
    public ArrayList<Usuario> getAllUsers() {
        return usuarioService.getAllUsers();
    }//getAllUsers

    @GetMapping(path="{userId}") //http://localhost:8080/api/usuarios/1
    public Usuario getUserById(@PathVariable("userId") int id) {
        return usuarioService.getUser(id);
    }//getUser

    @PostMapping
    public Usuario addUser(@RequestBody Usuario usuario) {
        return usuarioService.addUser(usuario);
    }//addUser

    @DeleteMapping(path="{userId}")
    public Usuario deleteUser(@PathVariable("userId") int id) {
        return usuarioService.deleteUser(id);
    }//deleteUser

    @PutMapping(path = "{userId}") //http://localhost:8080/api/usuarios/1
    public Usuario updateUsuario(@PathVariable("userId") int id,
           @RequestParam(required = false) String nombre,
           @RequestParam(required = false) String username,
           @RequestParam(required = false) String email,
           @RequestParam(required = false) String contraseña,
           @RequestParam(required = false) LocalDateTime fechaRegistro,
           @RequestParam(required = false) String fotoPerfil) {
        return usuarioService.updateUser(id, nombre, username,
                email, contraseña, fechaRegistro, fotoPerfil);
    }//updateUser
}//class UsuarioController