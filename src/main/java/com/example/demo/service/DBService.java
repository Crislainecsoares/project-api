package com.example.demo.service;

import com.example.demo.domain.Categoria;
import com.example.demo.domain.Livro;
import com.example.demo.repositories.CategoriaRepository;
import com.example.demo.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {

    @Autowired // obter o CategoriaRepository que é gerado automaticamente pelo Spring
    private CategoriaRepository categoriaRepository;
    @Autowired // obter o LivroRepository que é gerado automaticamente pelo Spring
    private LivroRepository livroRepository;

    public void DataBaseInstance() {

        Categoria categoria1 = new Categoria(null, "Casa", "Pato" );

        Livro livro1 = new Livro(null, "My Book", "Somewhere", "Textoooooooooo", categoria1);

        categoria1.getLivros().addAll(Arrays.asList(livro1));

        this.categoriaRepository.saveAll(Arrays.asList(categoria1));
        this.livroRepository.saveAll(Arrays.asList(livro1));

    }
}
