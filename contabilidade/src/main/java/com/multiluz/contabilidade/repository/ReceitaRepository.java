package com.multiluz.contabilidade.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.multiluz.contabilidade.dto.ReceitaDiariaDTO;
import com.multiluz.contabilidade.model.Receita;

public interface ReceitaRepository extends JpaRepository<Receita, Long> {

	@Query(value= "select 	data, count(valor) as valor, tipo "
				+ "from		receita "
				+ "where	data = ?1 "
				+ "group by tipo "				
				, nativeQuery = true ) 
	List<ReceitaDiariaDTO> receitaDiaria(LocalDate data);	
	
}
