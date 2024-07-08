package org.generation.delhaz;

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


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.hamcrest.Matchers.containsString;


@SpringBootTest
@AutoConfigureMockMvc
class DelhazApplicationTests {
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
