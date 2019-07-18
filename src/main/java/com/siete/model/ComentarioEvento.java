package com.siete.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class ComentarioEvento implements Serializable{

	private static final long serialVersionUID = 2544315744662848754L;
	
	private Integer id;
	private String texto;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_EVENTO")
	private Evento evento;
	
	private Usuario autor;
	
}
