package br.edu.infnet.springweb.controller;

import br.edu.infnet.springweb.entity.Pessoa;
import br.edu.infnet.springweb.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/pessoas")
public class PessoaController {

    @Autowired
    private PessoaRepository repository;

    @GetMapping
    //public Iterable<Pessoa> list()
    public List<Pessoa> list(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> listId(@PathVariable(value = "id") Long id) {
        Optional<Pessoa> pessoa = repository.findById(id);
        if (pessoa.isPresent()) {
            return new ResponseEntity<Pessoa>(pessoa.get(), HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PostMapping
    public Pessoa cadastrarPessoa(@RequestBody Pessoa pessoa) {
        return repository.save(pessoa);

    }

//    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE )
//    public ResponseEntity<Object> Delete(@PathVariable(value = "id") Long id) {
//        Optional<Pessoa> pessoa = repository.findById(id);
//        if(pessoa.isPresent()) {
//            repository.delete(pessoa.get());
//            return new ResponseEntity<>(HttpStatus.OK);
//        }
//        else
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
    @DeleteMapping("deletar/{id}")
    public ResponseEntity<Long> deletePessoa(@PathVariable(value = "id") Long id) {
        //return ResponseEntity.ok(id);
        Optional<Pessoa> pessoa = repository.findById(id);
        if(pessoa.isPresent()) {
            repository.delete(pessoa.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("deletar/{id}/{nome}")
    public ResponseEntity<?> deletePessoaByName(@PathVariable(value = "id") Long id, @PathVariable(value = "nome") String nome) {
        return ResponseEntity.ok(id);
//        Optional<Pessoa> pessoa = repository.findById(id);
//        if (pessoa.isPresent()) {
//            repository.delete();
//            return new ResponseEntity<>(HttpStatus.OK);
//        } else
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @PutMapping("/atualiza/{id}")
        public ResponseEntity<Pessoa> atualizaPessoa(@PathVariable(value = "id") Long id, @RequestBody Pessoa novaPessoa){
        Optional<Pessoa> velhaPessoa = repository.findById(id);
        if(velhaPessoa.isPresent()) {
            Pessoa pessoa = velhaPessoa.get();
            pessoa.setNome(novaPessoa.getNome());
            repository.save(pessoa);
            return new ResponseEntity<Pessoa>(pessoa, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}

