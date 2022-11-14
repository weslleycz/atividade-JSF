
package com.br.atividade.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.br.atividade.model.Dependente;
import com.br.atividade.model.Pessoa;
import com.br.atividade.repository.IPessoaRepository;

import lombok.Getter;
import lombok.Setter;

/**
 * SelectAddBean
 */
@Getter
@Setter
@RequestScoped
@ManagedBean
@Component
public class SelectAddBean {

    @Autowired
    private IPessoaRepository repository;

    private String nome;
    private String cpf;

    private List<Dependente> dependentes = new ArrayList<Dependente>();

    public void selectPessoa(Long id) throws IOException {
        Optional<Pessoa> pessoa = repository.findById(id);
        if (pessoa.isPresent()) {
            this.nome = pessoa.get().getNome();
            this.cpf = pessoa.get().getCpf();
            //this.dependentes = pessoa.get().getDependente();
            FacesContext.getCurrentInstance().getExternalContext().redirect("/edit");
        }
    }

}