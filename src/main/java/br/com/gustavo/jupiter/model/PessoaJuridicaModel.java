package br.com.gustavo.jupiter.model;

import java.util.SplittableRandom;

public class PessoaJuridicaModel extends PessoaModel {
	
	public PessoaJuridicaModel(String documento) {
		super(documento);
	}

	@Override
	public Boolean isDocumentoValido() {
		Integer primeiroVerificador = 0;
		Integer segundoVerificador = 0;
		Integer oitavoDig = 0;
		Integer soma = 0;
		Integer somaSegundo = 0;
		Integer somaOitavo = 0;
		Integer j = 6;
		char[] arrayDoc = super.getDocumento().toCharArray();
		String[] arrayString = new String[arrayDoc.length];
		Integer[] digitosInt = new Integer[arrayDoc.length];
		
		for (int i = 0; i < arrayDoc.length-2; i++) {
			arrayString[i] = String.valueOf(arrayDoc[i]);
			digitosInt[i] = Integer.parseInt(arrayString[i]);
			soma += digitosInt[i] * j;
			j++;
			if (j > 9) {
				j = 2;
			}
		}
		primeiroVerificador = soma % 11;
		j = 5;
		System.out.println(primeiroVerificador);
		
		for (int i = 0; i < arrayDoc.length-1; i++) {
			arrayString[i] = String.valueOf(arrayDoc[i]);
			digitosInt[i] = Integer.parseInt(arrayString[i]);
			somaSegundo += digitosInt[i] * j;
			j++;
			if (j > 9) {
				j = 2;
			}
		}
		segundoVerificador = somaSegundo % 11;
		System.out.println(segundoVerificador);
		
		j = 2;
		for (int i = 0; i < arrayDoc.length-6; i++) {
			arrayString[i] = String.valueOf(arrayDoc[i]);
			digitosInt[i] = Integer.parseInt(arrayString[i]);
			somaOitavo += digitosInt[i] * j;
			//System.out.println(somaOitavo);
			if (j == 2) {
				j = 1;
			} else if (j == 1) {
				j = 2;
			}
		}
		//System.out.println(somaOitavo);
		oitavoDig = 30 - somaOitavo;
		//System.out.println(oitavoDig);
		for (int i = 0; i < digitosInt.length; i++) {
			arrayString[i] = String.valueOf(arrayDoc[i]);
		}
		if (primeiroVerificador.equals(Integer.parseInt(arrayString[12])) && segundoVerificador.equals(Integer.parseInt(arrayString[13]))) {
			return true;
		}
		return false;
	}

	@Override
	public String getGerarDocumento() {
		Integer primeiroVerificador;
		Integer segundoVerificador;
		Integer soma = 0;
		Integer somaSegundo = 0;
		Integer j = 6;
		Integer[] vetor = new Integer [14];
		String[] vetorString = new String[14];
		String cnpj = "";
		for (int i = 0; i < 12; i++) {
			 vetor[i] = new SplittableRandom().nextInt(0, 10);
		}
		
		for (int i = 0; i < vetor.length-2; i++) {
			soma += vetor[i] * j;
			j++;
			if (j > 9) {
				j = 2;
			}
		}
		
		primeiroVerificador = soma % 11;
		vetor[12] = primeiroVerificador;
		j = 5;
		
		for (int i = 0; i < vetor.length-1; i++) {
			somaSegundo += vetor[i] * j;
			j++;
			if (j > 9) {
				j = 2;
			}
		}
		
		segundoVerificador = somaSegundo % 11;
		vetor[13] = segundoVerificador;
		
		for (int i = 0; i < vetor.length; i++) {
			vetorString[i] = String.valueOf(vetor[i]);
			cnpj += vetorString[i];
		}
		return cnpj;
	}

	@Override
	public String getFormatarDocumeno() {
		String cnpj = super.getDocumento();
		cnpj = cnpj.substring(0, 2) + "." + cnpj.substring(2, 5) + "." + cnpj.substring(5, 8) + "/" + cnpj.substring(8, 12) + "-" + cnpj.substring(12, 14);
		return cnpj;
	}
}
