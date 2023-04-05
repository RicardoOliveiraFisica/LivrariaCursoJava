package com.minsait.livraria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minsait.livraria.entity.Livro;
import com.minsait.livraria.exception.LivroNaoEncontradoException;
import com.minsait.livraria.repository.LivroRepository;

@Service
public class LivroService {
	
	private LivroRepository livroRepository;
	
	
	@Autowired	
	public LivroService(LivroRepository livroRepository) {
		this.livroRepository = livroRepository;
		
	}

	
	public Livro cadastrarLivro(Livro livro) {
		livro.setValorFinal();
		return this.livroRepository.save(livro);
	}
	
	public List<Livro> retornarTodosOsLivros() { //prestar atencao aqui na importcao (tem q ser java.util)
		return this.livroRepository.findAll();
	}
	
	public Livro retornarLivro(Long id) throws LivroNaoEncontradoException {
		if (this.livroRepository.existsById(id))
			return this.livroRepository.findById(id).get();
		throw new LivroNaoEncontradoException(id);
	}


	public Livro alterarLivro(Long id, Livro livro) throws LivroNaoEncontradoException {
		if (this.livroRepository.existsById(id)) {
			Livro livroASerAlterado = this.livroRepository.findById(id).get();
			livro.setId(id);
			if (livro.getTitulo() == null)
				livro.setTitulo(livroASerAlterado.getTitulo());
			if (livro.getAno() == null)
				livro.setAno(livroASerAlterado.getAno());
			if (livro.getQuantidade() == null)
				livro.setQuantidade(livroASerAlterado.getQuantidade());
			if (livro.getValorUnitario() == null)
				livro.setValorUnitario(livroASerAlterado.getValorUnitario());
			if (livro.getStatus() == null)
				livro.setStatus(livroASerAlterado.getStatus());

			livro.setValorFinal();
			return this.livroRepository.save(livro);
		}
		throw new LivroNaoEncontradoException(id);
	}
	
	public MensagemDeSucesso deletarLivro(Long id) throws LivroNaoEncontradoException {
		if (this.livroRepository.existsById(id)) {
			this.livroRepository.deleteById(id);
			MensagemDeSucesso mensagem = new MensagemDeSucesso("Deletado com sucesso");
			return mensagem;
		}
		
		throw new LivroNaoEncontradoException(id);
	}

}
