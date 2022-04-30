package com.vp.pedagogico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vp.pedagogico.domain.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer> {

}
