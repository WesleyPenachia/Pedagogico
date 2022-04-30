package com.vp.pedagogico.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vp.pedagogico.domain.Cargo;
import com.vp.pedagogico.domain.Usuario;
import com.vp.pedagogico.repositories.CargoRepository;
import com.vp.pedagogico.services.exceptions.ObjectNotFoundException;

@Service
public class CargoService {

	@Autowired
	private CargoRepository repo;
	
	public Cargo buscar(Integer id) {
		Optional<Cargo> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Usuario.class.getName()));
	}
}
