package com.vp.pedagogico.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vp.pedagogico.domain.Cargo;
import com.vp.pedagogico.services.CargoService;

@RestController
@RequestMapping(value = "/cargos")
public class CargoResource {
	
	@Autowired
	private CargoService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		
		Cargo obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);		
	}
}
