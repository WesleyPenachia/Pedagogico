package com.vp.pedagogico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vp.pedagogico.domain.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Integer> {

}
