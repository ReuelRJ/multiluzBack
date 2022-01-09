package com.multiluz.contabilidade;

import java.time.LocalDate;
import java.util.List;

import com.multiluz.contabilidade.enuns.Colaborador;
import com.multiluz.contabilidade.enuns.FormaPagamento;
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

	public double comissao(Double valor, Double fixo, Vendedor vendedor) {
		double pagamento = 0.;
		if (vendedor.getTipo().equals(Colaborador.Vendedor)) {
			pagamento = (valor * 0.02) + fixo;
		} else if (vendedor.getTipo().equals(Colaborador.Estoquista)) {
			pagamento = (valor * 0.01) + fixo;
		} else if (vendedor.getTipo().equals(Colaborador.Gerente)) {
			pagamento = 0.;
		}
		return pagamento;
	}

	public Receita createReceita(Double valorTotal, FormaPagamento tipo, LocalDate data) {
		Receita rec = new Receita();
		rec.setValor(Double.valueOf(0));
		rec.setTipo(tipo);
		rec.setData(data);
		return rec;
	}

}
