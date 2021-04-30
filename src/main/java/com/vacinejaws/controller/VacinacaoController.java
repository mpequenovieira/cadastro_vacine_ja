package com.vacinejaws.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vacinejaws.entity.Vacinacao;
import com.vacinejaws.entity.dto.VacinacaoDto;
import com.vacinejaws.service.VacinacaoService;

@RestController
@RequestMapping("/api/vacinacao")
public class VacinacaoController {

	@Autowired
	private VacinacaoService vacinacaoService;

	@GetMapping(path = "/{cpf}")
	public ResponseEntity<?> findByUsuario(@PathVariable("id") String cpf) {
		try {
			List<VacinacaoDto> vacinacoes = vacinacaoService.findByUsuario(cpf);
			return new ResponseEntity<>(vacinacoes, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Exeception: " + e, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping
	public ResponseEntity<?> listAll() {
		try {
			return new ResponseEntity<>(vacinacaoService.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Exception: " + e, HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping
	public ResponseEntity<?> save(@RequestBody VacinacaoDto vacinacaoDto) {
		try {
			return new ResponseEntity<>(vacinacaoService.save(vacinacaoDto), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>("Exception: " + e, HttpStatus.BAD_REQUEST);
		}
	}

}
