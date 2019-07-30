package com.siete.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;

@Entity
@Table(name = "ORGANIZADOR")
@SequenceGenerator(name = "ID_ORGANIZADOR_SEQ", sequenceName = "ORGANIZADOR_ID_SEQ")
public class Organizador implements Serializable{
	
	private static final long serialVersionUID = 7837744338850843914L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_ORGANIZADOR_SEQ")
	@Column(name = "ID", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "NOMBRE", length = 80)
	private String nombre;
	
	@Column(name = "ACTIVO", length = 1)
	private boolean activo;
	
	@Column(name = "TELEFONO", length = 10)
	private String telefono;
	
	@Email
	@Column(name = "CORREO", length = 80)
	private String correo;
	
	@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
	private List<Evento> eventos;
	
	public Organizador() {
		// TODO Auto-generated constructor stub
	}
	
	public Organizador(String nombre, boolean activo, String telefono, @Email String correo, List<Evento> eventos) {
		this.nombre = nombre;
		this.activo = activo;
		this.telefono = telefono;
		this.correo = correo;
		this.eventos = eventos;
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
	
	public boolean isActivo() {
		return activo;
	}
	
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public String getCorreo() {
		return correo;
	}
	
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	public List<Evento> getEventos() {
		return eventos;
	}
	
	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}
	
	public void addEvento(Evento evento) {
		eventos.add(evento);
		evento.setOrganizador(this);
	}
	
	public void removeEvento(Evento evento) {
		eventos.remove(evento);
		evento.setOrganizador(null);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (activo ? 1231 : 1237);
		result = prime * result + ((correo == null) ? 0 : correo.hashCode());
		result = prime * result + ((eventos == null) ? 0 : eventos.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((telefono == null) ? 0 : telefono.hashCode());
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
		Organizador other = (Organizador) obj;
		if (activo != other.activo)
			return false;
		if (correo == null) {
			if (other.correo != null)
				return false;
		} else if (!correo.equals(other.correo))
			return false;
		if (eventos == null) {
			if (other.eventos != null)
				return false;
		} else if (!eventos.equals(other.eventos))
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
		if (telefono == null) {
			if (other.telefono != null)
				return false;
		} else if (!telefono.equals(other.telefono))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Organizador [id=" + id + ", nombre=" + nombre + ", activo=" + activo + ", telefono=" + telefono
				+ ", correo=" + correo + ", eventos=" + eventos + "]";
	}
	
}
