package com.example.consultorio.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.consultorio.domain.Consulta;
import com.example.consultorio.services.ConsultaService;

@RestController
@RequestMapping(value="/consultas")
public class ConsultaResource {
	
	@Autowired
	private ConsultaService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id){
		Consulta obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
