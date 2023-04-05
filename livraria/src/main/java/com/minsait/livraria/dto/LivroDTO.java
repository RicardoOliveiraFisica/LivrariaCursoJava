package com.minsait.livraria.dto;

import java.math.BigDecimal;

import com.minsait.livraria.entity.Livro;
import com.minsait.livraria.enums.StatusEnum;

public class LivroDTO {
	private String titulo;	
	private Integer ano;
	private Integer quantidade;
	private BigDecimal valorUnitario;
	private BigDecimal valorFinal;
	private StatusEnum status;
	
	public LivroDTO() {
		
	}
	
	public LivroDTO(String titulo, Integer ano, Integer quantidade, BigDecimal valorUnitario, StatusEnum status) {
		super();
		this.titulo = titulo;
		this.ano = ano;
		this.quantidade = quantidade;
		this.valorUnitario = valorUnitario;
		this.status = status;
	}
	
	public LivroDTO(Livro livro) {
		super();
		this.titulo = livro.getTitulo();
		this.ano = livro.getAno();
		this.quantidade = livro.getQuantidade();
		this.valorUnitario = livro.getValorUnitario();
		this.status = livro.getStatus();
		this.valorFinal = livro.getValorFinal();
	}
			
	public static LivroDTO retornalivro(Livro livro) {
		LivroDTO livroDTO = new LivroDTO(livro);
		return livroDTO;
	}
		
	
	public static Livro retornalivro(LivroDTO livroDTO) {
		Livro livro = new Livro(livroDTO.getTitulo(), livroDTO.getAno(), livroDTO.getQuantidade(), livroDTO.getValorUnitario(), livroDTO.getStatus());
		return livro;
		
	}


	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	
	public BigDecimal getValorFinal() {
		return valorFinal;
	}

	public void setValorFinal() {
		if (this.valorUnitario != null) {
			this.valorFinal = this.status.calculaPrecoFinal(valorUnitario);
		}
	}

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}
			
}
