package com.multiluz.contabilidade;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multiluz.contabilidade.enuns.Colaborador;
import com.multiluz.contabilidade.model.Endereco;
import com.multiluz.contabilidade.model.Telefone;
import com.multiluz.contabilidade.model.Vendedor;
import com.multiluz.contabilidade.service.EnderecoService;
import com.multiluz.contabilidade.service.TelefoneService;
import com.multiluz.contabilidade.service.VendedorService;

@SpringBootTest
class CargaVendedorTest {

	@Autowired
	private VendedorService vendSer;
	
	@Autowired
	private EnderecoService endSer;
	
	@Autowired
	private TelefoneService telSer;	
	
	@Test
	void test() {
		//fail("Not yet implemented");
	}

	@Test
	void cargaVendedores() {
		
		// Vendedor
		Vendedor v1 = new Vendedor();
		v1.setNome("Antonio");
		v1.setTipo(Colaborador.Vendedor);
		vendSer.save(v1);
		
		// Estoquista
		Vendedor v2 = new Vendedor();
		v2.setNome("José");
		v2.setTipo(Colaborador.Estoquista);
		vendSer.save(v2);
		
		// Gerente
		Vendedor v3 = new Vendedor();
		v3.setNome("Junior");
		v3.setTipo(Colaborador.Gerente);
		vendSer.save(v3);		
		
		// Endereco Antonio
		Endereco e1 = new Endereco();
		e1.setLogradouro("Rua x");
		e1.setVendedor(v1);
		endSer.save(e1);		
		
		// Endereco Ze
		Endereco e2 = new Endereco();
		e2.setLogradouro("Rua y");
		e2.setVendedor(v2);
		endSer.save(e2);		

		// Endereco Junior
		Endereco e3 = new Endereco();
		e3.setLogradouro("Rua z");
		e3.setVendedor(v3);
		endSer.save(e3);		
		
		// Telefone Antonio
		Telefone t1 = new Telefone();
		t1.setDdd(21);
		t1.setTelCel(995000102);
		t1.setVendedor(v1);
		telSer.save(t1);
		//List<Telefone> tels = new ArrayList<Telefone>();
		//tels.add(t1);		

		// Telefone Zé
		Telefone t2 = new Telefone();
		t2.setDdd(21);
		t2.setTelCel(988888888);
		t2.setVendedor(v2);
		telSer.save(t2);

		// Telefone Reuel
		Telefone t3 = new Telefone();
		t3.setDdd(21);
		t3.setTelCel(977777777);
		t3.setVendedor(v3);
		telSer.save(t3);
		
		
	}
	
	
	
}
