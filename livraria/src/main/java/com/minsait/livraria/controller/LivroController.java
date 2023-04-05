package com.minsait.livraria.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.minsait.livraria.dto.LivroDTO;
import com.minsait.livraria.entity.Livro;
import com.minsait.livraria.exception.LivroNaoEncontradoException;
import com.minsait.livraria.service.LivroService;
import com.minsait.livraria.service.MensagemDeSucesso;

@CrossOrigin("*")
@RestController
@RequestMapping("api/v1/livraria/livros")
public class LivroController {
	
	private LivroService livroService;	
	
	@Autowired
	public LivroController(LivroService livroService) {
		this.livroService = livroService;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Livro cadastrarLivro(@Valid @RequestBody Livro livro) {
		return this.livroService.cadastrarLivro(livro);
	}
	
	@GetMapping
	public List<Livro> retornarTodosOsLivros() {
		return this.livroService.retornarTodosOsLivros();
	}
	
	@GetMapping("/{id}")
	public Livro retornarLivro( @PathVariable Long id ) throws LivroNaoEncontradoException {
		return this.livroService.retornarLivro(id);
	}
	
	@PutMapping("/{id}")
	public LivroDTO alterarLivro( @PathVariable Long id, @Valid @RequestBody LivroDTO livroDTO ) throws LivroNaoEncontradoException {
		
		//transformacao de livroDTO para livro
		Livro livroRequest = LivroDTO.retornalivro(livroDTO);
		Livro livroAlterado = this.livroService.alterarLivro(id, livroRequest);
				
		//transformacao de livro para livroDTO
		return LivroDTO.retornalivro(livroAlterado);
	}
	
	/*@DeleteMapping("/{id}")
	//@ResponseStatus(HttpStatus.NO_CONTENT)
	public MensagemDeSucesso deletarLivro( @PathVariable Long id ) throws LivroNaoEncontradoException {
		return this.livroService.deletarLivro(id);
	}*/
	
	//@ResponseStatus(HttpStatus.NO_CONTENT)
	@ResponseStatus(HttpStatus.CREATED)
	@DeleteMapping("/{id}")
	public MensagemDeSucesso deletarLivro(@PathVariable Long id) throws LivroNaoEncontradoException {
		return this.livroService.deletarLivro(id);
	}
}
