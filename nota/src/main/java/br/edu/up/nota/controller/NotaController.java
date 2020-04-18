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

import br.edu.up.nota.entity.Nota;
import br.edu.up.nota.repository.NotaRepository;

@RestController
@RequestMapping("nota")
public class NotaController {
	@Autowired
	private NotaRepository repository;
	
	@GetMapping(produces = "application/json")
	public @ResponseBody Iterable<Nota> listAll(){
		Iterable<Nota> list = repository.findAll();
		return list;
	}
	@GetMapping("/{id}")
	public @ResponseBody Nota getById(@PathVariable Integer Id) {
		Nota nota = repository.getOne(Id);
		return nota;
	}
	
	@PostMapping
	public Nota add(@RequestBody @Valid Nota nota) {
		return repository.save(nota);
	}
	
	public Nota delete(@PathVariable Integer id) {
		Nota nota = repository.getOne(id);
		repository.delete(nota);
		return nota;
	}
	@GetMapping("/cor={cor}")
	public @ResponseBody Iterable<Nota> getAllByValor(@PathVariable double valor) {
		Iterable<Nota> nota = repository.getAllByValor(valor);
		return nota;
	}
}