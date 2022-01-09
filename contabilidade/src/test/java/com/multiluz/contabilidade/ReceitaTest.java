package com.multiluz.contabilidade;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;
import java.util.List;

import com.multiluz.contabilidade.enuns.FormaPagamento;
import com.multiluz.contabilidade.model.Receita;
import com.multiluz.contabilidade.model.Vendedor;
import com.multiluz.contabilidade.repository.ReceitaRepository;
import com.multiluz.contabilidade.repository.VendedorRepository;
import com.multiluz.contabilidade.service.ReceitaService;
import com.multiluz.contabilidade.service.VendedorService;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ReceitaTest {
	private TestUtil tu = new TestUtil();

	@Mock
	private ReceitaRepository rr;

	@Mock
	private VendedorRepository vr;

	@InjectMocks
	private ReceitaService receServ;

	@InjectMocks
	private VendedorService vendServ;

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
		Mockito.when(rr.save(rec)).thenReturn(rec); // Quando usar a classe<qualquer>.metodo<qualquer> então
													// retorne <o esperado>
		receServ.save(rec);
		verify(rr, times(1)).save(rec);
	}

	@Test
	void verifyLotOfValuesReceita() {
		List<Receita> cargaReceita = tu.cargaReceitasVendedores(LocalDate.of(2021, 12, 27), "jose", "maria", "antonio",
				10l);
		Double totalVendasDia = receServ.somaVendasDia(cargaReceita, LocalDate.of(2021, 12, 27));
		Mockito.when(receServ.somaVendasDia(cargaReceita, LocalDate.of(2021, 12, 27))).thenReturn(totalVendasDia);
		System.out.println("-------------------> Vendas: " + cargaReceita);
		System.out.println("-------------------> Vendas: " + totalVendasDia);
	}

	// temos que ver funcionando
	@Test
	void verifyVendedorReceita() {
		List<Receita> cargaReceita = tu.cargaReceitasVendedores(LocalDate.of(2021, 12, 27), "jose", "maria", "antonio",
				30l);
		List<Receita> vendasVendedor = receServ.listaVendasPorVendedor(cargaReceita, "jose");
		System.out.println("-------------------> Quantidade de Vendas: " + cargaReceita.size());
		System.out.println("-------------------> Quantidade de Vendas jose: "
				+ vendasVendedor.size());
	}

	@Test
	void teste() {
		List<Receita> cargaReceita = tu.cargaReceitasVendedor(LocalDate.of(2021, 12, 27), "jose", 2l);
		// System.out.println("---------------------------> VENDAS: " + cargaReceita);
	}
}
