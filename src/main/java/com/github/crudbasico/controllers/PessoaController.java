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

import com.github.crudbasico.models.Pessoa;
import com.github.crudbasico.repository.PessoaRepository;

@CrossOrigin
@RestController
@RequestMapping(value="/api")
public class PessoaController {

	@Autowired
	PessoaRepository pessoaRepository;
	
	@GetMapping("/pessoas")
	public List<Pessoa> listaPessoas(){
		return pessoaRepository.findAll();
	}
	

	@GetMapping("/pessoa/{id}")
	public Pessoa listaCursoUnico(@PathVariable(value="id") long id){
		return pessoaRepository.findById(id);
	}
	
	@PostMapping("/pessoa")
	public Pessoa salvaCurso(@RequestBody Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}
	
	
	@DeleteMapping("/pessoa/{id}")
	public void deletaPerso(@PathVariable Long id) {
		pessoaRepository.deleteById(id);
	}
	

	@PutMapping("/pessoa")
	public Pessoa atualizaCurso(@RequestBody Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}
	
}
