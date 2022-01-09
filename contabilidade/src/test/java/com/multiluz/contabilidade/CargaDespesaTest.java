package com.multiluz.contabilidade;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multiluz.contabilidade.enuns.TipoDespesa;
import com.multiluz.contabilidade.model.Despesa;
import com.multiluz.contabilidade.model.Vendedor;
import com.multiluz.contabilidade.service.DespesaService;
import com.multiluz.contabilidade.service.VendedorService;

@SpringBootTest
class CargaDespesaTest {

	@Autowired
	DespesaService ds;
	
	@Autowired
	VendedorService vs;	
	
	@Test
	void test() {
		//fail("Not yet implemented");
	}

	@Test
	void cargaDespesa() {
		
		// gasto escritorio
		Despesa desp1 = new Despesa();
		desp1.setData(LocalDate.of(2020, 12, 27));
		desp1.setParcelas(1);
		desp1.setTipo(TipoDespesa.Diaria);
		desp1.setValor(14.5);
		ds.save(desp1);

		// gasto escritorio
		Despesa desp2 = new Despesa();
		desp2.setData(LocalDate.of(2020, 12, 27));
		desp2.setParcelas(1);
		desp2.setTipo(TipoDespesa.Diaria);
		desp2.setValor(2.5);
		ds.save(desp2);

		// Antonio pegou material
		Vendedor v1 = vs.findVendedor(1L);
		
		Despesa desp3 = new Despesa();
		desp3.setData(LocalDate.of(2020, 12, 27));
		desp3.setParcelas(1);
		desp3.setTipo(TipoDespesa.Pendencia);
		desp3.setValor(142.);
		desp3.setVendedor(v1);
		ds.save(desp3);

		// Jose pediu vale
		Vendedor v2 = vs.findVendedor(2L);
		
		Despesa desp4 = new Despesa();
		desp4.setData(LocalDate.of(2020, 12, 27));
		desp4.setParcelas(1);
		desp4.setTipo(TipoDespesa.Vale);
		desp4.setValor(50.);
		desp4.setVendedor(v2);
		ds.save(desp4);		
	}
	
}
