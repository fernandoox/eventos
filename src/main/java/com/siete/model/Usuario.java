package com.siete.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "USUARIO")
@SequenceGenerator(name = "ID_USUARIO_SEQ", sequenceName = "USUARIO_ID_SEQ")
public class Usuario implements Serializable {

	private static final long serialVersionUID = -5171949361986724606L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_USUARIO_SEQ")
	@Column(name = "ID", unique = true, nullable = false)
	private Integer id;

	@Column(name = "USUARIO", length = 200)
	private String usuario;

	@Column(name = "CLAVE", length = 16)
	private String clave;

	@Column(name = "NOMBRE", length = 150)
	private String nombre;

	@Column(name = "SEXO", length = 1)
	private char sexo;

	@Column(name = "EDAD")
	private short edad;

	@Column(name = "TELEFONO", length = 10)
	private String telefono;

	@ManyToMany
	@JoinTable(name = "EVENTOS_GUARDADOS", joinColumns = @JoinColumn(name = "ID_USUARIO"), inverseJoinColumns = @JoinColumn(name = "ID_EVENTO"))
	private List<Evento> eventosGuardados;

	@OneToMany(mappedBy = "autor", cascade = CascadeType.REMOVE)
	private List<ComentarioEvento> comentarios;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public short getEdad() {
		return edad;
	}

	public void setEdad(short edad) {
		this.edad = edad;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Evento> getEventosGuardados() {
		return eventosGuardados;
	}

	public void setEventosGuardados(List<Evento> eventosGuardados) {
		this.eventosGuardados = eventosGuardados;
	}

	public List<ComentarioEvento> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<ComentarioEvento> comentarios) {
		this.comentarios = comentarios;
	}
	
}
