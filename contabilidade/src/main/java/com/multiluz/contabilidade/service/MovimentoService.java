package com.multiluz.contabilidade.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multiluz.contabilidade.model.Movimento;
import com.multiluz.contabilidade.repository.MovimentoRepository;

@Service
public class MovimentoService {


	@Autowired
	private MovimentoRepository movRepo;
	
	public void save (Movimento mov) {
		movRepo.save(mov);
	}
}
