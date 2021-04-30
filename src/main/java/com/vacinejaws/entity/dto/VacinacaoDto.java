package com.vacinejaws.entity.dto;

import java.text.ParseException;

import com.vacinejaws.entity.Usuario;
import com.vacinejaws.entity.Vacina;
import com.vacinejaws.entity.Vacinacao;
import com.vacinejaws.utils.DateUtils;

public class VacinacaoDto {
	
	private UsuarioDto usuarioDto;
	private VacinaDto vacinaDto;
	private String dtVacinacao;
	
	public VacinacaoDto() {
	}
	
	public VacinacaoDto(UsuarioDto usuarioDto, VacinaDto vacinaDto, String dtVacinacao) {
		this.usuarioDto = usuarioDto;
		this.vacinaDto = vacinaDto;
		this.dtVacinacao = dtVacinacao;
	}

	public UsuarioDto getUsuarioDto() {
		return usuarioDto;
	}

	public void setUsuarioDto(UsuarioDto usuarioDto) {
		this.usuarioDto = usuarioDto;
	}

	public VacinaDto getVacinaDto() {
		return vacinaDto;
	}

	public void setVacinaDto(VacinaDto vacinaDto) {
		this.vacinaDto = vacinaDto;
	}

	public String getDtVacinacao() {
		return dtVacinacao;
	}

	public void setDtVacinacao(String dtVacinacao) {
		this.dtVacinacao = dtVacinacao;
	}

	public Vacinacao transformaVacinacao() throws ParseException {
		Usuario usuario = usuarioDto.transformaUsuario();
		Vacina vacina = vacinaDto.transformaVacina();
		return new Vacinacao(usuario, vacina, DateUtils.toDataHora(dtVacinacao));
		
	}
	
}
