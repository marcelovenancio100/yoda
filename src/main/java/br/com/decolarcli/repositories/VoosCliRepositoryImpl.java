package br.com.decolarcli.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.decolarcli.entities.Voo;
import br.com.decolarcli.entities.VooDto;

@Repository
public class VoosCliRepositoryImpl implements VoosCliRepository {
	public static List<VooDto> VOOS_DISPONIVEIS_DB = new ArrayList<>();

	@Override
	public List<Voo> buscarVoosDisponiveis(String requestid) {
		return VOOS_DISPONIVEIS_DB.stream().filter(x -> x.getRequestid().equals(requestid)).map(x -> x.getVoos()).findAny().orElse(null);
	}

	@Override
	public void adicionarVoosDisponiveis(VooDto vooDto) {
		if(vooDto == null || vooDto.getRequestid() == null) return;
		VOOS_DISPONIVEIS_DB.add(vooDto);
	}
}