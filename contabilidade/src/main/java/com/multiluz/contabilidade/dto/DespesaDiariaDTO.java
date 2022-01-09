package com.multiluz.contabilidade.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.multiluz.contabilidade.enuns.TipoDespesa;
import com.multiluz.contabilidade.model.Despesa;
import com.multiluz.contabilidade.model.Movimento;
import com.multiluz.contabilidade.model.Vendedor;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DespesaDiariaDTO implements Serializable {

	// VERSÃO
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private LocalDate data;
	
	private Double valor;
	
	private TipoDespesa tipo;
	
	private int parcelas;
	
	private Vendedor vendedor;
	
	//private Movimento movimento;

	public DespesaDiariaDTO(Despesa despesa) {
		this.id = despesa.getId();
		this.data = despesa.getData();
		this.valor = despesa.getValor();
		this.tipo = despesa.getTipo();
		this.parcelas = despesa.getParcelas();
		this.vendedor = despesa.getVendedor();
		//this.movimento = despesa.getMovimento();
	}

}
