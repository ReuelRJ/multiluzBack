package com.multiluz.contabilidade.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.multiluz.contabilidade.enuns.TipoDespesa;

import lombok.Data;

@Entity
@Data
public class Despesa implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private LocalDate data;
	
	private Double valor;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(columnDefinition = "smallint")	
	private TipoDespesa tipo;
	
	private int parcela;
		
	@ManyToMany(targetEntity = Vendedor.class, mappedBy = "despesas", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Vendedor> vendedores;
	
	@ManyToOne
	@JoinColumn(name = "movimento_id")
	@JsonIgnore
	private Movimento movimento;	
	
}
