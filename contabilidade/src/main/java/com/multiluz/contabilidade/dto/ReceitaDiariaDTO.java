package com.multiluz.contabilidade.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.multiluz.contabilidade.enuns.FormaPagamento;
import com.multiluz.contabilidade.model.Movimento;
import com.multiluz.contabilidade.model.Receita;
import com.multiluz.contabilidade.model.Vendedor;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReceitaDiariaDTO implements Serializable {
	
	// VERSÃO
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private LocalDate data;
	
	private Double valor;
	
	private FormaPagamento tipo;
	
	private int parcelas;
	
	private Vendedor vendedor;
	
	//private Movimento movimento;

	public ReceitaDiariaDTO(Receita receita) {
		this.id = receita.getId();
		this.data = receita.getData();
		this.valor = receita.getValor();
		this.tipo = receita.getTipo();
		this.parcelas = receita.getParcelas();
		this.vendedor = receita.getVendedor();
		//this.movimento = receita.getMovimento();
	}
	
	// JÁ TEM OS METODOS CONSTRUTOES DEFAULT E COM OS FIELDS

	// Parse de JPA para DTO
	
	
}
