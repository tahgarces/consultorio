package com.example.consultorio.resources;

import com.example.consultorio.exception.ConsultorioNotFoundException;
import com.example.consultorio.repositories.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.consultorio.domain.Medico;
import com.example.consultorio.services.MedicoService;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/medicos")
public class MedicoResource {

    @Autowired
    private MedicoService medicoService;

    @Autowired
    private MedicoRepository medicoRepository;

    @GetMapping
    public List<Medico> listarTodos() {
        return medicoRepository.findAll();
    }

    @GetMapping(path = "{id}")
    public Medico buscarPeloCodigo(@PathVariable Integer id) {
        Optional<Medico> medico = Optional.ofNullable(medicoRepository.findOne(id));

        if (!medico.isPresent())
            throw new IllegalArgumentException("Não há registro no banco");
        return medico.get();
    }

    @PostMapping
    public ResponseEntity<Medico> criar(@RequestBody Medico medico, HttpServletResponse httpServletResponse){
        Medico medicosalvar = medicoRepository.save(medico);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/id")
                .buildAndExpand(medicosalvar.getId()).toUri();

        httpServletResponse.setHeader("location", uri.toASCIIString());

        return ResponseEntity.created(uri).body(medicosalvar);
    }

    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable Integer id){
        Medico medico = medicoRepository.findOne(id);

        if(medico == null)
            throw new ConsultorioNotFoundException("Este id não existe");

        medicoRepository.delete(id);
    }

    @PutMapping(path = ("{id}"))
    public ResponseEntity<Object> atualizarMedico(@RequestBody Medico medico, @PathVariable Integer id){
        return ResponseEntity.ok(medicoService.update(medico, id));
    }
}

