package com.vacinejaws.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.vacinejaws.entity.Vacina;

public interface VacinaRepository extends CrudRepository<Vacina, Integer> {

	Optional<Vacina> findByNome(String nome);
}
