package com.multiluz.contabilidade;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.multiluz.contabilidade.enuns.Colaborador;
import com.multiluz.contabilidade.model.Endereco;
import com.multiluz.contabilidade.model.Telefone;
import com.multiluz.contabilidade.model.Vendedor;
import com.multiluz.contabilidade.repository.EnderecoRepository;
import com.multiluz.contabilidade.repository.TelefoneRepository;
import com.multiluz.contabilidade.repository.VendedorRepository;
import com.multiluz.contabilidade.service.EnderecoService;
import com.multiluz.contabilidade.service.TelefoneService;
import com.multiluz.contabilidade.service.VendedorService;

@SpringBootTest
class VendedorTests {

	@Mock
	private EnderecoRepository er;

	@Mock
	private TelefoneRepository tr;

	@Mock
	private VendedorRepository vr;
	
	
	@InjectMocks
	private VendedorService vendSer;
	
	@InjectMocks
	private TelefoneService telSer;

	@InjectMocks
	private EnderecoService endSer;

	
	@Test
	void verifyVendedorSave() {
		Vendedor v1 = new Vendedor();
		v1.setNome("Antonio");
		v1.setTipo(Colaborador.Estoquista);
		vendSer.save(v1);
		verify(vr, times(1)).save(v1);
	}
	
	@Test
	void verifyVendedorSaveEstoquista() {
		Vendedor v1 = new Vendedor();
		v1.setNome("Antonio");
		v1.setTipo(Colaborador.Estoquista);
		vendSer.save(v1);
		Assert.assertTrue("O vendedor não é um estoquista", v1.getTipo() == Colaborador.Estoquista);
	}
	
	@Test
	void verifyVendedorSaveVendedor() {
		Vendedor v1 = new Vendedor();
		v1.setNome("Antonio");
		v1.setTipo(Colaborador.Vendedor);
		vendSer.save(v1);
		Assert.assertTrue("O vendedor não é um vendedor", v1.getTipo() == Colaborador.Vendedor);
	}
		
	@Test
	void verifyVendedorEndereço() {
		Vendedor v1 = new Vendedor();
		
		Endereco e1 = new Endereco();
		e1.setLogradouro("Rua x");
		e1.setVendedor(v1);
		endSer.save(e1);
		
		v1.setEndereco(e1);
		vendSer.save(v1);
		Assert.assertTrue("O vendedor não mora na rua inscrita", v1.getEndereco().getLogradouro() == "Rua x");
	}
	
	@Test
	void verifyTelefoneVendedor() {
		Vendedor v1 = new Vendedor();
		
		Telefone t1 = new Telefone();
		t1.setDdd(21);
		t1.setTelCel(995000102);
		t1.setVendedor(v1);
		telSer.save(t1);
		List<Telefone> tels = new ArrayList<Telefone>();
		tels.add(t1);
		
		v1.setTelefones(tels);
		Assert.assertTrue("O Telefone do vendedor não está correto", v1.getTelefones().get(0).getTelCel() == 995000102);
	}
		
		
		
		
		
		
	
}
