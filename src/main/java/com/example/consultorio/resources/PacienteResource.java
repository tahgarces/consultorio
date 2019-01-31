package com.example.consultorio.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.consultorio.domain.Paciente;

@RestController
@RequestMapping(value="/pacientes")

public class PacienteResource {
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Paciente> listar() {
		
		
		Paciente paciente1 = new Paciente(1, "Taynara Garces", "Gracilene da Silva", "rua das margaridas", "98984018000", "F");
		Paciente paciente2 = new Paciente(2, "Maria Garces", "Joana da Silva", "rua das margaridas", "98984018000", "F");
		
		List<Paciente> lista = new ArrayList();
		lista.add(paciente1);
		lista.add(paciente2);
		
		return lista;
	}
	
	
}
