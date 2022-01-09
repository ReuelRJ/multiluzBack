package com.multiluz.contabilidade.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multiluz.contabilidade.model.Despesa;
import com.multiluz.contabilidade.repository.DespesaRepository;


@Service
public class DespesaService {


	@Autowired
	private DespesaRepository dr;
	
	public Despesa findDespesa(Long id) {
		Optional<Despesa> o1 = dr.findById(id);
		//if (o1.isPresent()) {...		
		return o1.get();
	}
	
	// documentar os metodos
	public List<Despesa> despesaList() {
		List<Despesa> despesaList = dr.findAll();
		return despesaList;
	}

	public Despesa save(Despesa despesa) {
		return dr.save(despesa);
	}
	
	public Despesa despesaUpdate(Despesa despesa, Long id) {
		Optional<Despesa> so = dr.findById(id);
		if(!so.isPresent()) {
			return null;
		}else {
			despesa.setId(so.get().getId());
			return dr.save(despesa);
		}
	}
	
	public void despesaDelete(Long id) {
		dr.deleteById(id);
	}	
	
}
