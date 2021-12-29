package com.multiluz.contabilidade.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.multiluz.contabilidade.enuns.FormaPagamento;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReceitaDiariaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private LocalDate data;
	
	private Double valor;
	
	private FormaPagamento tipo;
	
	
}
