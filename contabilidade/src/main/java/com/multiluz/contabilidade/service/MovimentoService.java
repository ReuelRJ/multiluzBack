package com.multiluz.contabilidade.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.multiluz.contabilidade.dto.DespesaDiariaDTO;
import com.multiluz.contabilidade.dto.ReceitaDiariaDTO;
import com.multiluz.contabilidade.enuns.Colaborador;
import com.multiluz.contabilidade.model.Despesa;
import com.multiluz.contabilidade.model.Movimento;
import com.multiluz.contabilidade.model.Receita;
import com.multiluz.contabilidade.model.Vendedor;
import com.multiluz.contabilidade.repository.DespesaRepository;
import com.multiluz.contabilidade.repository.MovimentoRepository;
import com.multiluz.contabilidade.repository.ReceitaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovimentoService {

	@Autowired
	private MovimentoRepository mr;

	@Autowired
	private ReceitaRepository rr;

	@Autowired
	private DespesaRepository dr;

	public void save(Movimento mov) {
		mr.save(mov);
	}

	// Executa MOVIMENTO
	public Movimento fechaMovimento(String data) {
		Receita receita = totalDiaReceita(data);
		Despesa despesa = totalDiaDespesa(data);
		Movimento m = new Movimento();
		m.setData(formataData(data));
		m.setTotalReceita(receita.getValor());
		m.setTotalDespesa(despesa.getValor());
		return m;
	}

	// Total do dia RECEITA
	public Receita totalDiaReceita(String data) {
		Receita receita = rr.receitaDiariaTotalGeral(formataData(data));
		return receita;
	}

	// Total do dia Despesa
	public Despesa totalDiaDespesa(String data) {
		Despesa despesa = dr.despesaDiariaTotalGeral(formataData(data));
		return despesa;
	}

	// Totalizador por TIPO
	public List<ReceitaDiariaDTO> fechaMovimentoReceita(String data) {
		List<Receita> lista = rr.receitaDiariaByTipo(formataData(data));
		// converter a lista de Receita para ReceitaDiariaDTO
		// Usar Lambda, Stream , função MAP que vai converter a coleção Original para um
		// nova coleção
		// pra cada x popular objeto ReceitaDiariaDTO
		return lista.stream().map(x -> new ReceitaDiariaDTO(x)).collect(Collectors.toList());
	}

	// Totalizador por VENDEDOR
	public List<ReceitaDiariaDTO> receitaDiariaByVendedor(String data) {
		List<Receita> lista = rr.receitaDiariaByVendedor(formataData(data));
		return lista.stream().map(x -> new ReceitaDiariaDTO(x)).collect(Collectors.toList());
	}

	// Totalizador por TIPO
	public List<DespesaDiariaDTO> fechaMovimentoDespesa(String data) {
		List<Despesa> lista = dr.despesaDiariaByTipo(formataData(data));
		return lista.stream().map(x -> new DespesaDiariaDTO(x)).collect(Collectors.toList());
	}

	// Totalizador por VENDEDOR
	public List<DespesaDiariaDTO> despesaDiariaByVendedor(String data) {
		List<Despesa> lista = dr.despesaDiariaByVendedor(formataData(data));
		return lista.stream().map(x -> new DespesaDiariaDTO(x)).collect(Collectors.toList());
	}

	// calcula comissao
	public double comissao(List<Receita> receitas, Vendedor vendedor) {
		Double comissao = 0.;
		if (vendedor.getTipo().equals(Colaborador.Vendedor)) {
			for (Receita r : receitas) {
				comissao = comissao + (r.getValor() * 0.02);
			}
		} else if (vendedor.getTipo().equals(Colaborador.Estoquista)) {
			for (Receita r : receitas) {
				comissao = comissao + (r.getValor() * 0.01);
			}
		} else if (vendedor.getTipo().equals(Colaborador.Gerente)) {
			comissao = 0.;
		}

		return comissao;
	}

	public LocalDate formataData(String data) {
		int dia = Integer.valueOf(data.substring(0, 2));
		int mes = Integer.valueOf(data.substring(3, 5));
		int ano = Integer.valueOf(data.substring(6, 10));
		System.out.println(dia + " " + mes + " " + ano);
		return LocalDate.of(ano, mes, dia);
	}
}
