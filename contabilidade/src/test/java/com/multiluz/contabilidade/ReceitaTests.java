package com.multiluz.contabilidade;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multiluz.contabilidade.enuns.FormaPagamento;
import com.multiluz.contabilidade.model.Receita;
import com.multiluz.contabilidade.model.Vendedor;
import com.multiluz.contabilidade.repository.ReceitaRepository;
import com.multiluz.contabilidade.repository.VendedorRepository;

@SpringBootTest
class ReceitaTests {

	@Autowired
	ReceitaRepository rr;

	@Autowired
	VendedorRepository vr;

	@Test
	void contextLoads() {
	}

	@Test
	void vendedor() {

		Optional<Vendedor> vo = vr.findById(1L);
		Vendedor v1 = vo.get();
		
		Receita r1 = new Receita();
		//r1.setData(LocalDate.now());
		r1.setData(LocalDate.of(2021, 12, 28));
		r1.setValor(13.5);
		r1.setVenda(FormaPagamento.Dinheiro);
		r1.setParcelas(0);
		r1.setVendedor(v1);
		rr.save(r1);

	}
	
}
