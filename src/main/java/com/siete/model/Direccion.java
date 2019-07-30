package com.siete.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "DIRECCION")
@SequenceGenerator(name = "ID_DIRECCION_SEQ", sequenceName = "DIRECCION_ID_SEQ" )
public class Direccion implements Serializable{

	private static final long serialVersionUID = 3833748530499656747L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_DIRECCION_SEQ")
	@Column(name = "ID", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "DIRECCION", length = 180)
	private String direccion;
	
	@Column(name = "LATITUD")
	private BigDecimal latitud;
	
	@Column(name = "LONGITUD")
	private BigDecimal longitud;
	
	@OneToOne(mappedBy = "direccion", fetch = FetchType.LAZY) // mappedBy indica que NO es la owner de la relacion
	private Evento evento;
	
	public Direccion() {
		// TODO Auto-generated constructor stub
	}
	
	public Direccion(String direccion, BigDecimal latitud, BigDecimal longitud, Evento evento) {
		this.direccion = direccion;
		this.latitud = latitud;
		this.longitud = longitud;
		this.evento = evento;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public BigDecimal getLatitud() {
		return latitud;
	}

	public void setLatitud(BigDecimal latitud) {
		this.latitud = latitud;
	}

	public BigDecimal getLongitud() {
		return longitud;
	}

	public void setLongitud(BigDecimal longitud) {
		this.longitud = longitud;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((direccion == null) ? 0 : direccion.hashCode());
		result = prime * result + ((evento == null) ? 0 : evento.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((latitud == null) ? 0 : latitud.hashCode());
		result = prime * result + ((longitud == null) ? 0 : longitud.hashCode());
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
		Direccion other = (Direccion) obj;
		if (direccion == null) {
			if (other.direccion != null)
				return false;
		} else if (!direccion.equals(other.direccion))
			return false;
		if (evento == null) {
			if (other.evento != null)
				return false;
		} else if (!evento.equals(other.evento))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (latitud == null) {
			if (other.latitud != null)
				return false;
		} else if (!latitud.equals(other.latitud))
			return false;
		if (longitud == null) {
			if (other.longitud != null)
				return false;
		} else if (!longitud.equals(other.longitud))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Direccion [id=" + id + ", direccion=" + direccion + ", latitud=" + latitud + ", longitud=" + longitud
				+ ", evento=" + evento + "]";
	}
	
}
