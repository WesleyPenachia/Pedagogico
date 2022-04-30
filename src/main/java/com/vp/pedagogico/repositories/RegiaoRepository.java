package com.vp.pedagogico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vp.pedagogico.domain.Regiao;

@Repository
public interface RegiaoRepository extends JpaRepository<Regiao, Integer> {

}
