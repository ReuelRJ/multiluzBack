package com.multiluz.contabilidade.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Endereco implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String logradouro;
	
	private String numResisdencial;
	
	private String complemento;
	
	private String bairro;
	
	private String cidade;
	
	private String cep;
	
	@OneToOne 
	@JsonIgnore
	private Vendedor vendedor;
}
