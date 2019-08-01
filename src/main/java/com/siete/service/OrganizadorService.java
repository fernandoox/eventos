package com.siete.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siete.model.Organizador;
import com.siete.repository.IOrganizadorRepo;

@Service
public class OrganizadorService {
	
	@Autowired
	private IOrganizadorRepo organizadorRepo;
	
	/**
	 * 
	 * @return as
	 */
	public List<Organizador> getAllOrganizadores(){
		return organizadorRepo.findAll();
	}
	
	public Optional<Organizador> getOrganizadoyById(Integer id) {
		return organizadorRepo.findById(id);
	}
	
	public Organizador saveOrganizador(Organizador organizador) {
		return organizadorRepo.save(organizador);
	}
}
