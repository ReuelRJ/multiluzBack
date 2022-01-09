package com.multiluz.contabilidade;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.multiluz.contabilidade.enuns.Colaborador;
import com.multiluz.contabilidade.enuns.FormaPagamento;
import com.multiluz.contabilidade.model.Movimento;
import com.multiluz.contabilidade.model.Receita;
import com.multiluz.contabilidade.model.Vendedor;

public class TestUtil {

	// metodo para totalizar
	public double totalizador(List<Double> valores) {
		Double total = 0.;

		for (int i = 0; i < valores.size(); i++) {
			total = total + valores.get(i).doubleValue();
		}
		return total;
	}

	public double comissao(Double valor, Double fixo, String vendedor) {
		double pagamento = 0.;
		if (vendedor == Colaborador.Vendedor.toString()) {
			pagamento = (valor * 0.02) + fixo;
		} else if (vendedor == Colaborador.Estoquista.toString()) {
			pagamento = (valor * 0.01) + fixo;
		} else if (vendedor == Colaborador.Gerente.toString()) {
			pagamento = 0.;
		}
		return pagamento;
	}

	public List<Receita> cargaReceitasVendedores(LocalDate date, String nomeVendedor1, String nomeVendedor2,
			String nomeVendedor3,
			Long numeroVendas) {
		Movimento m = new Movimento();
		Random r = new Random();
		Vendedor v1 = new Vendedor();
		Vendedor v2 = new Vendedor();
		Vendedor v3 = new Vendedor();
		v1.setNome(nomeVendedor1);
		v2.setNome(nomeVendedor2);
		v3.setNome(nomeVendedor3);
		List<Vendedor> vendedores = new ArrayList<Vendedor>();
		vendedores.add(v1);
		vendedores.add(v2);
		vendedores.add(v3);
		List<Receita> receitas2 = new ArrayList<Receita>();
		for (Long i = 0L; i <= numeroVendas; i++) {
			Double valorVenda = r.nextDouble() * 1000;
			Double valorRS = Double.parseDouble(new DecimalFormat("0.00").format(valorVenda).replace(",", "."));
			FormaPagamento forma = FormaPagamento.values()[(int) (Math.random() * FormaPagamento.values().length)];
			Vendedor vend = vendedores.get(r.nextInt(vendedores.size()));
			receitas2.add(new Receita(i, date, valorRS, forma, r.nextInt(7 - 1) + 1, vend, m));
		}
		return receitas2;
	}

	public List<Receita> cargaReceitasVendedor(LocalDate date, String nomeVendedor1, Long numeroVendas) {
		Movimento m = new Movimento();
		Random r = new Random();
		Vendedor v1 = new Vendedor();
		v1.setNome(nomeVendedor1);
		List<Receita> receitas2 = new ArrayList<Receita>();
		for (Long i = 0L; i <= numeroVendas; i++) {
			Double valorVenda = r.nextDouble() * 1000;
			Double valorRS = Double.parseDouble(new DecimalFormat("0.00").format(valorVenda).replace(",", "."));
			FormaPagamento forma = FormaPagamento.values()[(int) (Math.random() * FormaPagamento.values().length)];
			receitas2.add(new Receita(i, date, valorRS, forma, r.nextInt(7 - 1) + 1, v1, m));
		}
		return receitas2;
	}
}
