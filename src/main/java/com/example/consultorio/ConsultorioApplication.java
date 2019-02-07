package com.example.consultorio;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.consultorio.domain.Paciente;
import com.example.consultorio.repositories.PacienteRepository;

@SpringBootApplication
public class ConsultorioApplication implements CommandLineRunner{
	
	@Autowired
	private PacienteRepository pacienteRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ConsultorioApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Paciente paciente1 = new Paciente(null,"Maria José Santos da Silva", "Joana Maria Catarina Dias","Rua das Catarinas, 123", "98988229911", "F");
		Paciente paciente2 = new Paciente(null,"Erick Augusto Santos da Silva", "Joana Maria Catarina Dias","Rua das Catarinas, 123", "98988229911", "M");
	
		
		pacienteRepository.save(Arrays.asList(paciente1, paciente2));
	
	}
	

}

