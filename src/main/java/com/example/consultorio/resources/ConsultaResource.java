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

import com.example.consultorio.domain.Consulta;
import com.example.consultorio.exception.ConsultorioNotFoundException;
import com.example.consultorio.repositories.ConsultaRepository;
import com.example.consultorio.services.ConsultaService;

@RestController
@RequestMapping(value="/consultas")
public class ConsultaResource {
	
	@Autowired
	private ConsultaService consultaService;
	
	@Autowired
	private ConsultaRepository consultaRepository;
	
	@GetMapping
	public List<Consulta> listarTodos(){
		return consultaRepository.findAll();
	}
	
	@GetMapping(path = "{id}")
	public Consulta buscarPeloCodigo(@PathVariable Integer id) {
		Optional<Consulta> consulta = Optional.ofNullable(consultaRepository.findOne(id));
		
		if(consulta.isPresent())
			throw new IllegalArgumentException("Não há registro no banco");
		return consulta.get();
	}
	
	@PostMapping
	public ResponseEntity<Consulta> criar(@RequestBody Consulta consulta, HttpServletResponse httpServletResponse ){
		Consulta consultasalvar = consultaRepository.save(consulta);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/id").buildAndExpand(consultasalvar.getId()).toUri();
	
		httpServletResponse.setHeader("location", uri.toASCIIString());
		
		return ResponseEntity.created(uri).body(consultasalvar);
	}
	
	@DeleteMapping(path = "{id}")
	public void delete(@PathVariable Integer id) {
		Consulta consulta = consultaRepository.findOne(id);
		
		if(consulta == null) {
			throw new ConsultorioNotFoundException("Este id não existe");
		}
		
		consultaRepository.delete(id);
	}
	
	@PutMapping(path = ("{id}"))
	public ResponseEntity<Object> atualizarConsulta(@RequestBody Consulta consulta, @PathVariable Integer id ){
		return ResponseEntity.ok(consultaService.update(consulta, id));
	}
	
}
