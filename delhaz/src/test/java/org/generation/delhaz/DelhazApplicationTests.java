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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;///checar 

import org.generation.delhaz.model.Publicacion;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.hamcrest.Matchers.containsString;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@AutoConfigureMockMvc
class DelhazApplicationTests {
	@Autowired
	private MockMvc mockMvc;
	private final String token = "Bearer: eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJjYXJvbDc4OUBob3RtYWlsLmNvbSIsInJvbGUiOiJ1c2VyIiwiaWF0IjoxNzIwNDcwMTU5LCJleHAiOjE3MjA1MDYxNTl9.6Eb6vTq1oIu_29VkYZOXofCgopXTBVpYwVX-_V1F64s";

	@Test
	@DisplayName("Se prueba el GET el endpoint http://localhost:8080/api/publicaciones/1")
	void pruebaGET() throws Exception {
		this.mockMvc.perform(get("/api/publicaciones/1"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string(containsString("luis_mald"))
		);
		this.mockMvc.perform(get("/api/publicaciones/2"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string(containsString("Lorem ipsum dolor sit amet, consectetur adipiscing elit."))
		);
	}//pruebaGet
	
	@Test
	@DisplayName("Se prueba el DELETE el endpoint http://localhost:8080/api/publicaciones/5")
	@Disabled("Probado una vez, deshabilitado porque ya no existe la publicacion id 5")
	void pruebaDELETE() throws Exception {
		this.mockMvc.perform(delete("/api/publicaciones/5")
				.header("Authorization", token)
				)
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string(containsString("gibran_12di"))
		);
	}//pruebaDELETE
	
	@Test
	@DisplayName("Se prueba crear una nueva publicacion (POST)")
	//@Disabled("Se creo la publicacion con el  id 7 ")
	void pruebaPOST() throws Exception {
		Publicacion p =new Publicacion();
		p.setUsuario("Hector_hdz");
        p.setDescripcion("Memento Mori.");
        p.setFechaPublicacion(LocalDateTime.now());
        //p.setFechaPublicacion(LocalDateTime.parse("2024-07-03T17:16:53"));
        p.setContenido("https://res.cloudinary.com/dtlbnmahy/image/upload/v1719518755/98_t149wy.jpg");
		
		this.mockMvc.perform(post("/api/publicacion/")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(p))
				.header("Authorization", token)
				)
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string(containsString("Memento Mori"))
		);
	}//pruebaPOST
	
	@Test
	@DisplayName("Se prueba modificar la publicacion id 3")
	
	void pruebaPUT() throws Exception {
		this.mockMvc.perform(put("/api/publicaciones/3")
				.queryParam("descripcion", "Carpe Diem.")
				.header("Authorization", token)
				)
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string(containsString("Carpe Diem."))
		);
	}//pruebaPUT
	
	
	private static String asJsonString(final Object obj) {
	    try {
	      return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	      throw new RuntimeException(e);
	    }//catch
	 } // asJsonString


}//classDelhazApplicationTests
