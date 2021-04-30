package com.vacinejaws.entity.dto;

import com.vacinejaws.entity.Vacina;

public class VacinaDto {
	
	private String nome;
	
	public VacinaDto() {
	}

	public VacinaDto(String nome) {
		super();
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Vacina transformaVacina() {
		return new Vacina(nome);
	}


	
}
