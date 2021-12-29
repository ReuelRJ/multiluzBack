package com.multiluz.contabilidade.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.multiluz.contabilidade.model.Vendedor;

public interface VendedorRepository extends JpaRepository<Vendedor, Long> {

	Vendedor findByNome (String nome);
}
