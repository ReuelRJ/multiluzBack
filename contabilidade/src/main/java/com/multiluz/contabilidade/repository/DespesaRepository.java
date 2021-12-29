package com.multiluz.contabilidade.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.multiluz.contabilidade.model.Despesa;

public interface DespesaRepository extends JpaRepository<Despesa, Long> {

}
