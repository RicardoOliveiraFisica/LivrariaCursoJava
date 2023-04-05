package com.minsait.livraria.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

import com.minsait.livraria.enums.StatusEnum;

@Entity
public class Livro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "O título não pode ser nulo")
	private String titulo;
	
	@NotNull(message = "O ano não pode ser nulo")
	@Range(min = 1)
	private Integer ano;
	private Integer quantidade;
	private BigDecimal valorUnitario;
	private BigDecimal valorFinal;
	private StatusEnum status;
	
	public Livro() {
		
	}
	
	public Livro(String titulo, Integer ano, Integer quantidade, BigDecimal valorUnitario, StatusEnum status) {
		super();
		this.titulo = titulo;
		this.ano = ano;
		this.quantidade = quantidade;
		this.valorUnitario = valorUnitario;
		this.status = status;
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
	
	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
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

	public String getTitulo() {
		return titulo;
	}
		
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}	
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}	
	
}
