package com.dev.screenmusic;

import com.dev.screenmusic.principal.Principal;
import com.dev.screenmusic.repository.ArtistaRepository;
import com.dev.screenmusic.repository.MusicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmusicApplication implements CommandLineRunner {

	@Autowired
	private ArtistaRepository repositorio;

	@Autowired
	private MusicaRepository repositorioMusica;

	public static void main(String[] args) {
		SpringApplication.run(ScreenmusicApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(repositorio, repositorioMusica);
		principal.exibeMenu();
	}
}
