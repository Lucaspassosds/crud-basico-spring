package com.github.crudbasico.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.crudbasico.models.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {
	Curso findById(long id);
}
