package com.example.consultorio.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.consultorio.domain.Paciente;
import com.example.consultorio.services.PacienteService;

@RestController
@RequestMapping(value="/pacientes")

public class PacienteResource {
	
	
	@Autowired
	private PacienteService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		
		Paciente obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
		
	}
	
	
}
