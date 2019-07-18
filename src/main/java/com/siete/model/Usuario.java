package com.siete.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

public class Usuario implements Serializable{

	private static final long serialVersionUID = -5171949361986724606L;
	
	private Integer id;
	private String usuario;
	private String clave;
	private String nombre;
	private char sexo;
	private short edad;
	private String telefono;
	private BigDecimal latitud;
	private BigDecimal longitud;
	
	@ManyToMany
	private List<Evento> eventosGuardados;
}
