package com.github.crudbasico.repository;

import java.util.List;

import com.github.crudbasico.models.Curso;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ElasticCursoRepository extends ElasticsearchRepository<Curso, String> {

    List<Curso> findByName(String name);
  
    List<Curso> findByNameContaining(String name);
    
}
