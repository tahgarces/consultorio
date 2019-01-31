package com.example.consultorio.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/pacientes")

public class PacienteResource {
	
	@RequestMapping(method=RequestMethod.GET)
	public String listar() {
		return "rest ok";
	}
}
