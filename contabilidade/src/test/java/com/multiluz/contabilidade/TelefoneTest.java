package com.multiluz.contabilidade;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.multiluz.contabilidade.model.Telefone;
import com.multiluz.contabilidade.repository.TelefoneRepository;
import com.multiluz.contabilidade.service.TelefoneService;

@SpringBootTest
public class TelefoneTest {

	@Mock
	private TelefoneRepository tr;
	
	@InjectMocks
	private TelefoneService telServ;
	
	@Test
	void veryfySaveTelefone() {
		Telefone tel = new Telefone();
		tel.setDdd(21);
		tel.setTelCel(999667878);
		tel.setTelRes(25415896);
		
		telServ.save(tel);
		verify(tr, times(1)).save(tel);
	}
	
}
