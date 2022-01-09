package com.multiluz.contabilidade.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Telefone implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Integer ddd;
	
	private Integer telRes;
	
	private Integer telCel;
	
	@ManyToOne
	@JoinColumn(name = "vendedor_id")
	@JsonIgnore
	private Vendedor vendedor;

}
