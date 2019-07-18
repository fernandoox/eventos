package com.siete.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "EVENTO")
@SequenceGenerator(name = "ID_EVENTO_SEQ", sequenceName = "EVENTO_ID_SEQ" )
public class Evento implements Serializable{
	
	private static final long serialVersionUID = -5970972288892808535L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_EVENTO_SEQ")
	@Column(name = "ID", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "NOMBRE", length = 120)
	private String nombre;
	
	@Column(name = "DESCRIPCION", length = 500)
	private String descripcion;
	
	@Column(name = "FECHA_INICIAL")
	private Date fechaInicial;
	
	@Column(name = "FECHA_FINAL")
	private Date fechaFinal;
	
	@Column(name = "PRECIO")
	private Integer precio;
	
	@Column(name = "ASISTENTES")
	private Integer asistentes;
	
	@Column(name = "INTERESADOS")
	private Integer interesados;
	
	@OneToOne(cascade = CascadeType.ALL)
	// @JoinColumn - Owner de la relacion
	@JoinColumn(name = "ID_DIRECCION", referencedColumnName = "ID")
	private Direccion direccion;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_CATEGORIA", referencedColumnName = "ID")
	private CategoriaEvento categoria;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_ESTADO", referencedColumnName = "ID")
	private EstadoEvento estado;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_ORGANIZADOR", referencedColumnName = "ID")
	private Organizador organizador;
	
	@OneToMany(mappedBy = "evento",  cascade = CascadeType.ALL) //orphanRemoval = true?
	private List<ComentarioEvento> comentarios;
	
	
	@ManyToMany(mappedBy = "eventosGuardados") //?
	private List<Usuario> usuariosInteresados;
	
	/*
	 * 
		 
		public void addComment(PostComment comment) {
	        comments.add(comment);
	        comment.setPost(this);
	    }
	 
	    public void removeComment(PostComment comment) {
	        comments.remove(comment);
	        comment.setPost(null);
	    }
	 */

}
