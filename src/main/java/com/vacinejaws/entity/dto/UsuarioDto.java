package com.vacinejaws.entity.dto;

import java.text.ParseException;
import java.util.List;

import com.vacinejaws.entity.Usuario;
import com.vacinejaws.utils.DateUtils;

public class UsuarioDto {

	private String nome;
	private String email;
	private String cpf;
	private String dtNascimento;
	
	public UsuarioDto() {
	}
	
	public UsuarioDto(String nome, String email, String cpf, String dtNascimento) {
		super();
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.dtNascimento = dtNascimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(String dtNascimento) {
		this.dtNascimento = dtNascimento;
	}
	
	public Usuario transformaUsuario() throws ParseException {
		return new Usuario(nome,email,cpf, DateUtils.toDate(dtNascimento));
	}


	
}
