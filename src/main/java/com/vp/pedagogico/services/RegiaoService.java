package com.vp.pedagogico.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vp.pedagogico.domain.Regiao;
import com.vp.pedagogico.domain.Usuario;
import com.vp.pedagogico.repositories.RegiaoRepository;
import com.vp.pedagogico.services.exceptions.ObjectNotFoundException;

@Service
public class RegiaoService {

	@Autowired
	private RegiaoRepository repo;
	
	public Regiao buscar(Integer id) {
		Optional<Regiao> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Usuario.class.getName()));
	}
}
