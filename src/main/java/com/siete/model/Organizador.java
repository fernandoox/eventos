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
	
	@OneToMany(mappedBy = "organizador", cascade = CascadeType.ALL)
	private List<Evento> eventos;

	public void addEvento(Evento evento) {
		eventos.add(evento);
		evento.setOrganizador(this);
	}
	
	public void removeEvento(Evento evento) {
		eventos.remove(evento);
		evento.setOrganizador(null);
	}
	
}
