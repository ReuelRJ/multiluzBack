package com.multiluz.contabilidade.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;


@Entity
@Data
public class Movimento implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private LocalDate data;
	
	private Double totalReceita;
	
	private Double totalDespesa;
	
	private Double conferencia;
	
	@OneToMany(mappedBy = "movimento", fetch = FetchType.LAZY)
	@JsonIgnore	
	private List<Receita> receitas;

	@OneToMany(mappedBy = "movimento", fetch = FetchType.LAZY)
	@JsonIgnore	
	private List<Despesa> despesas;
	
}
