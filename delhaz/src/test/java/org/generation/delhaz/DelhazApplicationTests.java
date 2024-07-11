package org.generation.delhaz;

//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.web.servlet.MockMvc;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.DisplayName;
//import org.springframework.http.MediaType;

//métodos Get Put Delete Post
/*
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;

import org.generation.delhaz.model.Usuario;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.hamcrest.Matchers.containsString;
*/

//@SpringBootTest
//@AutoConfigureMockMvc
class DelhazApplicationTests {
	/*
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
		user.setTelefono("5554455159");
		
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
*/
}