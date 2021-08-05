package br.com.gustavo.jupiter.controller;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.gustavo.jupiter.armazena.SalvaDados;
import br.com.gustavo.jupiter.model.CarrinhoModel;
import br.com.gustavo.jupiter.model.PerfumeModel;


@RestController
@RequestMapping("/carrinho")
public class CarrinhoController {
	
	@GetMapping("/add-carrinho")
	public CarrinhoModel valorPerfume(@RequestParam(value = "id") Long id,
									  @RequestParam(value = "quantidade") Integer quantidade) {
		
		PerfumeModel perfume = null;
		for (PerfumeModel p : SalvaDados.perfumes) {
			if(id.equals(p.getId())) {
				perfume = p;
			}
		}
		SalvaDados.carrinho.addPerfume(perfume, quantidade);
		return SalvaDados.carrinho;
	}
	
	@GetMapping("/finalizar-carrinho")
	public CarrinhoModel finalizarCarrinho() {
		CarrinhoModel car = SalvaDados.carrinho;
		car.finalizar();
		SalvaDados.carrinho = new CarrinhoModel();
		return car;
	}
	
	@GetMapping("/mostrar-carrinho")
	public CarrinhoModel mostrarCarrinho() {
		return SalvaDados.carrinho;
	}
	
}
