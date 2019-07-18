package com.siete.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "CAT_CATEGORIA_EVENTO")
@SequenceGenerator(name = "ID_CATEGORIA_EVENTO_SEQ", sequenceName = "CATEGORIA_EVENTO_ID_SEQ")
public class CategoriaEvento implements Serializable{

	private static final long serialVersionUID = 4759332988483278196L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_CATEGORIA_EVENTO_SEQ")
	@Column(name = "ID", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "NOMBRE", length = 30)
	private String nombre;
	
	@Column(name = "ACTIVO", length = 1)
	private boolean activo;
	
	@OneToOne(mappedBy = "categoria")
	private Evento evento;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	} 
	public Evento getEvento() {
		return evento;
	}
	public void setEvento(Evento evento) {
		this.evento = evento;
	}
}
