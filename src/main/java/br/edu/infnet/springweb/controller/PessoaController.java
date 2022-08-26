package br.edu.infnet.springweb.controller;

import br.edu.infnet.springweb.entity.Pessoa;
import br.edu.infnet.springweb.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/pessoas")
public class PessoaController {

    @Autowired
    private PessoaRepository repository;

    @GetMapping
    public Iterable<Pessoa> list(){
        return repository.findAll();
    }

    @PostMapping
    public Pessoa cadastrarPessoa(@RequestBody Pessoa pessoa) {
        return repository.save(pessoa);

    }

}

