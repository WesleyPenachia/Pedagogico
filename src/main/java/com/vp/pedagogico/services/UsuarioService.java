package com.vp.pedagogico.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vp.pedagogico.domain.Usuario;
import com.vp.pedagogico.repositories.UsuarioRepository;
import com.vp.pedagogico.services.exceptions.ObjectNotFoundException;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repo;
	
	public Usuario buscar(Integer id) {
		Optional<Usuario> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Usuario.class.getName()));
	}
}
