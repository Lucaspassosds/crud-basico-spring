package com.github.crudbasico.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.github.crudbasico.models.Pessoa;

public interface PessoaRepository extends CrudRepository<Pessoa, Long> {
	
	boolean existsByCpf(String cpf);
	boolean existsByTelefone(String telefone);
}
