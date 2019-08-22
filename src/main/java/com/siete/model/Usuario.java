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

	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "EVENTOS_GUARDADOS", joinColumns = @JoinColumn(name = "ID_USUARIO"), inverseJoinColumns = @JoinColumn(name = "ID_EVENTO"))
	private List<Evento> eventosGuardados;

	@OneToMany(mappedBy = "autor", cascade = CascadeType.REMOVE)
	private List<ComentarioEvento> comentarios;
	
	public void addComment(ComentarioEvento comentario) {
		comentarios.add(comentario);
		comentario.setAutor(this);
	}

	public void removeComment(ComentarioEvento comentario) {
		comentarios.remove(comentario);
		comentario.setAutor(null);
	}
}
