package br.com.gustavo.jupiter.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.SplittableRandom;

public class CarrinhoModel {
	private Long id;
	private EnumStatusCarrinhoModel status;
	private List<ItemCarrinhoModel> itens;
	
	public CarrinhoModel() {
		this.id = new SplittableRandom().nextLong(10, 1000);
		this.status = EnumStatusCarrinhoModel.OK;
		this.itens = new ArrayList<>();
	}
	
	public void addPerfume(PerfumeModel perfume, Integer quantidade) {
		if (this.status.equals(EnumStatusCarrinhoModel.OK)) {
			this.itens.add(new ItemCarrinhoModel(perfume, quantidade));
		} else {
			throw new RuntimeException ("Carrinho finalizado");
		}
	}
	
	public EnumStatusCarrinhoModel finalizar() {
		this.status = EnumStatusCarrinhoModel.FINALIZADO;
		return status;
	}
	
	public Long getId() {
		return id;
	}

	public EnumStatusCarrinhoModel getStatus() {
		return status;
	}

	public List<ItemCarrinhoModel> getItens() {
		return itens;
	}

	public BigDecimal getValorTotal() {
		BigDecimal soma = BigDecimal.ZERO;
		for (ItemCarrinhoModel i : itens) {
			soma = soma.add(i.getValorTotal());
		}
		return soma;
	}
}
