package com.example.consultorio.services;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.consultorio.domain.Paciente;
import com.example.consultorio.repositories.PacienteRepository;

@Service
public class PacienteService {
	
	private PacienteRepository pacienteRepository;
	
	@Transactional
	public Paciente update(Paciente paciente, Integer id) {
		Optional<Paciente> saved = Optional.ofNullable(pacienteRepository.findOne(id));
		if(!saved.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		
		BeanUtils.copyProperties(paciente, saved.get(), "id");
		return pacienteRepository.save(saved.get());
	}
}
