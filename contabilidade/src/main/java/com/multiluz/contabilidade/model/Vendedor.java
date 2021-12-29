package com.multiluz.contabilidade.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.multiluz.contabilidade.enuns.Colaborador;

import lombok.Data;

@Entity
@Data
public class Vendedor implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(columnDefinition = "smallint")
	private Colaborador tipo;
	
	@OneToOne(mappedBy = "vendedor", fetch = FetchType.LAZY)
	private Endereco endereco;
	
	@OneToMany(mappedBy = "vendedor", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Telefone> telefones;
	
	@OneToMany(mappedBy = "vendedor", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Receita> vendas;
	
	@ManyToMany(targetEntity = Despesa.class, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Despesa> despesas;
	
	
	
}
