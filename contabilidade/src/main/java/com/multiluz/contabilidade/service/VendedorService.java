package com.multiluz.contabilidade.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multiluz.contabilidade.model.Vendedor;
import com.multiluz.contabilidade.repository.VendedorRepository;

@Service
public class VendedorService {

	@Autowired
	private VendedorRepository vr;
	
	public Vendedor findVendedor(Long id) {
		Optional<Vendedor> o1 = vr.findById(id);
		//if (o1.isPresent()) {...		
		return o1.get();
	}
	
	// documentar os metodos
	public List<Vendedor> vendedorList() {
		List<Vendedor> vendedorList = vr.findAll();
		return vendedorList;
	}

	public Vendedor save(Vendedor vendedor) {
		return vr.save(vendedor);
	}
	
	public Vendedor vendedorUpdate(Vendedor vendedor, Long id) {
		Optional<Vendedor> so = vr.findById(id);
		if(!so.isPresent()) {
			return null;
		}else {
			vendedor.setId(so.get().getId());
			return vr.save(vendedor);
		}
	}
	
	public void vendedorDelete(Long id) {
		vr.deleteById(id);
	}	
	
}
