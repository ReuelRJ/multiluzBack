package com.multiluz.contabilidade;

import static org.junit.jupiter.api.Assertions.fail;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multiluz.contabilidade.enuns.FormaPagamento;
import com.multiluz.contabilidade.model.Receita;
import com.multiluz.contabilidade.model.Vendedor;
import com.multiluz.contabilidade.service.ReceitaService;
import com.multiluz.contabilidade.service.VendedorService;


@SpringBootTest
class CargaReceitaTest {

	
	@Autowired
	VendedorService vs;
	
	@Autowired
	ReceitaService rs;	
	
	@Test
	void test() {
		//fail("Not yet implemented");
	}


	@Test
	void cargaReceita() {
		
		// Carga Receita Vendedor Antonio
		List<Receita> cargaReceitaAntonio = cargaReceitasVendedorAntonio(vs.findVendedor(1L));

		for (Receita receita : cargaReceitaAntonio) {
			rs.save(receita);
		}
		
		// Carga Receita Vendedor Jose
		List<Receita> cargaReceitaJose = cargaReceitasVendedorJose(vs.findVendedor(2L));

		for (Receita receita : cargaReceitaJose) {
			rs.save(receita);
		}
		
		// Carga Receita Vendedor Junior
		List<Receita> cargaReceitaJunior = cargaReceitasVendedorJunior(vs.findVendedor(3L));
		
		for (Receita receita : cargaReceitaJunior) {
			rs.save(receita);
		}
		
	}	
	
	public List<Receita> cargaReceitasVendedorAntonio(Vendedor v) {

		List<Receita> valores = Arrays.asList(
				new Receita[] {
						
						new Receita(LocalDate.of(2020, 12, 27), 1, 20., FormaPagamento.Credito, v),
						new Receita(LocalDate.of(2020, 12, 27), 1, 20., FormaPagamento.Credito, v),
						new Receita(LocalDate.of(2020, 12, 27), 1, 20., FormaPagamento.Credito, v),
						new Receita(LocalDate.of(2020, 12, 27), 2, 20., FormaPagamento.Credito, v),
						new Receita(LocalDate.of(2020, 12, 27), 2, 20., FormaPagamento.Credito, v),
						new Receita(LocalDate.of(2020, 12, 27), 2, 20., FormaPagamento.Credito, v),
						new Receita(LocalDate.of(2020, 12, 27), 3, 20., FormaPagamento.Credito, v),
						new Receita(LocalDate.of(2020, 12, 27), 3, 20., FormaPagamento.Credito, v),
						new Receita(LocalDate.of(2020, 12, 27), 3, 20., FormaPagamento.Credito, v),
						new Receita(LocalDate.of(2020, 12, 27), 4, 20., FormaPagamento.Credito, v),
						new Receita(LocalDate.of(2020, 12, 27), 4, 20., FormaPagamento.Credito, v),
						new Receita(LocalDate.of(2020, 12, 27), 4, 20., FormaPagamento.Credito, v),
						new Receita(LocalDate.of(2020, 12, 27), 5, 20., FormaPagamento.Credito, v),
						new Receita(LocalDate.of(2020, 12, 27), 5, 20., FormaPagamento.Credito, v),
						new Receita(LocalDate.of(2020, 12, 27), 5, 20., FormaPagamento.Credito, v),
						new Receita(LocalDate.of(2020, 12, 27), 6, 20., FormaPagamento.Credito, v),
						new Receita(LocalDate.of(2020, 12, 27), 6, 20., FormaPagamento.Credito, v),
						new Receita(LocalDate.of(2020, 12, 27), 6, 20., FormaPagamento.Credito, v),

						new Receita(LocalDate.of(2020, 12, 27), 1, 30., FormaPagamento.Debito, v),
						new Receita(LocalDate.of(2020, 12, 27), 1, 30., FormaPagamento.Debito, v),
						new Receita(LocalDate.of(2020, 12, 27), 1, 30., FormaPagamento.Debito, v),
						new Receita(LocalDate.of(2020, 12, 27), 1, 30., FormaPagamento.Debito, v),
						new Receita(LocalDate.of(2020, 12, 27), 1, 30., FormaPagamento.Debito, v),
						new Receita(LocalDate.of(2020, 12, 27), 1, 30., FormaPagamento.Debito, v),

						new Receita(LocalDate.of(2020, 12, 27), 1, 40., FormaPagamento.Dinheiro, v),
						new Receita(LocalDate.of(2020, 12, 27), 1, 40., FormaPagamento.Dinheiro, v),
						new Receita(LocalDate.of(2020, 12, 27), 1, 40., FormaPagamento.Dinheiro, v),
						new Receita(LocalDate.of(2020, 12, 27), 1, 40., FormaPagamento.Dinheiro, v),
						new Receita(LocalDate.of(2020, 12, 27), 1, 40., FormaPagamento.Dinheiro, v),
						new Receita(LocalDate.of(2020, 12, 27), 1, 40., FormaPagamento.Dinheiro, v),

						new Receita(LocalDate.of(2020, 12, 27), 1, 50., FormaPagamento.Pix, v),
						new Receita(LocalDate.of(2020, 12, 27), 1, 50., FormaPagamento.Pix, v),
						new Receita(LocalDate.of(2020, 12, 27), 1, 50., FormaPagamento.Pix, v),
						new Receita(LocalDate.of(2020, 12, 27), 1, 50., FormaPagamento.Pix, v),
						new Receita(LocalDate.of(2020, 12, 27), 1, 50., FormaPagamento.Pix, v),
						new Receita(LocalDate.of(2020, 12, 27), 1, 50., FormaPagamento.Pix, v),

				});
		return valores;
	}	
	
	public List<Receita> cargaReceitasVendedorJose(Vendedor v) {

		List<Receita> valores = Arrays.asList(
				new Receita[] {
						
						new Receita(LocalDate.of(2020, 12, 27), 1, 20., FormaPagamento.Credito, v),
						new Receita(LocalDate.of(2020, 12, 27), 1, 20., FormaPagamento.Credito, v),
						new Receita(LocalDate.of(2020, 12, 27), 1, 20., FormaPagamento.Credito, v),
						new Receita(LocalDate.of(2020, 12, 27), 2, 20., FormaPagamento.Credito, v),
						new Receita(LocalDate.of(2020, 12, 27), 2, 20., FormaPagamento.Credito, v),
						new Receita(LocalDate.of(2020, 12, 27), 2, 20., FormaPagamento.Credito, v),
						new Receita(LocalDate.of(2020, 12, 27), 3, 20., FormaPagamento.Credito, v),
						new Receita(LocalDate.of(2020, 12, 27), 3, 20., FormaPagamento.Credito, v),
						new Receita(LocalDate.of(2020, 12, 27), 3, 20., FormaPagamento.Credito, v),
						new Receita(LocalDate.of(2020, 12, 27), 4, 20., FormaPagamento.Credito, v),

						new Receita(LocalDate.of(2020, 12, 27), 1, 30., FormaPagamento.Debito, v),
						new Receita(LocalDate.of(2020, 12, 27), 1, 30., FormaPagamento.Debito, v),
						new Receita(LocalDate.of(2020, 12, 27), 1, 30., FormaPagamento.Debito, v),

						new Receita(LocalDate.of(2020, 12, 27), 1, 40., FormaPagamento.Dinheiro, v),
						new Receita(LocalDate.of(2020, 12, 27), 1, 40., FormaPagamento.Dinheiro, v),
						new Receita(LocalDate.of(2020, 12, 27), 1, 40., FormaPagamento.Dinheiro, v),

						new Receita(LocalDate.of(2020, 12, 27), 1, 50., FormaPagamento.Pix, v),
						new Receita(LocalDate.of(2020, 12, 27), 1, 50., FormaPagamento.Pix, v),
						new Receita(LocalDate.of(2020, 12, 27), 1, 50., FormaPagamento.Pix, v),

				});
		return valores;
	}		
	
	public List<Receita> cargaReceitasVendedorJunior(Vendedor v) {

		List<Receita> valores = Arrays.asList(
				new Receita[] {
						
						new Receita(LocalDate.of(2020, 12, 27), 1, 20., FormaPagamento.Credito, v),
						new Receita(LocalDate.of(2020, 12, 27), 1, 20., FormaPagamento.Credito, v),
						new Receita(LocalDate.of(2020, 12, 27), 1, 20., FormaPagamento.Credito, v),
						new Receita(LocalDate.of(2020, 12, 27), 2, 20., FormaPagamento.Credito, v),
						new Receita(LocalDate.of(2020, 12, 27), 2, 20., FormaPagamento.Credito, v),

						new Receita(LocalDate.of(2020, 12, 27), 1, 30., FormaPagamento.Debito, v),
						new Receita(LocalDate.of(2020, 12, 27), 1, 30., FormaPagamento.Debito, v),

						new Receita(LocalDate.of(2020, 12, 27), 1, 40., FormaPagamento.Dinheiro, v),
						new Receita(LocalDate.of(2020, 12, 27), 1, 40., FormaPagamento.Dinheiro, v),

						new Receita(LocalDate.of(2020, 12, 27), 1, 50., FormaPagamento.Pix, v),
						new Receita(LocalDate.of(2020, 12, 27), 1, 50., FormaPagamento.Pix, v),

				});
		return valores;
	}		
}
