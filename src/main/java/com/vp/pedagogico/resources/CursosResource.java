package com.vp.pedagogico.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vp.pedagogico.domain.Curso;
import com.vp.pedagogico.services.CursoService;

@RestController
@RequestMapping(value = "/cursos")
public class CursosResource {
	
	@Autowired	
	private CursoService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		
		Curso obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);		
	}
}
