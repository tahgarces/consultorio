package com.example.consultorio.services;


import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.consultorio.domain.Consulta;
import com.example.consultorio.repositories.ConsultaRepository;

@Service
public class ConsultaService {

	@Autowired
	private ConsultaRepository consultaRepository;
	
	@Transactional
	public Consulta update(Consulta consulta, Integer id) {
		Optional<Consulta> saved = Optional.ofNullable(consultaRepository.findOne(id));
		if(!saved.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		
		BeanUtils.copyProperties(consulta, saved.get(), "id");
		return consultaRepository.save(saved.get());
	}
}
