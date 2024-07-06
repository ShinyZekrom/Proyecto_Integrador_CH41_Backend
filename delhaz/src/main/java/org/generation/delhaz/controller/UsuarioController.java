package org.generation.delhaz.controller;

import java.util.List;

import org.generation.delhaz.dto.ChangePassword;
import org.generation.delhaz.model.Usuario;
import org.generation.delhaz.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public List<Usuario> getAllUsers() {
        return usuarioService.getAllUsers();
    }//getAllUsers

    @GetMapping(path="{userId}") //http://localhost:8080/api/usuarios/1
    public Usuario getUserById(@PathVariable("userId") Long id) {
        return usuarioService.getUser(id);
    }//getUser

    /*
     *     @PostMapping("add")
    public Usuario addUser(@RequestBody Usuario usuario) {
        return usuarioService.addUser(usuario);
    }//addUser
     * */
    
    @PostMapping
    public ResponseEntity<?> crearUsuario(@RequestBody Usuario usuario) {
        try {
            Usuario usuarioCreado = usuarioService.crearUsuario(usuario);
            return new ResponseEntity<>(usuarioCreado, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear el usuario: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(path="{userId}")
    public Usuario deleteUser(@PathVariable("userId") Long id) {
        return usuarioService.deleteUser(id);
    }//deleteUser

	@PutMapping(path="{userId}") 
	public Usuario updateUsuario(@RequestBody ChangePassword changePassword, 
			@PathVariable("userId") Long id) {
		return usuarioService.updateUser(id, changePassword);
	}//updateUsuario
    
}//class UsuarioController