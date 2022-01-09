package com.multiluz.contabilidade.service;

<<<<<<< HEAD
import java.time.LocalDate;
import java.util.Collection;
=======
>>>>>>> a52942f102d45b847cdee576857deb6b00d4c064
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
<<<<<<< HEAD
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.multiluz.contabilidade.model.Receita;
import com.multiluz.contabilidade.model.Vendedor;
import com.multiluz.contabilidade.repository.ReceitaRepository;
=======
>>>>>>> a52942f102d45b847cdee576857deb6b00d4c064

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multiluz.contabilidade.model.Receita;
import com.multiluz.contabilidade.repository.ReceitaRepository;

@Service
public class ReceitaService {

	@Autowired
	private ReceitaRepository rr;

<<<<<<< HEAD
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
=======
	public Receita findReceita(Long id) {
		Optional<Receita> o1 = rr.findById(id);
		//if (o1.isPresent()) {...		
		return o1.get();
	}

	// documentar os metodos
	public List<Receita> receitaList() {
		List<Receita> receitaList = rr.findAll();
		return receitaList;
	}

	public Receita save(Receita receita) {
		return rr.save(receita);
	}

	public Receita receitaUpdate(Receita receita, Long id) {
		Optional<Receita> so = rr.findById(id);
		if(!so.isPresent()) {
			return null;
		}else {
			receita.setId(so.get().getId());
			return rr.save(receita);
		}
	}

	public void receitaDelete(Long id) {
		rr.deleteById(id);
	}	

	/*
	//dois metodos para pegar vendas e pegar somatorio de vendas de acordo com o funcionario
	public Double somaVendasPorReceita(List<Receita> valores, String nomeReceita){
		Double somatorioReceita = valores.stream().filter(x -> x.getReceita().getNome() == nomeReceita).mapToDouble(x -> x.getValor()).sum();
		return somatorioReceita;
	}

	public List<Receita> listaVendasPorReceita (List<Receita> valores, String nomeReceita){
		List<Receita> listVendasReceita = valores.stream().filter(x -> x.getReceita().getNome() == nomeReceita).collect(Collectors.toList());
		return listVendasReceita;
	}
	*/
>>>>>>> a52942f102d45b847cdee576857deb6b00d4c064
}
