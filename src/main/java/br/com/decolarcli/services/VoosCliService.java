package br.com.decolarcli.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.decolarcli.entities.Voo;
import br.com.decolarcli.entities.VooDto;
import br.com.decolarcli.repositories.VoosCliRepository;

@Service
public class VoosCliService {
	
	@Autowired
	private VoosCliRepository voosCliRepository;

	public List<Voo> buscarVoosDisponiveis(String requestid) {
		return voosCliRepository.buscarVoosDisponiveis(requestid);
	}
	
	public void adicionarVoosDisponiveis(VooDto vooDto) {
		voosCliRepository.adicionarVoosDisponiveis(vooDto);
	}
}