package br.com.gustavo.jupiter.model;

import java.math.BigDecimal;

public class ItemCarrinhoModel {
	private PerfumeModel perfume;
	private Integer quantidade;
	
	public ItemCarrinhoModel(PerfumeModel perfume, Integer quantidade) {
		this.perfume = perfume;
		this.quantidade = quantidade;
	}

	public PerfumeModel getPerfume() {
		return perfume;
	}

	public Integer getQuantidade() {
		return quantidade;
	}	
	
	public BigDecimal getValorTotal() {
		BigDecimal valorTotal = this.perfume.getValor().multiply(BigDecimal.valueOf(this.quantidade));
		return valorTotal;
	}
}
