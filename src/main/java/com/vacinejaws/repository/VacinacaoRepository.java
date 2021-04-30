package com.vacinejaws.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.vacinejaws.entity.Vacinacao;

public interface VacinacaoRepository extends CrudRepository<Vacinacao, Integer> {
	
	@Query(value = "SELECT uv.id_user_vac, uv.dt_vacinacao,uv.dose, " + 
			"u.id_user, u.nome, u.email, u.cpf, u.dt_nascimento, " + 
			"v.id_vac,v.nome FROM usuario_vacina uv " + 
			"INNER JOIN usuario u ON u.id_user = uv.id_user " + 
			"INNER JOIN vacina v on v.id_vac = uv.id_vac " + 
			"WHERE uv.id_user = :id_user", 
			  nativeQuery = true)
	Iterable<Vacinacao> findByIdUsuario(Integer id);
	
	
}
