package com.github.crudbasico.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.elasticsearch.search.aggregations.metrics.InternalHDRPercentileRanks.Iter;
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
import com.github.crudbasico.repository.ElasticCursoRepository;
import com.github.crudbasico.services.CursoElasticService;

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

	@GetMapping("/curso/import")
	public String importToElastic(){
		Iterable<Curso> cursoIterable = cursoRepository.findAll();
		List<Curso> cursos = new ArrayList<>();
		cursoIterable.forEach(cursos::add);
		CursoElasticService elasticService = new CursoElasticService();
		try{
			elasticService.createCursoIndexBulk(cursos);
			return "Importacao concluida com sucesso!";
		} catch(Exception e){
			e.printStackTrace();
			return "Erro! Falha na importacao";
		}
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