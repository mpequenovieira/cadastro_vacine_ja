package com.vacinejaws.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.vacinejaws.entity.dto.UsuarioDto;
import com.vacinejaws.entity.dto.VacinaDto;
import com.vacinejaws.entity.dto.VacinacaoDto;
import com.vacinejaws.utils.DateUtils;

@Entity(name = "usuario_vacina")
public class Vacinacao {

	@Id
	@Column(name = "id_user_vac")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@OneToOne
	@JoinColumn(name = "id_user")
	private Usuario usuario;

	@OneToOne
	@JoinColumn(name = "id_vac")
	private Vacina vacina;

	@Column(name = "dt_vacinacao")
	private Date dtVacinacao;
	
	public Vacinacao() {
	}

	public Vacinacao(Usuario usuario, Vacina vacina, Date dtVacinacao) {
		this.usuario = usuario;
		this.vacina = vacina;
		this.dtVacinacao = dtVacinacao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Vacina getVacina() {
		return vacina;
	}

	public void setVacina(Vacina vacina) {
		this.vacina = vacina;
	}

	public Date getDtVacinacao() {
		return dtVacinacao;
	}

	public void setDtVacinacao(Date dtVacinacao) {
		this.dtVacinacao = dtVacinacao;
	}

	public VacinacaoDto transformaVacinacaoDto() {
		UsuarioDto usuarioDto = usuario.transformaUsuarioDto();
		VacinaDto vacinaDto = vacina.transformaVacinaDto();
		return new VacinacaoDto(usuarioDto, vacinaDto, DateUtils.toStringDataHora(dtVacinacao));
	}
	

}