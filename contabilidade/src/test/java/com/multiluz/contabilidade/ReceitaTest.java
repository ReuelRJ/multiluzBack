package com.multiluz.contabilidade;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multiluz.contabilidade.enuns.Colaborador;
import com.multiluz.contabilidade.enuns.FormaPagamento;
import com.multiluz.contabilidade.enuns.TipoDespesa;
import com.multiluz.contabilidade.model.Receita;
import com.multiluz.contabilidade.model.Vendedor;
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
		Vendedor vend = new Vendedor();
		
		vend.setNome("Junior");
		
		rec.setData(LocalDate.of(2020, 12, 27));
		rec.setParcelas(1);
		rec.setValor(26.);
		rec.setTipo(FormaPagamento.Dinheiro);
		rec.setVendedor(vend);
		
		receServ.save(rec);
		verify(rr, times(1)).save(rec);
	}
	
	
	
	@Test
	void verifyLotOfValuesReceita() {
		Receita rec = new Receita();
		TestUtil tu = new TestUtil();
		Vendedor vend = new Vendedor();
		vend.setNome("Junior");
		List<Double> valores = new ArrayList<Double>();
		valores.add(550.);
		valores.add(2340.);
		valores.add(40.);
		valores.add(50.56);
		valores.add(0.55);
		valores.add(78.);
		valores.add(25.90);
		valores.add(550.9);
		valores.add(5.9);
		valores.add(78.85);
		valores.add(15.50);
		rec.setValor(tu.totalizador(valores));

		Assert.assertTrue("O somatorio nao bate", rec.getValor() == 3736.1600000000003);
	}
	
	private Receita createReceita (Double valorTotal, FormaPagamento tipo, LocalDate data) {
		Receita rec = new Receita();
		rec.setValor(Double.valueOf(0));
		rec.setTipo(tipo);
		rec.setData(data);
		return rec;
	}
	
	@Test
	void comissao() {
		
		Receita rec = new Receita();
		rec.setId(1L);
		TestUtil tu = new TestUtil();
		Vendedor vend = new Vendedor();
		vend.setNome("Junior");
		vend.setTipo(Colaborador.Vendedor);
		List<Receita> valores = Arrays.asList(
				createReceita(550., FormaPagamento.Dinheiro, LocalDate.of(2022, 12, 27)),
				createReceita(550., FormaPagamento.Dinheiro, LocalDate.of(2022, 12, 27)),
				createReceita(2340., FormaPagamento.Debito, LocalDate.of(2022, 12, 27)),
				createReceita(2340., FormaPagamento.Debito, LocalDate.of(2022, 12, 27)),
				createReceita(40., FormaPagamento.Credito, LocalDate.of(2022, 12, 27)),
				createReceita(40., FormaPagamento.Credito, LocalDate.of(2022, 12, 27)),
				createReceita(50., FormaPagamento.Pix, LocalDate.of(2022, 12, 27)),
				createReceita(50., FormaPagamento.Pix, LocalDate.of(2022, 12, 27))
		);
		
		when(rr
				.findById(1L))
				.thenReturn(valores);
		
//		rec.setValor(tu.totalizador(valores));
		
		Double pagamento = tu.comissao(rec.getValor(), 100., vend.getTipo().toString());
		
		Assert.assertTrue("Comissao esta errada", pagamento == 174.72320000000002);
	}
}
