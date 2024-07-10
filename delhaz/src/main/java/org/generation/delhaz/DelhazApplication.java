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
<<<<<<< HEAD
		registrationBean.addUrlPatterns("/api/tiporeacciones/");
=======
>>>>>>> a545250f77c48d81f46ba797526986d4e87732e4
		registrationBean.addUrlPatterns("/api/usuarios/");
		registrationBean.addUrlPatterns("/api/login/");
		return registrationBean;
	}//jwtFilter
	//filtramos donde se requiere el uso del token
	
}//delhazApplicaion class 