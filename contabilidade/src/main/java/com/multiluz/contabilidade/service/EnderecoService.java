package com.multiluz.contabilidade.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multiluz.contabilidade.model.Endereco;
import com.multiluz.contabilidade.repository.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository endRepo;
	
	public void save (Endereco end) {
		endRepo.save(end);
	}
}
