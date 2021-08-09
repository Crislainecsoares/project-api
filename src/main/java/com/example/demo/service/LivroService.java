package com.example.demo.service;

import com.example.demo.domain.Livro;
import com.example.demo.exceptions.ObjectNotFoundException;
import com.example.demo.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public Livro findById(Integer id) {
        Optional<Livro> obj = livroRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado id: " + id + ", Tipo: " + Livro.class.getName()));
    }
}
