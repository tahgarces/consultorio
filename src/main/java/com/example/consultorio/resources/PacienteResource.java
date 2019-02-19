package com.example.consultorio.resources;




import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.consultorio.domain.Paciente;
import com.example.consultorio.exception.ConsultorioNotFoundException;
import com.example.consultorio.repositories.PacienteRepository;
import com.example.consultorio.services.PacienteService;

@RestController
@RequestMapping(value="/pacientes")
public class PacienteResource {
	
	
	@Autowired
	private PacienteService pacienteService;
	
	@Autowired
	private PacienteRepository pacienteRepository;
	
	@GetMapping
    public List<Paciente> listarTodos() {
        return pacienteRepository.findAll();
    }

    @GetMapping(path = "{id}")
    public Paciente buscarPeloCodigo(@PathVariable Integer id) {
        Optional<Paciente> paciente = Optional.ofNullable(pacienteRepository.findOne(id));

        if (!paciente.isPresent())
            throw new IllegalArgumentException("Não há registro no banco");
        return paciente.get();
    }
	
    @PostMapping 
    public ResponseEntity<Paciente> criar(@RequestBody Paciente paciente, HttpServletResponse httpServletResponse){
    	Paciente pacientesalvar = pacienteRepository.save(paciente);
    	
    	URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/id")
                .buildAndExpand(pacientesalvar.getId()).toUri();
    	
    	httpServletResponse.setHeader("location",uri.toASCIIString());
    	
    	return ResponseEntity.created(uri).body(pacientesalvar);
    }
    
    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable Integer id) {
    	Paciente paciente = pacienteRepository.findOne(id);
    	
    	if(paciente == null) {
    		throw new ConsultorioNotFoundException("Este id não existe");
    	}
    	
    	pacienteRepository.delete(id);
    }
    
    @PutMapping(path = ("{id}"))
    public ResponseEntity<Object> atualizarPaciente(@RequestBody Paciente paciente, @PathVariable Integer id){
    	
    	return ResponseEntity.ok(pacienteService.update(paciente, id));
    }
    
	
}
