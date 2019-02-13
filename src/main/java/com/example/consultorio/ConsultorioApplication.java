package com.example.consultorio;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.consultorio.domain.Consulta;
import com.example.consultorio.domain.Medico;
import com.example.consultorio.domain.Paciente;
import com.example.consultorio.repositories.ConsultaRepository;
import com.example.consultorio.repositories.MedicoRepository;
import com.example.consultorio.repositories.PacienteRepository;

@SpringBootApplication
public class ConsultorioApplication implements CommandLineRunner{
	
	@Autowired
	private PacienteRepository pacienteRepository;
	@Autowired
	private MedicoRepository medicoRepository;
	@Autowired
	private ConsultaRepository consultaRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(ConsultorioApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Paciente paciente1 = new Paciente(null,"Maria José Santos da Silva", "Joana Maria Catarina Dias","Rua das Catarinas, 123", "98988229911", "F", "enxaqueca");
						
		Medico medico1 = new Medico(null, "José Dias da Costa", "CRM1234", "Pediatria", "jose@email.com");
				
		Consulta consulta1 = new Consulta(null, "teste", paciente1, medico1);
		
		paciente1.getConsulta().addAll(Arrays.asList(consulta1));
		medico1.getConsulta().addAll(Arrays.asList(consulta1));
		
		
		
		medicoRepository.save(Arrays.asList(medico1));
		pacienteRepository.save(Arrays.asList(paciente1));
		consultaRepository.save(Arrays.asList(consulta1));
		
	
	}
	

}

