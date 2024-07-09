package org.generation.delhaz.controller;

import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;

import org.generation.delhaz.config.JwtFilter;
import org.generation.delhaz.dto.Login;
import org.generation.delhaz.dto.Token;
import org.generation.delhaz.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping(path="/api/login/")
public class LoginController {
	private final UsuarioService usuarioService;
	
	@Autowired
	public LoginController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
		}//constructor
	
	@PostMapping
	public Token loginUser(@RequestBody Login login) 
								throws ServletException {
		if (usuarioService.validateUser(login)) {
			System.out.println("Usuario Valido " + login.getEmail());
			return new Token(generateToken(login.getEmail()));
		}//if validateUser
		throw new ServletException("Nombre de usuario o contraseña incorrectos ["
				+ login.getEmail() + "]");
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
