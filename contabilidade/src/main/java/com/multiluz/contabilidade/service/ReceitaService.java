package com.multiluz.contabilidade.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multiluz.contabilidade.model.Receita;
import com.multiluz.contabilidade.repository.ReceitaRepository;

@Service
public class ReceitaService {


	@Autowired
	private ReceitaRepository receRepo;
	
	public void save (Receita rece) {
		receRepo.save(rece);
	}
}
