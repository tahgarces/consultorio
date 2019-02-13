package com.example.consultorio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.consultorio.domain.Consulta;
import com.example.consultorio.repositories.ConsultaRepository;

@Service
public class ConsultaService {
	
	@Autowired
	private ConsultaRepository repo;
	
	public Consulta buscar (Integer id) {
		Consulta obj = repo.findOne(id);
		return obj;
	}
}
