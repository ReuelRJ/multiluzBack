package com.multiluz.contabilidade;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.multiluz.contabilidade.model.Endereco;
import com.multiluz.contabilidade.repository.EnderecoRepository;
import com.multiluz.contabilidade.service.EnderecoService;

@SpringBootTest
public class EnderecoTest {

	
	@Mock
	private EnderecoRepository er;
	
	@InjectMocks
	private EnderecoService endServ;
	
	@Test
	void verifySaveEndereco() {
		Endereco end = new Endereco();
		end.setBairro("Copacabana");
		end.setCep("22040040");
		end.setCidade("Rio de Janeiro");
		end.setComplemento("ap 303");
		end.setLogradouro("Rua Hilario de Gouveia");
		end.setNumResisdencial("77");
		endServ.save(end);
		
		verify(er, times(1)).save(end);
	}
}
