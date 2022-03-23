package com.multiluz.contabilidade.controller;

import java.util.List;

import com.multiluz.contabilidade.dto.DespesaDiariaDTO;
import com.multiluz.contabilidade.dto.ReceitaDiariaDTO;
import com.multiluz.contabilidade.model.Movimento;
import com.multiluz.contabilidade.service.DespesaService;
import com.multiluz.contabilidade.service.MovimentoService;
import com.multiluz.contabilidade.service.ReceitaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/v1")
public class MovimentoController {

	private final MovimentoService ms;

	private final ReceitaService rs;

	private final DespesaService ds;

	// RECURSOS

	@GetMapping(value = "/movimentos/receita/{data}")
	public ResponseEntity<List<ReceitaDiariaDTO>> fechaMovimentoReceita(@PathVariable String data) {
		List<ReceitaDiariaDTO> receitaDiaria = ms.fechaMovimentoReceita(data);
		return (receitaDiaria == null) ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
				: new ResponseEntity<List<ReceitaDiariaDTO>>(receitaDiaria, HttpStatus.OK);
	}

	@GetMapping(value = "/movimentos/despesa/{data}")
	public ResponseEntity<List<DespesaDiariaDTO>> fechaMovimentoDespesa(@PathVariable String data) {
		List<DespesaDiariaDTO> despesaDiaria = ms.fechaMovimentoDespesa(data);
		return (despesaDiaria == null) ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
				: new ResponseEntity<List<DespesaDiariaDTO>>(despesaDiaria, HttpStatus.OK);
	}

	@GetMapping(value = "/movimentos/{data}")
	public ResponseEntity<Movimento> fechaMovimento(@PathVariable String data) {
		Movimento movimento = ms.fechaMovimento(data);
		return (movimento == null) ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
				: new ResponseEntity<Movimento>(movimento, HttpStatus.OK);

	}

	/*
	 * @PostMapping("/movimentos")
	 * public Movimento createMovimento(@RequestBody Movimento movimento) {
	 * return ms.movimentoSave(movimento);
	 * }
	 * 
	 * @PutMapping("/movimentos/{id}")
	 * public ResponseEntity<Movimento> updateMovimento(@PathVariable(value="id")
	 * long id,
	 * 
	 * @RequestBody @Valid Movimento movimento) {
	 * Movimento s = ms.movimentoUpdate(movimento, id);
	 * if(s == null) {
	 * return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	 * } else {
	 * return new ResponseEntity<Movimento>(s, HttpStatus.OK);
	 * }
	 * }
	 * 
	 * @DeleteMapping("/movimentos/{id}")
	 * void deleteMovimento(@PathVariable Long id) {
	 * ms.movimentoDelete(id);
	 * }
	 * 
	 */
}
