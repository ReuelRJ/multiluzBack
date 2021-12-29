package com.multiluz.contabilidade.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.multiluz.contabilidade.model.Receita;

public interface ReceitaRepository extends JpaRepository<Receita, Long> {

}
