package com.github.crudbasico.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.crudbasico.models.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
	Pessoa findById(long id);
}
