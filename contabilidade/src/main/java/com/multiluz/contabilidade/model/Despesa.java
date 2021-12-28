package com.multiluz.contabilidade.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.multiluz.contabilidade.enuns.TipoDespesa;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Despesa {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private LocalDate date;
	
	private Double valor;
	
	private TipoDespesa tipo;
	
	private int parcelas;
		
	
}
