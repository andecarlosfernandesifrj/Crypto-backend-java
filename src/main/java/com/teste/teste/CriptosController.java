package com.teste.teste;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@CrossOrigin("http://localhost:3000")
//@CrossOrigin("http://andecarlosfernandesifrj.github.io/crypto:3000")

public class CriptosController {

	CriptosRepository repository;

	@GetMapping("/criptos")
	public List<Criptos> getAllCriptos() {
		return repository.findAll();
	}

	@PostMapping("/criptos")
	public Criptos saveCriptos(@RequestBody Criptos criptos) {
		return repository.save(criptos);
	}

	@GetMapping("criptos/{id}")
	public Criptos getCriptosById(@PathVariable Long id) {
		return repository.findById(id).get();              
		//return "Teste!";
	}
	
	@DeleteMapping("/criptos/{id}")
	public void deleteCriptos(@PathVariable Long id) {
		repository.deleteById(id);
	}

	@PutMapping("/criptos/{id}")
	public Criptos updateCriptos(@PathVariable Long id, @RequestBody Criptos cripto) {
		Criptos criptoAtual = repository.findById(id).get();
		BeanUtils.copyProperties(cripto, criptoAtual, "id");
		return repository.save(criptoAtual);
	}
}