package com.siete.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.siete.model.Organizador;

@Repository
public interface IOrganizadorRepo extends JpaRepository<Organizador, Integer>{

}
