package com.example.consultorio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.consultorio.domain.Medico;


@Repository
public interface MedicoRepository extends JpaRepository<Medico, Integer> {

}
