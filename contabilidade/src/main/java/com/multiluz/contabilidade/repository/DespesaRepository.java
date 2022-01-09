package com.multiluz.contabilidade.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.multiluz.contabilidade.dto.DespesaDiariaDTO;
import com.multiluz.contabilidade.model.Despesa;
import com.multiluz.contabilidade.model.Receita;

public interface DespesaRepository extends JpaRepository<Despesa, Long> {

	@Query(value = "select id, data, sum(valor) as valor, tipo, vendedor_id, movimento_id, parcelas "
				+  "from	despesa "
				+  "where	data = ?1 "
				+  "group by tipo ", nativeQuery = true ) 
	List<Despesa> despesaDiariaByTipo(LocalDate data);	
	
	@Query(value = "select id, data, sum(valor) as valor, tipo, vendedor_id, movimento_id, parcelas "
				+  "from	despesa "
				+  "where	data = ?1 "
				+  "group by vendedor_id ", nativeQuery = true ) 
	List<Despesa> despesaDiariaByVendedor(LocalDate data);		
	
	@Query(value = "select id, data, sum(valor) as valor, tipo, vendedor_id, movimento_id, parcelas "
				+  "from	despesa "
				+  "where	data = ?1 "
				+  "group by data ", nativeQuery = true)
	Despesa despesaDiariaTotalGeral(LocalDate data);		
	
}
