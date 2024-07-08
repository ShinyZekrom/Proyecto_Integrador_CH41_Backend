package org.generation.delhaz;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.hamcrest.Matchers.containsString;


@SpringBootTest
@AutoConfigureMockMvc
class DelhazApplicationTests {
	@Autowired
	private MockMvc mockMvc;
	
	
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
		.andExpect(content().string(containsString("Estudiante de medicina, apasionada por la salud")));

		this.mockMvc.perform(get("/api/perfiles/5"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string(containsString("Artista visual")));

	}//pruebaGET
	
	@Test
	@DisplayName("Se prueba modificar el Id 4")
	//@Disabled("Probado una vez, deshabilitado por que ya no existe el producto Id 1")
	void pruebaPUT() throws Exception {
		this.mockMvc.perform(put("/api/perfiles/4")
				.queryParam("descripcion", "Me fascina conecer lugares nuevos")
				)
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string(containsString("Me fascina conecer lugares nuevos")));
}//pruebaPUT
}//Class EcommerceApplicationTests
