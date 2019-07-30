package com.siete.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "EVENTO")
@SequenceGenerator(name = "ID_EVENTO_SEQ", sequenceName = "EVENTO_ID_SEQ")
public class Evento implements Serializable {

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

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true) // orphanRemoval: no puede haber una dirección que no pertenezca au un evento
	@JoinColumn(name = "ID_DIRECCION", referencedColumnName = "ID") // @JoinColumn indica que esta clase es owner
	private Direccion direccion;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CATEGORIA", referencedColumnName = "ID")
	private CategoriaEvento categoria;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_ESTADO", referencedColumnName = "ID")
	private EstadoEvento estado;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_ORGANIZADOR", referencedColumnName = "ID")
	private Organizador organizador;

	@OneToMany(mappedBy = "evento", cascade = CascadeType.ALL, orphanRemoval = true) // @OneToMany el fetch default es LAZY
	private List<ComentarioEvento> comentarios;

	//muchos a muchos cambia el cascade para no remover cosas no deseadas
	@ManyToMany(mappedBy = "eventosGuardados", cascade = {CascadeType.PERSIST, CascadeType.MERGE}) // @ManyToMany el fetch default es LAZY
	private List<Usuario> usuariosInteresados;

	
	public Evento() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Evento(String nombre, String descripcion, Date fechaInicial, Date fechaFinal, Integer precio,
			Integer asistentes, Integer interesados, Direccion direccion, CategoriaEvento categoria,
			EstadoEvento estado, Organizador organizador, List<ComentarioEvento> comentarios,
			List<Usuario> usuariosInteresados) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaInicial = fechaInicial;
		this.fechaFinal = fechaFinal;
		this.precio = precio;
		this.asistentes = asistentes;
		this.interesados = interesados;
		this.direccion = direccion;
		this.categoria = categoria;
		this.estado = estado;
		this.organizador = organizador;
		this.comentarios = comentarios;
		this.usuariosInteresados = usuariosInteresados;
	}

	
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


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Date getFechaInicial() {
		return fechaInicial;
	}


	public void setFechaInicial(Date fechaInicial) {
		this.fechaInicial = fechaInicial;
	}


	public Date getFechaFinal() {
		return fechaFinal;
	}


	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}


	public Integer getPrecio() {
		return precio;
	}


	public void setPrecio(Integer precio) {
		this.precio = precio;
	}


	public Integer getAsistentes() {
		return asistentes;
	}


	public void setAsistentes(Integer asistentes) {
		this.asistentes = asistentes;
	}


	public Integer getInteresados() {
		return interesados;
	}


	public void setInteresados(Integer interesados) {
		this.interesados = interesados;
	}


	public Direccion getDireccion() {
		return direccion;
	}


	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}


	public CategoriaEvento getCategoria() {
		return categoria;
	}


	public void setCategoria(CategoriaEvento categoria) {
		this.categoria = categoria;
	}


	public EstadoEvento getEstado() {
		return estado;
	}


	public void setEstado(EstadoEvento estado) {
		this.estado = estado;
	}


	public Organizador getOrganizador() {
		return organizador;
	}


	public void setOrganizador(Organizador organizador) {
		this.organizador = organizador;
	}


	public List<ComentarioEvento> getComentarios() {
		return comentarios;
	}


	public void setComentarios(List<ComentarioEvento> comentarios) {
		this.comentarios = comentarios;
	}


	public List<Usuario> getUsuariosInteresados() {
		return usuariosInteresados;
	}


	public void setUsuariosInteresados(List<Usuario> usuariosInteresados) {
		this.usuariosInteresados = usuariosInteresados;
	}


	public void addComentario(ComentarioEvento comentario) {
		comentarios.add(comentario);
		comentario.setEvento(this);
	}

	public void removeComentario(ComentarioEvento comentario) {
		comentarios.remove(comentario);
		comentario.setEvento(null);
	}

	@Override
	public String toString() {
		return "Evento [id=" + id + ", nombre=" + nombre + ", fechaInicial=" + fechaInicial + ", fechaFinal="
				+ fechaFinal + "]";
	}
	
}
