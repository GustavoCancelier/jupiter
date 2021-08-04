package br.com.gustavo.jupiter.model;

import java.util.SplittableRandom;

public class PessoaFisicaModel extends PessoaModel {

	public PessoaFisicaModel(String documento) {
		super(documento);
	}

	@Override
	public Boolean isDocumentoValido() {
		Integer primeiroVerificador = 0;
		Integer segundoVerificador = 0;
		Integer soma = 0;
		Integer somaSegundo = 0;
		Integer j = 1;
		char[] arrayDoc = super.getDocumento().toCharArray();
		String[] arrayString = new String[arrayDoc.length];
		Integer[] digitosInt = new Integer[arrayDoc.length];
		
		for (int i = 0; i < arrayDoc.length-2; i++) {
			arrayString[i] = String.valueOf(arrayDoc[i]);
			digitosInt[i] = Integer.parseInt(arrayString[i]);
			soma += digitosInt[i] * j;
			j++;
		}
		primeiroVerificador = soma % 11;
		j = 0;
		System.out.println(primeiroVerificador);
		for (int i = 0; i < arrayDoc.length-1; i++) {
			arrayString[i] = String.valueOf(arrayDoc[i]);
			digitosInt[i] = Integer.parseInt(arrayString[i]);
			somaSegundo += digitosInt[i] * j;
			j++;
		}
		segundoVerificador = somaSegundo % 11;
		System.out.println(segundoVerificador);
		
		for (int i = 0; i < digitosInt.length; i++) {
			arrayString[i] = String.valueOf(arrayDoc[i]);
		}
		if (primeiroVerificador.equals(Integer.parseInt(arrayString[9])) && segundoVerificador.equals(Integer.parseInt(arrayString[10]))) {
			return true;
		}
		return false;
	}

	@Override
	public String getGerarDocumento() {
		Integer somaSegundo = 0;
		Integer primeiroVerificador;
		Integer segundoVerificador;
		Integer soma = 0;
		Integer j = 1;
		Integer[] vetor = new Integer [11];
		String[] vetorString = new String[11];
		String cpf = "";
		for (int i = 0; i < 9; i++) {
			 vetor[i] = new SplittableRandom().nextInt(0, 10);
			 
		}
		
		for (int i = 0; i < 9; i++) {
			soma += vetor[i] * j;
			j++;
		}
		primeiroVerificador = soma % 11;
		vetor[9] = primeiroVerificador;
		j = 0;
		
		for (int i = 0; i < vetor.length - 1; i++) {
			somaSegundo += vetor[i] * j;
			j++;
		}
		segundoVerificador = somaSegundo % 11;
		vetor[10] = segundoVerificador;
		
		for (int i = 0; i < vetor.length; i++) {
			vetorString[i] = String.valueOf(vetor[i]);
			cpf += vetorString[i];
		}
		return cpf;
	}

	@Override
	public String getFormatarDocumeno() {
		String cpf = super.getDocumento();
		cpf = cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-" + cpf.substring(9, 11);
		return cpf;
	}
}
