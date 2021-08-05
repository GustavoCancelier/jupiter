package br.com.gustavo.jupiter.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.gustavo.jupiter.armazena.SalvaDados;
import br.com.gustavo.jupiter.model.EnumTipoPerfumeModel;
import br.com.gustavo.jupiter.model.PerfumeModel;

@RestController
@RequestMapping("/perfume")
public class PerfumeController {
	
	@GetMapping("/cadastrar-perfume")
	public PerfumeModel cadastrarPerfume(@RequestParam(value = "nome") String nome,
										 @RequestParam(value = "valor") BigDecimal valor,
										 @RequestParam(value = "tipo") EnumTipoPerfumeModel tipo) {
		PerfumeModel p = new PerfumeModel(nome, valor, tipo);
		SalvaDados.perfumes.add(p);
		return p;
	}
	
	@GetMapping("/alterar-perfume")
	public PerfumeModel alterarPerfume(@RequestParam(value = "id") Long id,
									   @RequestParam(value = "nome") String nome,
									   @RequestParam(value = "valor") BigDecimal valor,
									   @RequestParam(value = "tipo") EnumTipoPerfumeModel tipo) {
		
		for (PerfumeModel p : SalvaDados.perfumes) {
			if(id.equals(p.getId())) {
				p.alterar(nome, valor, tipo);
				return p;
			}
		}
		return null;
	}
	
	@GetMapping("/remover-perfume")
	public PerfumeModel alterarPerfume(@RequestParam(value = "id") Long id) {
		for (PerfumeModel p : SalvaDados.perfumes) {
			if(id.equals(p.getId())) {
				SalvaDados.perfumes.remove(p);
				return p;
			}
		}
		return null;
	}
	
	@GetMapping("/listar-perfumes")
	public List<PerfumeModel> listar() {
		return SalvaDados.perfumes;
	}
}
