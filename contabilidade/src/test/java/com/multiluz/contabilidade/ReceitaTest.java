package com.multiluz.contabilidade;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.multiluz.contabilidade.enuns.FormaPagamento;
import com.multiluz.contabilidade.model.Movimento;
import com.multiluz.contabilidade.model.Receita;
import com.multiluz.contabilidade.model.Vendedor;
import com.multiluz.contabilidade.repository.ReceitaRepository;
import com.multiluz.contabilidade.repository.VendedorRepository;
import com.multiluz.contabilidade.service.ReceitaService;
import com.multiluz.contabilidade.service.VendedorService;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ReceitaTest {

	@Mock
	private ReceitaRepository rr;

	@Mock
	private VendedorRepository vr;

	@InjectMocks
	private ReceitaService receServ;

	@InjectMocks
	private VendedorService vendServ;

	public List<Receita> cargaReceitasVendedor(String nomeVendedor) {
		Movimento m = new Movimento();
		Vendedor v1 = new Vendedor();
		v1.setNome(nomeVendedor);
		List<Receita> valores = Arrays.asList(
				new Receita[] {
						new Receita(1L, LocalDate.of(2020, 12, 27), 20., FormaPagamento.Credito, 1, v1, m),
						new Receita(1L, LocalDate.of(2020, 12, 27), 20., FormaPagamento.Credito, 1, v1, m),
						new Receita(1L, LocalDate.of(2020, 12, 27), 20., FormaPagamento.Credito, 1, v1, m),
						new Receita(1L, LocalDate.of(2020, 12, 27), 20., FormaPagamento.Credito, 2, v1, m),
						new Receita(1L, LocalDate.of(2020, 12, 27), 20., FormaPagamento.Credito, 2, v1, m),
						new Receita(1L, LocalDate.of(2020, 12, 27), 20., FormaPagamento.Credito, 2, v1, m),
						new Receita(1L, LocalDate.of(2020, 12, 27), 20., FormaPagamento.Credito, 3, v1, m),
						new Receita(1L, LocalDate.of(2020, 12, 27), 20., FormaPagamento.Credito, 3, v1, m),
						new Receita(1L, LocalDate.of(2020, 12, 27), 20., FormaPagamento.Credito, 3, v1, m),
						new Receita(1L, LocalDate.of(2020, 12, 27), 20., FormaPagamento.Credito, 4, v1, m),
						new Receita(1L, LocalDate.of(2020, 12, 27), 20., FormaPagamento.Credito, 4, v1, m),
						new Receita(1L, LocalDate.of(2020, 12, 27), 20., FormaPagamento.Credito, 4, v1, m),
						new Receita(1L, LocalDate.of(2020, 12, 27), 20., FormaPagamento.Credito, 5, v1, m),
						new Receita(1L, LocalDate.of(2020, 12, 27), 20., FormaPagamento.Credito, 5, v1, m),
						new Receita(1L, LocalDate.of(2020, 12, 27), 20., FormaPagamento.Credito, 5, v1, m),
						new Receita(1L, LocalDate.of(2020, 12, 27), 20., FormaPagamento.Credito, 6, v1, m),
						new Receita(1L, LocalDate.of(2020, 12, 27), 20., FormaPagamento.Credito, 6, v1, m),
						new Receita(1L, LocalDate.of(2020, 12, 27), 20., FormaPagamento.Credito, 6, v1, m),

						new Receita(1L, LocalDate.of(2020, 12, 27), 30., FormaPagamento.Debito, 1, v1, m),
						new Receita(1L, LocalDate.of(2020, 12, 27), 30., FormaPagamento.Debito, 1, v1, m),
						new Receita(1L, LocalDate.of(2020, 12, 27), 30., FormaPagamento.Debito, 1, v1, m),
						new Receita(1L, LocalDate.of(2020, 12, 27), 30., FormaPagamento.Debito, 1, v1, m),
						new Receita(1L, LocalDate.of(2020, 12, 27), 30., FormaPagamento.Debito, 1, v1, m),
						new Receita(1L, LocalDate.of(2020, 12, 27), 30., FormaPagamento.Debito, 1, v1, m),

						new Receita(1L, LocalDate.of(2020, 12, 27), 40., FormaPagamento.Dinheiro, 1, v1, m),
						new Receita(1L, LocalDate.of(2020, 12, 27), 40., FormaPagamento.Dinheiro, 1, v1, m),
						new Receita(1L, LocalDate.of(2020, 12, 27), 40., FormaPagamento.Dinheiro, 1, v1, m),
						new Receita(1L, LocalDate.of(2020, 12, 27), 40., FormaPagamento.Dinheiro, 1, v1, m),
						new Receita(1L, LocalDate.of(2020, 12, 27), 40., FormaPagamento.Dinheiro, 1, v1, m),
						new Receita(1L, LocalDate.of(2020, 12, 27), 40., FormaPagamento.Dinheiro, 1, v1, m),

						new Receita(1L, LocalDate.of(2020, 12, 27), 50., FormaPagamento.Pix, 1, v1, m),
						new Receita(1L, LocalDate.of(2020, 12, 27), 50., FormaPagamento.Pix, 1, v1, m),
						new Receita(1L, LocalDate.of(2020, 12, 27), 50., FormaPagamento.Pix, 1, v1, m),
						new Receita(1L, LocalDate.of(2020, 12, 27), 50., FormaPagamento.Pix, 1, v1, m),
						new Receita(1L, LocalDate.of(2020, 12, 27), 50., FormaPagamento.Pix, 1, v1, m),
						new Receita(1L, LocalDate.of(2020, 12, 27), 50., FormaPagamento.Pix, 1, v1, m),
				});
		return valores;
	}

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

	// temos que ver funcionando
	@Test
	void verifyVendedorReceita() {
		Vendedor v1 = new Vendedor();
		v1.setNome("jose");
		Vendedor v2 = new Vendedor();
		v2.setNome("maria");
		Receita receita = new Receita();
		List<Receita> cargaReceita = cargaReceitasVendedor("jose");
		Mockito.when(rr.save(receita)).thenReturn(receita);

		//List<Receita> vendasVendedor = receServ.listaVendasPorVendedor(cargaReceita, v1.getNome());
		//Double somatorioVendedor = receServ.somaVendasPorVendedor(cargaReceita, v1.getNome());
		//Assert.assertTrue(somatorioVendedor == 1080.0);

		// Assert.assertEquals("jose", valores.get(0).getVendedor().getNome());
	}
}
