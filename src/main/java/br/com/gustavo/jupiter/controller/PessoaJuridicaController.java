package br.com.gustavo.jupiter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import br.com.gustavo.jupiter.model.PessoaJuridicaModel;

@RestController
public class PessoaJuridicaController {
	
	@GetMapping ("/valida-cnpj")
	public Boolean validaCnpj (
			@RequestParam(value = "cnpj")String cnpj) {
		return new PessoaJuridicaModel(cnpj).isDocumentoValido();
	}
	
	@GetMapping("/gerar-juridica")
	public PessoaJuridicaModel gerar(
			@RequestParam(value = "cnpj") String cnpj) {
		return new PessoaJuridicaModel(cnpj);
	}
}
