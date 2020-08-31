package com.produto.produto.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.produto.produto.model.Produto;
import com.produto.produto.repository.ProdutoRepository;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/produto")
public class ProdutoController {
	
	public ProdutoController() {
		System.out.println("chamou controller");
	}
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	
	@GetMapping
	public ResponseEntity<Iterable<Produto>> get(){
		return ResponseEntity.ok(produtoRepository.findAll());
		}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Produto> getById(@PathVariable("id") long id) {
		return produtoRepository.findById(id)
		           .map(record -> ResponseEntity.ok().body(record))
		           .orElse(ResponseEntity.notFound().build());
	}
	
			

	@PutMapping("update/{id}")
		public ResponseEntity<Produto> update(@PathVariable("id") long id,
		                                      @RequestBody Produto produto) {
		
		Optional<Produto> produtoOptional = produtoRepository.findById(id);

		if (!produtoOptional.isPresent())
			return ResponseEntity.notFound().build();

		produto.setId(id);
		
		produtoRepository.save(produto);

		return ResponseEntity.noContent().build();
		}
	
	@PostMapping
	public void post(@RequestBody Produto produto) {
		produtoRepository.save(produto);
	}
	
	@DeleteMapping("delete/{id}")
	public void delete(@PathVariable("id") long id) {
		produtoRepository.deleteById(id);
	}
}
	
	
