package org.generation.delhaz.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;

import org.generation.delhaz.config.JwtFilter;
import org.generation.delhaz.dto.Login;
import org.generation.delhaz.dto.Token;
import org.generation.delhaz.model.Usuario;
import org.generation.delhaz.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
//@CrossOrigin(origins = "http://127.0.0.1:5504")
@RequestMapping(path="/api/login/")
public class LoginController {
	private final UsuarioService usuarioService;
	
	@Autowired
	public LoginController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
		}//constructor
	
    @PostMapping
    public ResponseEntity<?> loginUser(@RequestBody Login login) throws ServletException {
        if (usuarioService.validateUser(login)) {
            Usuario usuario = usuarioService.findByEmail(login.getEmail());
            String token = generateToken(login.getEmail());
            
            Map<String, Object> response = new HashMap<>();
            response.put("accessToken", token);
            response.put("id", usuario.getId());
            response.put("username",usuario.getUsername());
            response.put("email", usuario.getEmail());
            // Puedes añadir más campos del usuario si lo deseas
            
            return ResponseEntity.ok(response);
        }
        throw new ServletException("Nombre de usuario o contraseña incorrectos [" + login.getEmail() + "]");
    }//loginUser

	private String generateToken(String username) {
		Calendar calendar = Calendar.getInstance();//Fecha hora actual
		calendar.add(Calendar.HOUR, 10); // Pruebas
		//calendar.add(Calendar.MINUTE, 30);// Producción
		return Jwts.builder().setSubject(username).claim("role", "user")
		.setIssuedAt(new Date())
		.setExpiration(calendar.getTime())
		.signWith(SignatureAlgorithm.HS256, JwtFilter.secret)
		.compact();
	}//generateToken
}
