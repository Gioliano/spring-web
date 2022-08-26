package br.edu.infnet.springweb.repository;

import br.edu.infnet.springweb.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
