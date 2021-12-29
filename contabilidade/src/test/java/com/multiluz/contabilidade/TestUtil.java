package com.multiluz.contabilidade;

import java.util.List;

import com.multiluz.contabilidade.enuns.Colaborador;

public class TestUtil {


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
	
}
