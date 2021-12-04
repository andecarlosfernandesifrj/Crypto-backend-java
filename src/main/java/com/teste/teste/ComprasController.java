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
//@CrossOrigin("http://localhost:3000")
@CrossOrigin("http://andecarlosfernandesifrj.github.io/crypto:3000")
public class ComprasController {

	ComprasRepository repository;

	@GetMapping("/compras")
	public List<Compras> getAllCompras() {
		return repository.findAll();
	}

	@PostMapping("/compras")
	public Compras saveCompras(@RequestBody Compras compras) {
		return repository.save(compras);
	}

	@GetMapping("compras/{id}")
	public Compras getComprasById(@PathVariable Long id) {
		return repository.findById(id).get();              
		//return "Teste!";
	}
	
	@DeleteMapping("/compras/{id}")
	public void deleteCompras(@PathVariable Long id) {
		repository.deleteById(id);
	}

	@PutMapping("/compras/{id}")
	public Compras updateCompras(@PathVariable Long id, @RequestBody Compras compra) {
		Compras compraAtual = repository.findById(id).get();
		BeanUtils.copyProperties(compra, compraAtual, "id");
		return repository.save(compraAtual);
	}
}