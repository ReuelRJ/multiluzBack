package com.multiluz.contabilidade.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multiluz.contabilidade.dto.DespesaDiariaDTO;
import com.multiluz.contabilidade.dto.ReceitaDiariaDTO;
import com.multiluz.contabilidade.model.Movimento;
import com.multiluz.contabilidade.repository.DespesaRepository;
import com.multiluz.contabilidade.repository.MovimentoRepository;
import com.multiluz.contabilidade.repository.ReceitaRepository;

@Service
public class MovimentoService {


	@Autowired
	private MovimentoRepository mr;
	
	@Autowired
	private ReceitaRepository rr;
	
	@Autowired
	private DespesaRepository dr;	
	
	public void save (Movimento mov) {
		mr.save(mov);
	}
	
	public List<ReceitaDiariaDTO> fechaMovimentoReceita(LocalDate data) {
		
		List<ReceitaDiariaDTO> lista = rr.receitaDiaria(data);
		
		return lista;
	}
	
	public List<DespesaDiariaDTO> fechaMovimentoDespesa(LocalDate data) {
		
		List<DespesaDiariaDTO> lista = dr.despesaDiaria(data);
		
		return lista;
	}
	
	
}
