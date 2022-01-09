package com.multiluz.contabilidade.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.multiluz.contabilidade.model.Movimento;
import com.multiluz.contabilidade.model.Receita;

public interface ReceitaRepository extends JpaRepository<Receita, Long> {

	@Query(value = "select id, data, sum(valor) as valor, tipo, vendedor_id, movimento_id, parcelas "
				+  "from	receita "
				+  "where	data = ?1 "
				+  "group by tipo ", nativeQuery = true)
	List<Receita> receitaDiariaByTipo(LocalDate data);

	@Query(value = "select id, data, sum(valor) as valor, tipo, vendedor_id, movimento_id, parcelas "
				+  "from	receita "
				+  "where	data = ?1 "
				+  "group by vendedor_id ", nativeQuery = true)
	List<Receita> receitaDiariaByVendedor(LocalDate data);


	@Query(value = "select id, data, sum(valor) as valor, tipo, vendedor_id, movimento_id, parcelas "
				+  "from	receita "
				+  "where	data = ?1 "
				+  "group by tipo, vendedor_id ", nativeQuery = true)
	List<Receita> receitaDiariaByTipoVendedor(LocalDate data);

	@Query(value = "select id, data, sum(valor) as valor, tipo, vendedor_id, movimento_id, parcelas "
			+  "from	receita "
			+  "where	data = ?1 "
			+  "group by data ", nativeQuery = true)
	Receita receitaDiariaTotalGeral(LocalDate data);	
	
}
