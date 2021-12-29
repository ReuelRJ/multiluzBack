package com.multiluz.contabilidade.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.multiluz.contabilidade.dto.DespesaDiariaDTO;
import com.multiluz.contabilidade.model.Despesa;

public interface DespesaRepository extends JpaRepository<Despesa, Long> {

	@Query(value= "select 	data, count(valor) as valor, tipo "
				+ "from		despesa "
				+ "where	data = ?1 "
				+ "group by tipo "
				, nativeQuery = true ) 
	List<DespesaDiariaDTO> despesaDiaria(LocalDate data);	
	
}
