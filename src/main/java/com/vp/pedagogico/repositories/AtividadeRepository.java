package com.vp.pedagogico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vp.pedagogico.domain.Atividade;

@Repository
public interface AtividadeRepository extends JpaRepository<Atividade, Integer> {

}
