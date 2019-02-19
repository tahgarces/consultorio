package com.example.consultorio.services;


import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.consultorio.domain.Medico;
import com.example.consultorio.repositories.MedicoRepository;

@Service
public class MedicoService {
	MedicoRepository medicoRepository;

	public MedicoService(MedicoRepository medicoRepository){
		this.medicoRepository = medicoRepository;
	}

	@Transactional
	public Medico update(Medico medico, Integer id) {

		Optional<Medico> saved = Optional.ofNullable(medicoRepository.findOne(id));
		if (!saved.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}

		BeanUtils.copyProperties(medico, saved.get(), "id");
		return medicoRepository.save(saved.get());

	}
}