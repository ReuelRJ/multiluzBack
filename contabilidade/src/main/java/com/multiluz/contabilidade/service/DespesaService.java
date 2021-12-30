package com.multiluz.contabilidade.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multiluz.contabilidade.model.Despesa;
import com.multiluz.contabilidade.repository.DespesaRepository;


@Service
public class DespesaService {


	@Autowired
	private DespesaRepository DespesaRepo;

	public void save (Despesa despo) {
		DespesaRepo.save(despo);
	}
	
}
