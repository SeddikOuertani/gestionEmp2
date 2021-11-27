package com.gestionEmp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class gestionEmpApp extends SpringBootServletInitializer {
	
	@Override
    protected SpringApplicationBuilder configure(final SpringApplicationBuilder application) {
        return application.sources(gestionEmpApp.class);
    }
	
	public static void main(String [] args) {
		SpringApplication.run(gestionEmpApp.class, args);
	}
}
