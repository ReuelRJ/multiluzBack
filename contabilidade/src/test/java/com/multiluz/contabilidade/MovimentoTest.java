package com.multiluz.contabilidade;

import java.time.LocalDate;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multiluz.contabilidade.dto.ReceitaDiariaDTO;
import com.multiluz.contabilidade.service.MovimentoService;

@SpringBootTest
class MovimentoTest {

	@Autowired
	MovimentoService ms;
	
	@Test
	void test() {
		//fail("Not yet implemented");
	}

	@Test
	void verifyMovimento() {
		
		List<ReceitaDiariaDTO> lista = ms.fechaMovimentoReceita("29122021");
		
		Assert.assertTrue("Não tem dados", lista.size() == 0);
		
	}
	
}
