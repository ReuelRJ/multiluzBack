package com.multiluz.contabilidade.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multiluz.contabilidade.model.Vendedor;
import com.multiluz.contabilidade.repository.VendedorRepository;

@Service
public class VendedorService {

	@Autowired
	private VendedorRepository vendedorRepo;
	
	public void save (Vendedor vendedor) {
		vendedorRepo.save(vendedor);
	}
}
