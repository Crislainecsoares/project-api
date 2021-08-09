package com.example.demo.resources;

import com.example.demo.domain.Livro;
import com.example.demo.dto.LivroDTO;
import com.example.demo.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/livros")
public class LivroResource {

    @Autowired
    private LivroService livroService;


    @GetMapping(value = "/{id}")
    public ResponseEntity<Livro> findById(@PathVariable Integer id) {
        Livro obj = livroService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping
    public ResponseEntity<List< LivroDTO >> findAll(@RequestParam(value = "categoria" , defaultValue = "0") Integer id_categoria) {
        List<Livro> list = livroService.findAll(id_categoria);
        List<LivroDTO> listDTO = list.stream().map(obj -> new LivroDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }


}
