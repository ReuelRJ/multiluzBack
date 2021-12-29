package com.multiluz.contabilidade;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.multiluz.contabilidade.enuns.FormaPagamento;
import com.multiluz.contabilidade.model.Receita;
import com.multiluz.contabilidade.repository.ReceitaRepository;
import com.multiluz.contabilidade.service.ReceitaService;

@SpringBootTest
public class ReceitaTest {

	@Mock
	private ReceitaRepository rr;
	
	@InjectMocks
	private ReceitaService receServ;
	
	@Test
	void verifySaveReceita() {
		Receita rec = new Receita();
		
		rec.setData(LocalDate.of(2020, 12, 27));
		rec.setParcelas(1);
		rec.setValor(26.);
		rec.setVenda(FormaPagamento.Dinheiro);
		
	}
}
