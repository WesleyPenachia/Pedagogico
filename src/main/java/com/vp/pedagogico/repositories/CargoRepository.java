package com.vp.pedagogico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vp.pedagogico.domain.Cargo;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Integer> {

}
