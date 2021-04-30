package com.vacinejaws.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vacinejaws.entity.Vacina;
import com.vacinejaws.entity.dto.VacinaDto;
import com.vacinejaws.repository.VacinaRepository;

@Service
public class VacinaService {

	@Autowired
	private VacinaRepository vacinaRepository;

	public VacinaDto save(VacinaDto vacinaDto) {
		return vacinaRepository.save(vacinaDto.transformaVacina()).transformaVacinaDto();
	}

	public VacinaDto findByNome(String nome) throws Exception {
		Optional<Vacina> vacina = vacinaRepository.findByNome(nome);
		if (vacina.isPresent()) {
			return vacina.get().transformaVacinaDto();
		} else {
			throw new Exception("Vacina não encontrada");
		}
	}

	public void delete(String nome) throws Exception {
		Optional<Vacina> vacina = vacinaRepository.findByNome(nome);
		if (vacina.isPresent()) {
			vacinaRepository.delete(vacina.get());
		} else {
			throw new Exception("Vacina não encontrada");
		}
	}

	public List<VacinaDto> findAll() {
		List<VacinaDto> vacinasDto = new ArrayList<VacinaDto>();
		Iterable<Vacina> vacinas = vacinaRepository.findAll();
		for (Vacina vacina : vacinas) {
			vacinasDto.add(vacina.transformaVacinaDto());
		}
		return vacinasDto;
	}
}
