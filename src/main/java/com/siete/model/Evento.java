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

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
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

	public void addComentario(ComentarioEvento comentario) {
		comentarios.add(comentario);
		comentario.setEvento(this);
	}

	public void removeComentario(ComentarioEvento comentario) {
		comentarios.remove(comentario);
		comentario.setEvento(null);
	}
}
