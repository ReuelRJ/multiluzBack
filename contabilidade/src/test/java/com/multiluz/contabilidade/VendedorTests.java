package com.multiluz.contabilidade;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multiluz.contabilidade.enuns.Colaborador;
import com.multiluz.contabilidade.model.Endereco;
import com.multiluz.contabilidade.model.Telefone;
import com.multiluz.contabilidade.model.Vendedor;
import com.multiluz.contabilidade.repository.EnderecoRepository;
import com.multiluz.contabilidade.repository.TelefoneRepository;
import com.multiluz.contabilidade.repository.VendedorRepository;

@SpringBootTest
class VendedorTests {

	@Autowired
	EnderecoRepository er;

	@Autowired
	TelefoneRepository tr;

	@Autowired
	VendedorRepository vr;

	@Test
	void contextLoads() {
	}

	@Test
	void vendedor() {
		
		Vendedor v1 = new Vendedor();
		v1.setNome("Antonio");
		v1.setTipo(Colaborador.Vendedor);
		vr.save(v1);
		
		Endereco e1 = new Endereco();
		e1.setLogradouro("Rua x");
		e1.setVendedor(v1);
		er.save(e1);
		
		Telefone t1 = new Telefone();
		t1.setDdd(21);
		t1.setTelCel(995000102);
		t1.setVendedor(v1);
		tr.save(t1);
		
		Vendedor v2 = new Vendedor();
		v2.setNome("André");
		v2.setTipo(Colaborador.Vendedor);
		vr.save(v2);
		
		Endereco e2 = new Endereco();
		e2.setLogradouro("Rua y");
		e2.setVendedor(v2);
		er.save(e2);
		
		Telefone t2 = new Telefone();
		t2.setDdd(21);
		t2.setTelCel(993029291);
		t2.setVendedor(v2);
		tr.save(t2);
		
		
	}
	
}
