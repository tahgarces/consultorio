package com.example.consultorio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.consultorio.domain.Paciente;


@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer> {

}
