package com.siete.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siete.model.Organizador;
import com.siete.repository.IOrganizadorRepo;

@RestController
@RequestMapping("organizadores")
public class OrganizadorController {

	private static final Logger LOG = LoggerFactory.getLogger(OrganizadorController.class);

	@Autowired
	private IOrganizadorRepo organizadorRepo;

	@GetMapping
	public List<Organizador> getAllOrganizadores() {
		return organizadorRepo.findAll();
	}
	
	@GetMapping("/{id}") 
	public ResponseEntity<Organizador> getOrganizadorById(@PathVariable Integer id) {
		Optional<Organizador> organizador = organizadorRepo.findById(id);
		if (!organizador.isPresent()) {
			throw new ApiRequestException("No encontrados yeah");
		}
		return new ResponseEntity<Organizador>(organizador.get(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<?> crearOrganizador(@RequestBody Organizador organizador) {
		Organizador organizadorGuardado = organizadorRepo.save(organizador);
		LOG.info("Organizador a guardar: " + organizadorGuardado.getNombre());
		return new ResponseEntity<>(organizadorGuardado, HttpStatus.OK);
	}

}
