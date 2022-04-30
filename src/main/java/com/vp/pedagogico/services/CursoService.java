package com.vp.pedagogico.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vp.pedagogico.domain.Curso;
import com.vp.pedagogico.domain.Usuario;
import com.vp.pedagogico.repositories.CursoRepository;
import com.vp.pedagogico.services.exceptions.ObjectNotFoundException;

@Service
public class CursoService {

	@Autowired
	private CursoRepository repo;
	
	public Curso buscar(Integer id) {
		Optional<Curso> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Usuario.class.getName()));
	}
}
