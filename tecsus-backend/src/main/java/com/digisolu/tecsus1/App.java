package com.digisolu.tecsus1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.digisolu.tecsus1.entidades.Usuarios;
import com.digisolu.tecsus1.repositorios.UsuariosRepositorio;

@SpringBootApplication
public class App implements CommandLineRunner {
	
	@Autowired
	private UsuariosRepositorio repositoriodeusuarios;

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		
		Usuarios user1 = new Usuarios();
		user1.setUsername("admin");
		user1.setEmail("admin@admin");
		user1.setSenha("admin");
		user1.setAcesso(1);
		
		repositoriodeusuarios.save(user1);
	}

}
