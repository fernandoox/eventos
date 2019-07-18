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
@Table(name = "CAT_ESTADO_EVENTO")
@SequenceGenerator(name = "ID_ESTADO_EVENTO_SEQ", sequenceName = "ESTADO_EVENTO_ID_SEQ")
public class EstadoEvento implements Serializable{

	private static final long serialVersionUID = 6536212167674471011L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_ESTADO_EVENTO_SEQ")
	@Column(name = "ID", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "NOMBRE", length = 30)
	private String nombre;
	
	@Column(name = "ACTIVO", length = 1)
	private boolean activo;
	
	@OneToOne(mappedBy = "estado")
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
