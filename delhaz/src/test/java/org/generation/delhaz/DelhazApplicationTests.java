package org.generation.delhaz;

<<<<<<< HEAD
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.generation.delhaz.model.Perfil;
=======
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.springframework.http.MediaType;

//métodos Get Put Delete Post
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;

import org.generation.delhaz.model.Usuario;
>>>>>>> a545250f77c48d81f46ba797526986d4e87732e4


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.hamcrest.Matchers.containsString;
<<<<<<< HEAD

=======
>>>>>>> a545250f77c48d81f46ba797526986d4e87732e4

@SpringBootTest
@AutoConfigureMockMvc
class DelhazApplicationTests {
<<<<<<< HEAD
	@Autowired
	private MockMvc mockMvc;
	
	private final String token = "Bearer: eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJsdWlzNEBob3RtYWlsLmNvbSIsInJvbGUiOiJ1c2VyIiwiaWF0IjoxNzIwNDY4MjkxLCJleHAiOjE3MjA1MDQyOTF9.4DSPhGFpf9ND4UpNxJfKtwO9d9-G8SBPFdtscj_YRS0";
	
	@Test
	@DisplayName("Se prueba el GET del endpoint http://localhost:8080/api/perfiles/")
	void pruebaGET() throws Exception {
		this.mockMvc.perform(get("/api/perfiles/1"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string(containsString("Me encanta viajar!!!")));
		
		this.mockMvc.perform(get("/api/perfiles/3"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string(containsString("Amante de viajar")));

		this.mockMvc.perform(get("/api/perfiles/5"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string(containsString("Artista visual")));
=======
	
	@Autowired
	private MockMvc mockMvc;
	
    @Autowired
    private ObjectMapper objectMapper;
	
	private final String token = "Bearer: eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJtYWxkb25hZG8ubHVpcy5pcW1AZ21haWwuY29tIiwicm9sZSI6InVzZXIiLCJpYXQiOjE3MjA0NzkzMzIsImV4cCI6MTcyMDUxNTMzMn0.A-KdpbHc4p5YNkai8FNbzyEu6O0kT3zSfOuNhNqjdsg";
			
    private String asJsonString(final Object obj) {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }// asJsonString

	
	@Test
	@DisplayName("Se prueba el GET del endpoint http://localhost:8080/api/usuarios/1")
	void pruebaGET() throws Exception{
		this.mockMvc.perform(get("/api/usuarios/1") )
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect( content().string(containsString("maldonado.luis.iqm@gmail.com"))
				);
	}//pruebaGET
	
	
	@Test
	@DisplayName("Se prueba el DELETE del endpoint http://localhost:8080/api/usuarios/2")
	@Disabled("Probado una vez, deshabilitado porque el registro ya ha sido borrado")
	void pruebaDELETE() throws Exception{
		this.mockMvc.perform( delete("/api/usuarios/2")
				.header("Authorization", token) 
				)
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect( content().string(containsString("Shinyzekrom559"))
				);
	}//PruebaDELETE
	
	@Test
	@DisplayName("Se prueba el POST del endpoint http://localhost:8080/api/usuarios/")
	@Disabled("Probado una vez, deshabilitado porque no puede haber usuarios registrados")
	void pruebaPOST() throws Exception{
		Usuario user = new Usuario();
		user.setNombre("Alberto Cabrera");
		user.setUsername("shinypalkia");
		user.setPassword("Pa$$w0rd");		
		user.setEmail("luis.maldonado.iqm@gmail.com");
		user.setFechaRegistro(LocalDateTime.now());
		user.setFotoPerfil("jasbdkajsbd.jpeg");
		
		this.mockMvc.perform(post("/api/usuarios/")
				.contentType(MediaType.APPLICATION_JSON)
				.content( asJsonString(user))
				.header("Authorization", token) 
				)
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect( content().string(containsString("shinypalkia"))
				);
	}//pruebaPOST

	@Test
	@DisplayName("Se prueba el PUT para modificar una publicación id 1 ")
	void pruebaPUT() throws Exception{
		this.mockMvc.perform( put("/api/publicaciones/1")
				.queryParam("descripcion", "Probando metodos")
				.header("Authorizaton", token)
				)
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect( content().string(containsString("Probando metodos"))
				);
	}//prueba PUT
>>>>>>> a545250f77c48d81f46ba797526986d4e87732e4

	}//pruebaGET
	
	@Test
	@DisplayName("Se prueba modificar el Id 3")
	void pruebaPUT() throws Exception {
		this.mockMvc.perform(put("/api/perfiles/3")
				.queryParam("descripcion", "Amante de viajar")
				.header("Authorization", token )
				)
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string(containsString("Amante de viajar")));
}//pruebaPUT
	
	@Test
	@DisplayName("Se prueba crear un perfil nuevo(POST)")
	//@Disabled("Se creó el perfil para el usuario_id 12 ")
	void pruebaPOST() throws Exception {
		Perfil p = new Perfil();
		p.setUsuario_id((long) 12);
		p.setDescripcion("Me apasiona viajar");
		
		this.mockMvc.perform(post("/api/perfiles/")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(p))
				.header("Authorization", token )
				)
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string(containsString("Me apasiona viajar")));
}//pruebaPOST
	
	private static String asJsonString(final Object obj) {
	    try {
	      return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	      throw new RuntimeException(e);
	    }//catch
	 } // asJsonString
}//Class EcommerceApplicationTests
