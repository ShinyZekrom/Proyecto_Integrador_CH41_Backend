package org.generation.delhaz;

import org.generation.delhaz.config.JwtFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DelhazApplication {

	public static void main(String[] args) {
		SpringApplication.run(DelhazApplication.class, args);
	}//main
	
	@Bean
	public FilterRegistrationBean<JwtFilter> jwtFilter(){
		FilterRegistrationBean<JwtFilter> registrationBean =
				new FilterRegistrationBean<JwtFilter>();
		registrationBean.setFilter(new JwtFilter());
		registrationBean.addUrlPatterns("/api/tiporeaccion/");
		registrationBean.addUrlPatterns("/api/usuarios/");
		return registrationBean;
	}//jwtFilter
	//filtramos donde se requiere el uso del token 
	
}//delhazApplicaion class 

