package com.multiluz.contabilidade;

import java.time.LocalDate;
import java.util.List;

import com.multiluz.contabilidade.enuns.Colaborador;
import com.multiluz.contabilidade.enuns.FormaPagamento;
import com.multiluz.contabilidade.model.Receita;

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

	public Receita createReceita(Double valorTotal, FormaPagamento tipo, LocalDate data) {
		Receita rec = new Receita();
		rec.setValor(Double.valueOf(0));
		rec.setTipo(tipo);
		rec.setData(data);
		return rec;
	}

}
