package com.vp.pedagogico.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vp.pedagogico.domain.Funcionario;
import com.vp.pedagogico.domain.Usuario;
import com.vp.pedagogico.repositories.FuncionarioRepository;
import com.vp.pedagogico.services.exceptions.ObjectNotFoundException;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository repo;
	
	public Funcionario buscar(Integer id) {
		Optional<Funcionario> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Usuario.class.getName()));
	}
}
