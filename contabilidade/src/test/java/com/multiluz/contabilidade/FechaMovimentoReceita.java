package com.multiluz.contabilidade;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multiluz.contabilidade.dto.ReceitaDiariaDTO;
import com.multiluz.contabilidade.model.Despesa;
import com.multiluz.contabilidade.model.Movimento;
import com.multiluz.contabilidade.model.Receita;
import com.multiluz.contabilidade.service.MovimentoService;

@SpringBootTest
class FechaMovimentoReceita {

	@Autowired
	MovimentoService ms;
	
	@Test
	void test() {
		//fail("Not yet implemented");
	}
	
	@Test
	void fechaMovimento() {
		// Subtotal por TIPO
		List<ReceitaDiariaDTO> receitaDiaria = ms.fechaMovimentoReceita("27-12-2020");
		for (ReceitaDiariaDTO receitaDiariaDTO : receitaDiaria) {
			System.out.println(receitaDiariaDTO.getTipo() + " "  + receitaDiariaDTO.getValor());
		}

		Receita r = ms.totalDiaReceita("27-12-2020");
		Despesa d = ms.totalDiaDespesa("27-12-2020");
		System.out.println("Total Geral Receita : " + r.getValor());
		System.out.println("Total Geral Despesa : " + d.getValor());
		
		// Total Geral de Receita por DIA
		Movimento m = ms.fechaMovimento("27-12-2020");
		System.out.println("Total Receita do dia : " + m.getTotalReceita());
		System.out.println("Total Despesa do dia : " + m.getTotalDespesa());
	}
	
}
