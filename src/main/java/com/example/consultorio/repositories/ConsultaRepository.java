package com.example.consultorio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.consultorio.domain.Consulta;


@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Integer> {

}
