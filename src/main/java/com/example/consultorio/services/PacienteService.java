package com.example.consultorio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.consultorio.domain.Paciente;
import com.example.consultorio.repositories.PacienteRepository;

@Service
public class PacienteService {
	
	@Autowired
	private PacienteRepository repo;
	
	public Paciente buscar (Integer id) {
		Paciente obj = repo.findOne(id);
		return obj;
	}
}
