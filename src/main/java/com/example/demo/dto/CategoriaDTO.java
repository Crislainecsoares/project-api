package com.example.demo.dto;

import com.example.demo.domain.Categoria;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class CategoriaDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotEmpty(message = "Campo nome é obrigatório")
    @Length(min = 3, max = 100 , message = "O Campo nome deve possuir entre 3 ou 100 caracteres")
    private String nome;

    @NotEmpty(message = "Campo descrição é obrigatório")
    @Length(min = 3, max = 200 , message = "O Campo descrição deve possuir entre 3 ou 100 caracteres")
    private String descricao;

    public CategoriaDTO() {
        super ();
    }

    public CategoriaDTO(Categoria obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.descricao = obj.getDescricao();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
