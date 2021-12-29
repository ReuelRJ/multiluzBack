package com.multiluz.contabilidade;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.multiluz.contabilidade.enuns.Colaborador;
import com.multiluz.contabilidade.enuns.TipoDespesa;
import com.multiluz.contabilidade.model.Despesa;
import com.multiluz.contabilidade.model.Vendedor;
import com.multiluz.contabilidade.repository.DespesaRepository;
import com.multiluz.contabilidade.repository.VendedorRepository;
import com.multiluz.contabilidade.service.DespesaService;

@SpringBootTest
public class DespesaTest {

	@Mock
	DespesaRepository dr;
	
	@Mock
	VendedorRepository vr;
	
	@InjectMocks
	DespesaService despServ;
	
	@Test
	void verifySaveDespesa() {
		Despesa desp = new Despesa();
		
		desp.setData(LocalDate.of(2020, 12, 27));
		desp.setParcela(1);
		desp.setTipo(TipoDespesa.Diaria);
		desp.setValor(2.);

		despServ.save(desp);
		verify(dr, times(1)).save(desp);
	}
	
	@Test
	void verifySaveDespesaDiaria() {
		Despesa desp = new Despesa();
		
		desp.setData(LocalDate.of(2020, 12, 27));
		desp.setParcela(1);
		desp.setTipo(TipoDespesa.Diaria);
		desp.setValor(2.);

		despServ.save(desp);
		Assert.assertTrue("O tipo de despesa nao corresponde", desp.getTipo() == TipoDespesa.Diaria);
	}
	
	@Test
	void verifySaveDespesaPendencia() {
		Despesa desp = new Despesa();
		
		desp.setData(LocalDate.of(2020, 12, 27));
		desp.setParcela(1);
		desp.setTipo(TipoDespesa.Pendencia);
		desp.setValor(2.);

		despServ.save(desp);
		Assert.assertTrue("O tipo de despesa nao corresponde", desp.getTipo() == TipoDespesa.Pendencia);
	}
	
	@Test
	void verifySaveDespesaVale() {
		Despesa desp = new Despesa();
		
		desp.setData(LocalDate.of(2020, 12, 27));
		desp.setParcela(1);
		desp.setTipo(TipoDespesa.Vale);
		desp.setValor(2.);

		despServ.save(desp);
		Assert.assertTrue("O tipo de despesa nao corresponde", desp.getTipo() == TipoDespesa.Vale);
	}
	
}
