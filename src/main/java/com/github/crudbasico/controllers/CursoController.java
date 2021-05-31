package com.github.crudbasico.controllers;

import java.util.List;

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
	public List<Curso> listaCursos(){
		return cursoRepository.findAll();
	}
	

	@GetMapping("/curso/{id}")
	public Curso listaCursoUnico(@PathVariable(value="id") long id){
		return cursoRepository.findById(id);
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