package com.multiluz.contabilidade.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.multiluz.contabilidade.model.Movimento;

public interface MovimentoRepository extends JpaRepository<Movimento, Long> {

}
