package com.minsait.livraria.enums;

import java.math.BigDecimal;
import java.math.MathContext;

public enum StatusEnum {
	LANCAMENTO(1) {
		@Override
		public BigDecimal calculaPrecoFinal(BigDecimal valorAtual) {
			BigDecimal fatorMultiplicador = new BigDecimal("1.5");
			return valorAtual.multiply(fatorMultiplicador, MathContext.DECIMAL32);
		}
	},
	
	SALDAO(2) {
		@Override
		public BigDecimal calculaPrecoFinal(BigDecimal valorAtual) {
			BigDecimal fatorMultiplicador = new BigDecimal("0.5");
			return valorAtual.multiply(fatorMultiplicador, MathContext.DECIMAL32);
		}
	},
	
	NORMAL(3) {
		@Override
		public BigDecimal calculaPrecoFinal(BigDecimal valorAtual) {
			BigDecimal fatorMultiplicador = new BigDecimal("1.0");
			return valorAtual.multiply(fatorMultiplicador, MathContext.DECIMAL32);
		}
	};
	
	private int codigo;	
	private StatusEnum(int codigo) {
		this.codigo = codigo;
	}
	
	public int getCodigo() {
		return this.codigo;
	}

	public abstract BigDecimal calculaPrecoFinal(BigDecimal valorAtual);
}
