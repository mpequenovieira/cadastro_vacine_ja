package com.vacinejaws.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.vacinejaws.entity.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer>{

	Optional<Usuario> findByEmail(String email);
	Optional<Usuario> findByCpf(String cpf);
}
