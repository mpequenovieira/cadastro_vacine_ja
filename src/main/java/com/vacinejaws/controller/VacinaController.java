package com.vacinejaws.controller;

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

import com.vacinejaws.entity.Vacina;
import com.vacinejaws.entity.dto.VacinaDto;
import com.vacinejaws.service.VacinaService;

@RestController
@RequestMapping("/api/vacina")
public class VacinaController {

	@Autowired
	private VacinaService vacinaService;

	@GetMapping(path = "/{nome}")
	public ResponseEntity<?> findByNome(@PathVariable("nome") String nome) {
		try {
			VacinaDto vacina = vacinaService.findByNome(nome);
			return new ResponseEntity<>(vacina, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Exeception: " + e, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping
	public ResponseEntity<?> listAll() {
		try {
			return new ResponseEntity<>(vacinaService.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Exception: " + e, HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping
	public ResponseEntity<?> save(@RequestBody VacinaDto vacinaDto) {
		try {
			return new ResponseEntity<>(vacinaService.save(vacinaDto), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>("Exception: " + e, HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping
	public ResponseEntity<?> update(@RequestBody VacinaDto vacinaDto) {
		try {
			return new ResponseEntity<>(vacinaService.save(vacinaDto), HttpStatus.ACCEPTED);
		} catch (Exception e) {
			return new ResponseEntity<>("Exception: " + e, HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping(path = "/{nome}")
	public ResponseEntity<?> delete(@PathVariable String nome) {
		try {
			vacinaService.delete(nome);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Exception: " + e, HttpStatus.BAD_REQUEST);
		}
	}
}
