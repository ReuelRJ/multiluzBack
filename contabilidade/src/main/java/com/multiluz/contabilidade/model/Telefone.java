package com.multiluz.contabilidade.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Telefone {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Integer ddd;
	
	private Integer telRes;
	
	private Integer telCel;

}
