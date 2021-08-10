package com.example.demo.resources;

import com.example.demo.domain.Livro;
import com.example.demo.dto.LivroDTO;
import com.example.demo.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin("*")
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

    @PutMapping(value = "/{id}")
    public ResponseEntity<Livro> update( @PathVariable Integer id, @Valid @RequestBody Livro obj) {
        Livro newObj = livroService.update(id, obj);
        return ResponseEntity.ok().body(newObj);

    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Livro> updatePatch ( @PathVariable Integer id, @Valid @RequestBody Livro obj) {
        Livro newObj = livroService.update(id, obj);
        return ResponseEntity.ok().body(newObj);

        }
    @PostMapping
    public ResponseEntity<Livro> create( @RequestParam(value = "categoria", defaultValue = "0") Integer id_categoria, @Valid @RequestBody Livro obj) {
        Livro newObj = livroService.create(id_categoria, obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/livros/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete (@PathVariable Integer id) {
        livroService.delete(id);
        return ResponseEntity.noContent().build();

    }


}
