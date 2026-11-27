package com.prueba1.api1;

import java.beans.BeanProperty;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.prueba1.api1.service.ProductoService;

@SpringBootApplication
public class Api1Application {

	public static void main(String[] args) {
		SpringApplication.run(Api1Application.class, args);
	}

	// Bean para inicializar los productos en la base de datos al iniciar la aplicación
	@Bean
	CommandLineRunner init(ProductoService productoService) {
		return args -> {
			productoService.cargarProductos();//carga los productos en la base de datos
		};
	}
}

