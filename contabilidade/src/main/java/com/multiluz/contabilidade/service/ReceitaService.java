package com.multiluz.contabilidade.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multiluz.contabilidade.model.Receita;
import com.multiluz.contabilidade.repository.ReceitaRepository;

@Service
public class ReceitaService {

	@Autowired
	private ReceitaRepository rr;

	public Receita findReceita(Long id) {
		Optional<Receita> o1 = rr.findById(id);
		// if (o1.isPresent()) {...
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
		if (!so.isPresent()) {
			return null;
		} else {
			receita.setId(so.get().getId());
			return rr.save(receita);
		}
	}

	public void receitaDelete(Long id) {
		rr.deleteById(id);
	}

	/*
	 * //dois metodos para pegar vendas e pegar somatorio de vendas de acordo com o
	 * funcionario
	 * public Double somaVendasPorReceita(List<Receita> valores, String
	 * nomeReceita){
	 * Double somatorioReceita = valores.stream().filter(x ->
	 * x.getReceita().getNome() == nomeReceita).mapToDouble(x ->
	 * x.getValor()).sum();
	 * return somatorioReceita;
	 * }
	 * 
	 * public List<Receita> listaVendasPorReceita (List<Receita> valores, String
	 * nomeReceita){
	 * List<Receita> listVendasReceita = valores.stream().filter(x ->
	 * x.getReceita().getNome() == nomeReceita).collect(Collectors.toList());
	 * return listVendasReceita;
	 * }
	 */
}
