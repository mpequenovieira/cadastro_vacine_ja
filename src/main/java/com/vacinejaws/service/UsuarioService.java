package com.vacinejaws.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vacinejaws.entity.Usuario;
import com.vacinejaws.entity.dto.UsuarioDto;
import com.vacinejaws.repository.UsuarioRepository;
import com.vacinejaws.utils.DateUtils;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public UsuarioDto save(UsuarioDto usuarioDto) throws ParseException {
		Usuario usu = new Usuario();
		Optional<Usuario> usuario = usuarioRepository.findByCpf(usuarioDto.getCpf());
		if (usuario.isPresent()) {
			usu = usuario.get();
		}
		usu.setNome(usuarioDto.getNome());
		usu.setEmail(usuarioDto.getEmail());
		usu.setCpf(usuarioDto.getCpf());
		usu.setDtNascimento(DateUtils.toDate(usuarioDto.getDtNascimento()));
		return usuarioRepository.save(usu).transformaUsuarioDto();
	}

	public UsuarioDto findByCpf(String cpf) throws Exception {
		Optional<Usuario> usuario = usuarioRepository.findByCpf(cpf);
		if (usuario.isPresent()) {
			return usuario.get().transformaUsuarioDto();
		} else {
			throw new Exception("Usuario não encontrado");
		}
	}

	public void delete(String cpf) throws Exception {
		Optional<Usuario> usuario = usuarioRepository.findByCpf(cpf);
		if (usuario.isPresent()) {
			usuarioRepository.delete(usuario.get());
		} else {
			throw new Exception("Usuario não encontrado");
		}

	}

	public List<UsuarioDto> findAll() {
		List<UsuarioDto> usuariosDto = new ArrayList<UsuarioDto>();
		Iterable<Usuario> usuarios = usuarioRepository.findAll();
		for (Usuario usuario : usuarios) {
			usuariosDto.add(usuario.transformaUsuarioDto());
		}
		return usuariosDto;
	}
}
