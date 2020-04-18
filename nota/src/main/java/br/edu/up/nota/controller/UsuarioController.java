package br.edu.up.nota.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.up.nota.entity.Usuario;
import br.edu.up.nota.repository.UsuarioRepository;

@RestController
@RequestMapping("usuario")
public class UsuarioController {
	@Autowired
	private UsuarioRepository repository;
	
	@GetMapping(produces = "application/json")
	public @ResponseBody Iterable<Usuario> listAll(){
		Iterable<Usuario> list = repository.findAll();
		return list;
	}
	@GetMapping("/id={id}")
	public @ResponseBody Usuario getById(@PathVariable Integer Id) {
		Usuario usuario = repository.getOne(Id);
		return usuario;
	}
	
	@PostMapping
	public Usuario add(@RequestBody @Valid Usuario usuario) {
		return repository.save(usuario);
	}
	
	public Usuario delete(@PathVariable Integer id) {
		Usuario usuario = repository.getOne(id);
		repository.delete(usuario);
		return usuario;
	}

	@GetMapping("/email={email}")
	public Usuario GetUsuarioByEmail(@PathVariable String email) {
		Usuario usuario = repository.getUsuarioByEmail(email);
		return usuario;
	}
}