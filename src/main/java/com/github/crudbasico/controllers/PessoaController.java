package com.github.crudbasico.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
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
import com.github.crudbasico.helpers.ApiError;

@CrossOrigin
@RestController
@RequestMapping(value="/api")
public class PessoaController {

	@Autowired
	PessoaRepository pessoaRepository;
	
	@GetMapping("/pessoas")
	public Iterable<Pessoa> listaPessoas(){
		return pessoaRepository.findAll();
	}
	

	@GetMapping("/pessoa/{id}")
	public Optional<Pessoa> listaPessoaUnica(@PathVariable(value="id") long id){
		return pessoaRepository.findById(id);
	}
	
	@PostMapping("/pessoa")
	public ResponseEntity<Object> salvaPessoa(@RequestBody Pessoa pessoa) {
		if(pessoaRepository.existsByCpf(pessoa.getCpf())) {
			var ex = new Throwable("Ocorreu um erro na requisicao!");
			var error = new ApiError(HttpStatus.BAD_REQUEST, "CPF ja cadastrado!", ex);
			return new ResponseEntity<Object>(error, error.getStatus());
		}
		if(pessoaRepository.existsByTelefone(pessoa.getTelefone())) {
			var ex = new Throwable("Ocorreu um erro na requisicao!");
			var error = new ApiError(HttpStatus.BAD_REQUEST, "Telefone ja cadastrado!", ex);
			return new ResponseEntity<Object>(error, error.getStatus());
		}
		return new ResponseEntity<Object>(pessoaRepository.save(pessoa), HttpStatus.ACCEPTED);
	}
	
	
	@DeleteMapping("/pessoa/{id}")
	public void deletaPessoa(@PathVariable Long id) {
		pessoaRepository.deleteById(id);
	}
	

	@PutMapping("/pessoa")
	public Pessoa atualizaPessoa(@RequestBody Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}
	
}
