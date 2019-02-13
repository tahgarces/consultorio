package com.example.consultorio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.consultorio.domain.Medico;
import com.example.consultorio.repositories.MedicoRepository;

@Service
public class MedicoService {
	@Autowired
	private MedicoRepository repo;
	
	public Medico buscar (Integer id) {
		Medico obj = repo.findOne(id);
		return obj;
	}
}
