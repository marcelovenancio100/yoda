package br.com.decolarcli.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.decolarcli.entities.Voo;
import br.com.decolarcli.entities.VooDto;
import br.com.decolarcli.services.VoosCliService;

@RestController
@RequestMapping(value="/vooscli", produces=MediaType.APPLICATION_JSON_VALUE)
public class VoosCliController {
	
	@Autowired
	private VoosCliService voosCliService;
	
	@GetMapping("/voosdisponiveis/{requestid}")
	@ResponseBody
	public List<Voo> get(@PathVariable String requestid) {
		return voosCliService.buscarVoosDisponiveis(requestid);
	}

	@PostMapping("/voosdisponiveis")
	@ResponseBody
	public ResponseEntity<Voo> post(@RequestBody VooDto vooDto) {
		if(vooDto == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
		try {
			voosCliService.adicionarVoosDisponiveis(vooDto);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
}