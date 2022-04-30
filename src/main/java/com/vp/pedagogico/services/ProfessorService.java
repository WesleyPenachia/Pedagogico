package com.vp.pedagogico.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vp.pedagogico.domain.Professor;
import com.vp.pedagogico.domain.Usuario;
import com.vp.pedagogico.repositories.ProfessorRepository;
import com.vp.pedagogico.services.exceptions.ObjectNotFoundException;

@Service
public class ProfessorService {

	@Autowired
	private ProfessorRepository repo;
	
	public Professor buscar(Integer id) {
		Optional<Professor> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Usuario.class.getName()));
	}
}
