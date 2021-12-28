package com.multiluz.contabilidade.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.multiluz.contabilidade.enuns.FormaPagamento;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Receita {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private LocalDate date;
	
	private Double valor;
	
	private FormaPagamento venda;
	
	private int parcelas;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Vendedor vendedor;
}
