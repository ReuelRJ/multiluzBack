package com.multiluz.contabilidade;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.multiluz.contabilidade.enuns.Colaborador;
import com.multiluz.contabilidade.enuns.FormaPagamento;
import com.multiluz.contabilidade.model.Receita;
import com.multiluz.contabilidade.model.Vendedor;
import com.multiluz.contabilidade.repository.ReceitaRepository;
import com.multiluz.contabilidade.service.ReceitaService;

@SpringBootTest
public class ReceitaTest {

	@Mock
	private ReceitaRepository rr;
	
	@InjectMocks
	private ReceitaService receServ;
	
	@Test
	void verifySaveReceita() {
		Receita rec = new Receita();
		Vendedor vend = new Vendedor();
		
		vend.setNome("Junior");
		
		rec.setData(LocalDate.of(2020, 12, 27));
		rec.setParcelas(1);
		rec.setValor(26.);
		rec.setVenda(FormaPagamento.Dinheiro);
		rec.setVendedor(vend);
		
		receServ.save(rec);
		verify(rr, times(1)).save(rec);
	}
	
	
	//metodo para totalizar
	public double totalizador (List<Double> valores) {
		Double total = 0.;
		
		for (int i = 0; i < valores.size(); i++) {
			total = total + valores.get(i).doubleValue();
		}
		return total;
	}
	
	public double comissao(Double valor, Double fixo, String vendedor) {
		double pagamento = 0.;
		if (vendedor == Colaborador.Vendedor.toString()) {
			pagamento = (valor * 0.02) +fixo;
		}else if(vendedor == Colaborador.Estoquista.toString()) {
			pagamento = (valor * 0.01) +fixo;
		}else if (vendedor == Colaborador.Gerente.toString()) {
			pagamento = 0.;
		}
		return pagamento;
	}
	
	@Test
	void verifyLotOfValuesReceita() {
		Receita rec = new Receita();

		Vendedor vend = new Vendedor();
		vend.setNome("Junior");
		List<Double> valores = new ArrayList<Double>();
		valores.add(550.);
		valores.add(2340.);
		valores.add(40.);
		valores.add(50.56);
		valores.add(0.55);
		valores.add(78.);
		valores.add(25.90);
		valores.add(550.9);
		valores.add(5.9);
		valores.add(78.85);
		valores.add(15.50);
		rec.setValor(totalizador(valores));

		Assert.assertTrue("O somatorio nao bate", rec.getValor() == 3736.1600000000003);
	}
	
	@Test
	void comissao() {
		Receita rec = new Receita();
		Vendedor vend = new Vendedor();
		vend.setNome("Junior");
		vend.setTipo(Colaborador.Vendedor);
		List<Double> valores = new ArrayList<Double>();
		valores.add(550.);
		valores.add(2340.);
		valores.add(40.);
		valores.add(50.56);
		valores.add(0.55);
		valores.add(78.);
		valores.add(25.90);
		valores.add(550.9);
		valores.add(5.9);
		valores.add(78.85);
		valores.add(15.50);
		rec.setValor(totalizador(valores));
		
		Double pagamento = comissao(rec.getValor(), 100., vend.getTipo().toString());
		
		Assert.assertTrue("Comissao esta errada", pagamento == 174.72320000000002);
	}
}
