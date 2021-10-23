package com.pharmacy.farmacia.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pharmacy.farmacia.models.Categoria;
import com.pharmacy.farmacia.repository.CategoriaRepository;

@RestController
@RequestMapping ("/categoria")
@CrossOrigin("*")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository repository;
	
	public @GetMapping ("/todas-categorias") List<Categoria> findAllCategoria(){
		return repository.findAll();
	}
	
	@GetMapping ("/{id}")
	public ResponseEntity<Categoria>GetById(@PathVariable long id){
		
		return repository.findById(id).map (resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping ("/descricao/{descricao}")
	public ResponseEntity<List<Categoria>> GetByDescricao(@PathVariable String descricao){
		
		return ResponseEntity.ok(repository.findAllByDescricaoContainingIgnoreCase(descricao));
	}
	
	@GetMapping ("/categoria/{categoria}")
	public ResponseEntity<List<Categoria>> GetBycategoria(@PathVariable String categoria){
		
		return ResponseEntity.ok(repository.findAllByCategoriaContainingIgnoreCase(categoria));
	}
	
	public @PostMapping ResponseEntity<Categoria> post (@RequestBody Categoria Categoria){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(Categoria));
	}
	
	public @PutMapping ResponseEntity<Categoria> put (@RequestBody Categoria categoria){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(categoria));
	}
	
	@DeleteMapping ("/{id}")
	public void delete (@PathVariable long id){
		repository.deleteById(id);
	}
	

}
