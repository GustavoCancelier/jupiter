package br.com.gustavo.jupiter.armazena;

import java.util.ArrayList;
import java.util.List;

import br.com.gustavo.jupiter.model.CarrinhoModel;
import br.com.gustavo.jupiter.model.PerfumeModel;

public class SalvaDados {
	
	private SalvaDados() {
		
	}
	
	public static List<PerfumeModel> perfumes = new ArrayList<>();
	public static CarrinhoModel carrinho = new CarrinhoModel();
}
