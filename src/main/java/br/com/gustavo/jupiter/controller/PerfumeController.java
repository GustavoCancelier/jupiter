package br.com.gustavo.jupiter.controller;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.gustavo.jupiter.model.EnumTipoPerfumeModel;
import br.com.gustavo.jupiter.model.PerfumeModel;

@RestController
public class PerfumeController {
	
	@GetMapping("/perfume")
	public PerfumeModel valorPerfume(@RequestParam(value = "nome") String nome,
									@RequestParam(value = "valor") BigDecimal valor) {
		return new PerfumeModel(nome, valor, EnumTipoPerfumeModel.EAU_DE_PARFUM);
	}
}
