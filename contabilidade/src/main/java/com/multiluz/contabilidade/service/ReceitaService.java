package com.multiluz.contabilidade.service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.multiluz.contabilidade.model.Receita;
import com.multiluz.contabilidade.model.Vendedor;
import com.multiluz.contabilidade.repository.ReceitaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReceitaService {

	@Autowired
	private ReceitaRepository receRepo;

	public void save(Receita rece) {

		receRepo.save(rece);
	}

	// dois metodos para pegar vendas e pegar somatorio de vendas de acordo com o
	// funcionario
	public Double somaVendasPorVendedor(List<Receita> receitas, String nomeVendedor) {
		Double somatorioVendedor = receitas.stream().filter(x -> x.getVendedor().getNome() == nomeVendedor)
				.mapToDouble(x -> x.getValor()).sum();
		return somatorioVendedor;
	}

	public List<Receita> listaVendasPorVendedor(List<Receita> receitas, String nomeVendedor) {
		List<Receita> listVendasVendedor = receitas.stream().filter(x -> x.getVendedor().getNome() == nomeVendedor)
				.collect(Collectors.toList());
		return listVendasVendedor;
	}

	public Double somaVendasDia(List<Receita> receitas, LocalDate date) {
		List<Receita> listaVendas = receitas.stream().filter(x -> x.getData() == date)
				.collect(Collectors.toList());
		System.out.println("--------> LISTA POR DATA: " + listaVendas);
		return 0.;
	}
}
