package com.github.crudbasico.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.crudbasico.models.Curso;
import com.github.crudbasico.repository.CursoRepository;

@CrossOrigin
@RestController
@RequestMapping(value="/api")
public class CursoController {

	@Autowired
	CursoRepository cursoRepository;
	
	@GetMapping("/cursos")
	public Iterable<Curso> listaCursos(){
		return cursoRepository.findAll();
	}
	

	@GetMapping("/curso/{id}")
	public Optional<Curso> listaCursoUnico(@PathVariable(value="id") long id){
		return cursoRepository.findById(id);
	}

	@GetMapping("/curso/qtd-alunos/{id}")
	public Integer getQuantidadeAlunos(@PathVariable(value="id") long id){
		Curso curso = cursoRepository.findById(id).get();
		return curso.getPessoas().size();
	}
	
	@PostMapping("/curso")
	public Curso salvaCurso(@RequestBody Curso curso) {
		return cursoRepository.save(curso);
	}
	
	
	@DeleteMapping("/curso/{id}")
	public void deletaCurso(@PathVariable Long id) {
		cursoRepository.deleteById(id);
	}
	

	@PutMapping("/curso")
	public Curso atualizaCurso(@RequestBody Curso curso) {
		return cursoRepository.save(curso);
	}
	
}