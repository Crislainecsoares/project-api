package com.example.demo;

import com.example.demo.domain.Categoria;
import com.example.demo.domain.Livro;
import com.example.demo.repositories.CategoriaRepository;
import com.example.demo.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	@Autowired // obter o CategoriaRepository que é gerado automaticamente pelo Spring
	private CategoriaRepository categoriaRepository;
	@Autowired // obter o LivroRepository que é gerado automaticamente pelo Spring
	private LivroRepository livroRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		Categoria categoria1 = new Categoria(null, "Casa", "Pato" );

		Livro livro1 = new Livro(null, "My Book", "Somewhere", "Texto", categoria1);

		categoria1.getLivros().addAll(Arrays.asList(livro1));

		this.categoriaRepository.saveAll(Arrays.asList(categoria1));
		this.livroRepository.saveAll(Arrays.asList(livro1));

	}
}
