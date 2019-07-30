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

	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "EVENTOS_GUARDADOS", joinColumns = @JoinColumn(name = "ID_USUARIO"), inverseJoinColumns = @JoinColumn(name = "ID_EVENTO"))
	private List<Evento> eventosGuardados;

	@OneToMany(mappedBy = "autor", cascade = CascadeType.REMOVE)
	private List<ComentarioEvento> comentarios;
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	public Usuario(String usuario, String clave, String nombre, char sexo, short edad, String telefono,
			List<Evento> eventosGuardados, List<ComentarioEvento> comentarios) {
		this.usuario = usuario;
		this.clave = clave;
		this.nombre = nombre;
		this.sexo = sexo;
		this.edad = edad;
		this.telefono = telefono;
		this.eventosGuardados = eventosGuardados;
		this.comentarios = comentarios;
	}

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
	
	public void addComment(ComentarioEvento comentario) {
		comentarios.add(comentario);
		comentario.setAutor(this);
	}

	public void removeComment(ComentarioEvento comentario) {
		comentarios.remove(comentario);
		comentario.setAutor(null);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clave == null) ? 0 : clave.hashCode());
		result = prime * result + ((comentarios == null) ? 0 : comentarios.hashCode());
		result = prime * result + edad;
		result = prime * result + ((eventosGuardados == null) ? 0 : eventosGuardados.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + sexo;
		result = prime * result + ((telefono == null) ? 0 : telefono.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (clave == null) {
			if (other.clave != null)
				return false;
		} else if (!clave.equals(other.clave))
			return false;
		if (comentarios == null) {
			if (other.comentarios != null)
				return false;
		} else if (!comentarios.equals(other.comentarios))
			return false;
		if (edad != other.edad)
			return false;
		if (eventosGuardados == null) {
			if (other.eventosGuardados != null)
				return false;
		} else if (!eventosGuardados.equals(other.eventosGuardados))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (sexo != other.sexo)
			return false;
		if (telefono == null) {
			if (other.telefono != null)
				return false;
		} else if (!telefono.equals(other.telefono))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", usuario=" + usuario + ", clave=" + clave + ", nombre=" + nombre + ", sexo="
				+ sexo + ", edad=" + edad + ", telefono=" + telefono + ", eventosGuardados=" + eventosGuardados
				+ ", comentarios=" + comentarios + "]";
	}
	
}
