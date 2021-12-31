package com.multiluz.contabilidade.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

	// public Object createMockReceita(int howMany, List<Receita> rec, Vendedor v1) {
	// 	return IntStream.range(0, howMany)
	// 			.mapToObj(i -> new Receita(LocalDate.of(2021, 12, 21), v1))
	// 			.collect(Collectors.toList());
	// }
}
