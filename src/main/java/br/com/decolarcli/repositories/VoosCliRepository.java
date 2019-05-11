package br.com.decolarcli.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.decolarcli.entities.Voo;
import br.com.decolarcli.entities.VooDto;

@Repository
public interface VoosCliRepository {

	public List<Voo> buscarVoosDisponiveis(String requestid);
	
	public void adicionarVoosDisponiveis(VooDto vooDto);
}