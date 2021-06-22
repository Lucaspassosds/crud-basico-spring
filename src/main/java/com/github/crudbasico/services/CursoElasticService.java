package com.github.crudbasico.services;


import java.util.List;

import com.github.crudbasico.models.Curso;
import com.github.crudbasico.repository.ElasticCursoRepository;

import org.springframework.stereotype.Service;

@Service
public class CursoElasticService {
    
    private ElasticCursoRepository cursoRepository;

    public void createCursoIndexBulk(final List<Curso> cursos){
        cursoRepository.saveAll(cursos);
    }

    public void createCursoIndex(final Curso curso){
        cursoRepository.save(curso);
    }

}
