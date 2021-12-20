package com.teste.teste;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
//@CrossOrigin("http://localhost:8081")
@CrossOrigin("*")
//@CrossOrigin("https://andecarlosfernandesifrj.github.io")
// CrossOrigin indica de onde está sendo solicitado
public class UsuarioController {

	UsuarioRepository repository;

	@GetMapping("/usuario")
	public List<Usuario> getAllUsuarios() {
		return repository.findAll();
	}

	@PostMapping("/usuario")
	public Usuario saveUsuario(@RequestBody Usuario usuario) {
		return repository.save(usuario);
	}

	@GetMapping("usuario/{id}")
	public Usuario getUsuarioById(@PathVariable Long id) {
		return repository.findById(id).get();              
		//return "Teste!";
	}

}