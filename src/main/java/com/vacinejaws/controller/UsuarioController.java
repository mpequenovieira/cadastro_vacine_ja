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

import com.vacinejaws.entity.Usuario;
import com.vacinejaws.entity.dto.UsuarioDto;
import com.vacinejaws.service.UsuarioService;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping(path = "/{cpf}")
	public ResponseEntity<?> findByCpf(@PathVariable("cpf") String cpf) {
		try {
			return new ResponseEntity<>(usuarioService.findByCpf(cpf), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Exeception: " + e, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping
	public ResponseEntity<?> listAll() {
		try {
			return new ResponseEntity<>(usuarioService.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Exception: " + e, HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping
	public ResponseEntity<?> save(@RequestBody UsuarioDto usuarioDto) {
		try {
			return new ResponseEntity<>(usuarioService.save(usuarioDto), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>("Exception: " + e, HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping
	public ResponseEntity<?> update(@RequestBody UsuarioDto usuarioDto) {
		try {
			return new ResponseEntity<>(usuarioService.save(usuarioDto), HttpStatus.ACCEPTED);
		} catch (Exception e) {
			return new ResponseEntity<>("Exception: " + e, HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping(path = "/{cpf}")
	public ResponseEntity<?> delete(@PathVariable("cpf") String cpf) {
		try {
			usuarioService.delete(cpf);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Exception: " + e, HttpStatus.BAD_REQUEST);
		}
	}
}