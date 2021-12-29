package com.multiluz.contabilidade.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multiluz.contabilidade.model.Telefone;
import com.multiluz.contabilidade.repository.TelefoneRepository;

@Service
public class TelefoneService {

	@Autowired
	private TelefoneRepository telRepo;
	
	public void save (Telefone tel) {
		telRepo.save(tel);
	}
}
