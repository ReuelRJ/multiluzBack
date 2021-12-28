package com.multiluz.contabilidade.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String logradouro;
	
	private String complemento;
	
	private String bairro;
	
	private String cidade;
	
	private String cep;
	
	@OneToOne (fetch = FetchType.LAZY)
	private Vendedor vendedor;
}
