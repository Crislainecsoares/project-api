package com.example.demo.service;

import com.example.demo.domain.Livro;
import com.example.demo.exceptions.ObjectNotFoundException;
import com.example.demo.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private LivroRepository livroRepository;

    public Livro findById(Integer id) {
        Optional<Livro> obj = livroRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado id: " + id + ", Tipo: " + Livro.class.getName()));
    }

    public List<Livro> findAll(Integer id_categoria) {
        categoriaService.findById(id_categoria);
        return livroRepository.findAllByCategoria(id_categoria);
    }
}
