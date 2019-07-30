package com.siete.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	public CategoriaEvento() {
		// TODO Auto-generated constructor stub
	}
	
	public CategoriaEvento(String nombre, boolean activo) {
		this.nombre = nombre;
		this.activo = activo;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (activo ? 1231 : 1237);
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		CategoriaEvento other = (CategoriaEvento) obj;
		if (activo != other.activo)
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
		return true;
	}

	@Override
	public String toString() {
		return "CategoriaEvento [id=" + id + ", nombre=" + nombre + ", activo=" + activo + "]";
	}

}
