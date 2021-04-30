package com.vacinejaws.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vacinejaws.entity.Usuario;
import com.vacinejaws.entity.Vacina;
import com.vacinejaws.entity.Vacinacao;
import com.vacinejaws.entity.dto.VacinacaoDto;
import com.vacinejaws.repository.UsuarioRepository;
import com.vacinejaws.repository.VacinaRepository;
import com.vacinejaws.repository.VacinacaoRepository;
import com.vacinejaws.utils.DateUtils;

@Service
public class VacinacaoService {
	
	@Autowired
	private VacinacaoRepository vacinacaoRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private VacinaRepository vacinaRepository;
	
	public VacinacaoDto save(VacinacaoDto vacinacaodto) throws Exception {
		Optional<Usuario> usuario = usuarioRepository.findByCpf(vacinacaodto.getUsuarioDto().getCpf());
		Optional<Vacina> vacina = vacinaRepository.findByNome(vacinacaodto.getVacinaDto().getNome());
		if(usuario.isPresent() && vacina.isPresent()) {
			Vacinacao vacinacao = new Vacinacao(usuario.get(), vacina.get(), DateUtils.toDataHora(vacinacaodto.getDtVacinacao()));
			return vacinacaoRepository.save(vacinacao).transformaVacinacaoDto();
		}else {
			throw new Exception("Usuario ou vacina não encontrado(s)");
		}
		
	}
	
	public List<VacinacaoDto> findByUsuario(String cpf) throws Exception{
		List<VacinacaoDto> vacinacoesDto = new ArrayList<VacinacaoDto>();
		Optional<Usuario> usuario = usuarioRepository.findByCpf(cpf);
		if(usuario.isPresent()) {
			Iterable<Vacinacao> vacinacoes = vacinacaoRepository.findByIdUsuario(usuario.get().getId());
			for (Vacinacao vacinacao : vacinacoes) {
				vacinacoesDto.add(vacinacao.transformaVacinacaoDto());
			}
			return vacinacoesDto;
		}else {
			throw new Exception("Usuario não encontrado");
		}
		
	}
	
	public void delete(Vacinacao vacinacao) {
		vacinacaoRepository.delete(vacinacao);
	}
	
	public List<VacinacaoDto> findAll(){
		List<VacinacaoDto> vacinacoesDto = new ArrayList<VacinacaoDto>();
		Iterable<Vacinacao> vacinacoes = vacinacaoRepository.findAll();
		for (Vacinacao vacinacao : vacinacoes) {
			vacinacoesDto.add(vacinacao.transformaVacinacaoDto());
		}
		return vacinacoesDto;
	}
	
}
