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
	
}
