package com.vp.pedagogico.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vp.pedagogico.domain.Regiao;
import com.vp.pedagogico.services.RegiaoService;

@RestController
@RequestMapping(value = "/regioes")
public class RegiaoResource {
	
	@Autowired
	private RegiaoService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		
		Regiao obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);		
	}
}
