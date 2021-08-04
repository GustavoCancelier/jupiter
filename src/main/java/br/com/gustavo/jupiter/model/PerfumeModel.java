package br.com.gustavo.jupiter.model;

import java.math.BigDecimal;
import java.util.SplittableRandom;

public class PerfumeModel {
	private Long id;
	private String nome;
	private BigDecimal valor;
	private EnumTipoPerfumeModel tipo;
	
	public PerfumeModel(String nome, BigDecimal valor, EnumTipoPerfumeModel tipo) {
		this.id = new SplittableRandom().nextLong(10, 100);
		this.nome = nome;
		this.valor = valor;
		this.tipo = tipo;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public EnumTipoPerfumeModel getTipo() {
		return tipo;
	}
	
}
