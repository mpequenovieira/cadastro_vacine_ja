package com.vacinejaws.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import com.vacinejaws.entity.dto.UsuarioDto;
import com.vacinejaws.utils.DateUtils;

@Entity
public class Usuario {

	@Id
	@Column(name = "id_user")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "name")
	@NotBlank(message = "Campo nome obrigatório")
	private String nome;

	@NotBlank(message = "Campo email obrigatório")
	@Email
	private String email;

	@CPF
	private String cpf;

	@Column(name = "dt_nascimento")
	@NotBlank(message = "Campo \"Data de Nascimento\" obrigatório")
	private Date dtNascimento;

	public Usuario() {

	}

	public Usuario(String nome, String email, String cpf, Date dtNascimento) {
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.dtNascimento = dtNascimento;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Date getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}
	
	public UsuarioDto transformaUsuarioDto() {
		return new UsuarioDto(nome, email, cpf, DateUtils.toString(dtNascimento));
	}

}
