package com.ydr29913.tarea3dwesydr29913;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Tarea3dwesydr29913Application {

	@Bean
	public Principal applicationStartupRunner() {
		return new Principal();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Tarea3dwesydr29913Application.class, args);
	}

}
